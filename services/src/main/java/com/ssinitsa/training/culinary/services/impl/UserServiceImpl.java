package com.ssinitsa.training.culinary.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ssinitsa.training.culinary.dao.impl.db.IUserDao;
import com.ssinitsa.training.culinary.datamodel.User;
import com.ssinitsa.training.culinary.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Inject
	private IUserDao userDao;

	@Override
	public User get(Integer id) {
		return userDao.get(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public void save(User user) {
		if (user.getId() == null) {
			System.out.println("Insert new User");
			userDao.insert(user);
		} else {
			userDao.update(user);
		}
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);

	}

	@Override
	public void saveMultiple(User... userAray) {

		for (User user : userAray) {
			save(user);
		}

	}
}
