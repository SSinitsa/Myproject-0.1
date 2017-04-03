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

import com.ssinitsa.training.culinary.dao.impl.db.IRecipeDetailsDao;
import com.ssinitsa.training.culinary.datamodel.RecipeDetails;

@Repository
public class RecipeDetailsDaoImpl implements IRecipeDetailsDao{

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public RecipeDetails get(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from  recipe_details where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<RecipeDetails>(RecipeDetails.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public RecipeDetails insert(RecipeDetails entity) {
		final String INSERT_SQL = "insert into recipe_details (recipe_id, igredient_id, quantity) values(?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setInt(1, entity.getRecipeId());
				ps.setInt(2, entity.getIngredientId());
				ps.setInt(3, entity.getQuantity());
				return ps;
			}
		}, keyHolder);
		entity.setId(keyHolder.getKey().intValue());

		return entity;
	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("delete from recipe_details where id=" + id);

	}

	@Override
	public List<RecipeDetails> getAll() {
		List<RecipeDetails> rs = jdbcTemplate.query("select * from recipe_details ",
				new BeanPropertyRowMapper<RecipeDetails>(RecipeDetails.class));
		return rs;
	}

	@Override
	public void update(RecipeDetails recipeDetails) {
		// TODO

	}

}
