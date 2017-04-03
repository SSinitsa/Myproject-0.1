package com.ssinitsa.training.culinary.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ssinitsa.training.culinary.dao.impl.db.IUserDetailsDao;
import com.ssinitsa.training.culinary.datamodel.UserDetails;
import com.ssinitsa.training.culinary.services.IUserDetailsService;

@Service
public class UserDetailsServiceImpl implements IUserDetailsService {

	@Inject
	private IUserDetailsDao userDetailsDao;

	@Override
	public UserDetails get(Integer id) {
		return userDetailsDao.get(id);
	}

	@Override
	public List<UserDetails> getAll() {
		return userDetailsDao.getAll();
	}

	@Override
	public void save(UserDetails userDetails) {
		if (userDetails.getId() == null) {
			System.out.println("Insert new UserDetails");
			userDetailsDao.insert(userDetails);
		} else {
			userDetailsDao.update(userDetails);
		}
	}

	@Override
	public void delete(Integer id) {
		userDetailsDao.delete(id);

	}

	@Override
	public void saveMultiple(UserDetails... userDetailsAray) {

		for (UserDetails userDetails : userDetailsAray) {
			save(userDetails);
		}

	}
}
