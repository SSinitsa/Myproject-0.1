package com.ssinitsa.training.culinary.dao.impl.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ssinitsa.training.culinary.dao.impl.db.IRecipeDao;
import com.ssinitsa.training.culinary.datamodel.Recipe;

@Repository
public class RecipeDaoImpl implements IRecipeDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Recipe get(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from recipe where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<Recipe>(Recipe.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Recipe insert(Recipe entity) {
		final String INSERT_SQL = "insert into recipe (name, description, author_id, created, rating, feedback_id, category_id) values(?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, entity.getName());
				ps.setString (2, entity.getDescription());
				ps.setInt (3, entity.getAuthorId());
				ps.setTimestamp (4, entity.getCreated());
				ps.setInt (5, entity.getRating());
				ps.setInt (6, entity.getFeedbackId());
				ps.setInt (7, entity.getCategoryId());
				return ps;
			}
		}, keyHolder);
		entity.setId(keyHolder.getKey().intValue());

		return entity;
	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("delete from recipe where id=" + id);

	}

	@Override
	public List<Recipe> getAll() {
		List<Recipe> rs = jdbcTemplate.query("select * from recipe ",
				new BeanPropertyRowMapper<Recipe>(Recipe.class));
		return rs;
	}

	@Override
	public void update(Recipe recipe) {
		// TODO

	}

	

}
