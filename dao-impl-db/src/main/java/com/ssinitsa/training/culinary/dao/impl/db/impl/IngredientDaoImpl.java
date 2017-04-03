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

import com.ssinitsa.training.culinary.dao.impl.db.IIngredientDao;
import com.ssinitsa.training.culinary.datamodel.Ingredient;

@Repository
public class IngredientDaoImpl implements IIngredientDao {
	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Ingredient get(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from ingredient where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<Ingredient>(Ingredient.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Ingredient insert(Ingredient entity) {
		final String INSERT_SQL = "insert into ingredient (name, calories, fats, proteins, carbohydrates, category) values(?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, entity.getName());
				ps.setInt(2, entity.getCalories());
				ps.setDouble(3, entity.getFats());
				ps.setDouble(4, entity.getProteins());
				ps.setDouble(5, entity.getCarbohydrates());
				ps.setString(6, entity.getCategory());
				return ps;
			}
		}, keyHolder);
		entity.setId(keyHolder.getKey().intValue());

		return entity;
	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("delete from ingredient where id=" + id);

	}

	@Override
	public List<Ingredient> getAll() {
		List<Ingredient> rs = jdbcTemplate.query("select * from ingredient ",
				new BeanPropertyRowMapper<Ingredient>(Ingredient.class));
		return rs;
	}

	@Override
	public void update(Ingredient ingredient) {
		// TODO

	}

}
