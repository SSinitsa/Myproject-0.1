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

import com.ssinitsa.training.culinary.dao.impl.db.IDishCategoriesDao;
import com.ssinitsa.training.culinary.datamodel.DishCategories;

@Repository
public class DishCategoriesDaoImpl implements IDishCategoriesDao {
	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public DishCategories get(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from  dish_categories where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<DishCategories>(DishCategories.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public DishCategories insert(DishCategories entity) {
		final String INSERT_SQL = "insert into dish_categories (country, vegetarian, type) values(?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, entity.getCountry());
				ps.setBoolean(1, entity.isVegetarian());
				ps.setString(3, entity.getType());
				return ps;
			}
		}, keyHolder);
		entity.setId(keyHolder.getKey().intValue());

		return entity;
	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("delete from dish_categories where id=" + id);

	}

	@Override
	public List<DishCategories> getAll() {
		List<DishCategories> rs = jdbcTemplate.query("select * from dish_categories ",
				new BeanPropertyRowMapper<DishCategories>(DishCategories.class));
		return rs;
	}

	@Override
	public void update(DishCategories dishCategories) {
		// TODO

	}

}
