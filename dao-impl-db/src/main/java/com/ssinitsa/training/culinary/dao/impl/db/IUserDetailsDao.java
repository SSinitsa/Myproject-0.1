package com.ssinitsa.training.culinary.dao.impl.db;

import java.util.List;

import com.ssinitsa.training.culinary.datamodel.UserDetails;

public interface IUserDetailsDao {
	UserDetails get(Integer id);

	UserDetails insert(UserDetails userDetails);

	void update(UserDetails userDetails);

	List<UserDetails> getAll();

	void delete(Integer id);

}
