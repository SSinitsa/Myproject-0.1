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

import com.ssinitsa.training.culinary.dao.impl.db.IUserDetailsDao;
import com.ssinitsa.training.culinary.datamodel.UserDetails;


@Repository
public class UserDetailsDaoImpl implements IUserDetailsDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public UserDetails get(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from user_details where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<UserDetails>(UserDetails.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public UserDetails insert(UserDetails entity) {
		final String INSERT_SQL = "insert into user_details (first_name, last_name, country, city, email, male_sex, birth_date, about_me) values(?,?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, entity.getFirstName());
				ps.setString(2, entity.getLastName());
				ps.setString(3, entity.getCountry());
				ps.setString(4, entity.getCity());
				ps.setString(5, entity.getEmail());
				ps.setBoolean(6, entity.isMaleSex());
				ps.setTimestamp(7, entity.getBirthDate());
				ps.setString(8, entity.getAboutMe());
				return ps; 
			}
		}, keyHolder);
		entity.setId(keyHolder.getKey().intValue());

		return entity;
	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("delete from user_details where id=" + id);

	}

	@Override
	public List<UserDetails> getAll() {
		List<UserDetails> rs = jdbcTemplate.query("select * from user_details ",
				new BeanPropertyRowMapper<UserDetails>(UserDetails.class));
		return rs;
	}

	@Override
	public void update(UserDetails userDetails) {
		// TODO

	}


}
