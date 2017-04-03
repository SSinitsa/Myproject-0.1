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

import com.ssinitsa.training.culinary.dao.impl.db.IFeedbackDao;
import com.ssinitsa.training.culinary.datamodel.Feedback;



@Repository
public class FeedbackDaoImpl implements IFeedbackDao {
	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Feedback get(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from feedback where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<Feedback>(Feedback.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Feedback insert(Feedback entity) {
		final String INSERT_SQL = "insert into feedback (text, user_id) values(?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, entity.getText());
				ps.setInt(2, entity.getUserId());
				return ps;
			}
		}, keyHolder);
		entity.setId(keyHolder.getKey().intValue());

		return entity;
	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("delete from feedback where id=" + id);

	}

	@Override
	public List<Feedback> getAll() {
		List<Feedback> rs = jdbcTemplate.query("select * from feedback ",
				new BeanPropertyRowMapper<Feedback>(Feedback.class));
		return rs;
	}

	@Override
	public void update(Feedback feedback) {
		// TODO

	}

}
