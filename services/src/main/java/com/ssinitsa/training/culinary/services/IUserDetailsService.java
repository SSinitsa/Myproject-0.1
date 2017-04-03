package com.ssinitsa.training.culinary.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssinitsa.training.culinary.datamodel.UserDetails;

public interface IUserDetailsService {

	UserDetails get(Integer id);

	@Transactional
	void save(UserDetails userDetails);

	@Transactional
	void saveMultiple(UserDetails... UserDetails);

	List<UserDetails> getAll();

	@Transactional
	void delete(Integer id);
}
