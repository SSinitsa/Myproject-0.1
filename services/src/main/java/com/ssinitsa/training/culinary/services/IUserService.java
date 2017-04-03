package com.ssinitsa.training.culinary.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssinitsa.training.culinary.datamodel.User;

public interface IUserService {

	User get(Integer id);

	@Transactional
	void save(User user);

	@Transactional
	void saveMultiple(User... User);

	List<User> getAll();

	@Transactional
	void delete(Integer id);
}
