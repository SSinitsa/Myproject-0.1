package com.ssinitsa.training.culinary.services;

import java.sql.Timestamp;
import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.util.Assert;

import com.ssinitsa.training.culinary.datamodel.User;
import com.ssinitsa.training.culinary.datamodel.UserDetails;

public class CreateUserServiceTest extends AbstractTest {

	@Inject
	private IUserService userService;
	
	@Inject
	IUserDetailsService userDetailsService;

	@Test
	public void createTest() {
		User user = new User();
		UserDetails userDetails = new UserDetails();
		userDetailsService.save(userDetails);
		user.setLogin("new login from java");
		user.setPassword("new password from java");
		user.setDetailsId(userDetails.getId());
		user.setRegistrated(new Timestamp(new Date().getTime()));
		userService.save(user);

		Integer savedUserId = user.getId();
		User userFromDb = userService.get(savedUserId);

		Assert.notNull(userFromDb, "user must be saved");

		Assert.notNull(userFromDb.getLogin(), "login column must not me empty");

		Assert.isTrue(userFromDb.getLogin().equals(user.getLogin()), "login must be equals");
		
		Assert.notNull(userFromDb.getPassword(), "password column must not me empty");

		Assert.isTrue(userFromDb.getPassword().equals(user.getPassword()), "password must be equals");
		
		Assert.notNull(userFromDb.getDetailsId(), "details_id column must not me empty");

		Assert.isTrue(userFromDb.getDetailsId()==(user.getDetailsId()), "details_id must be equals");
		
		Assert.notNull(userFromDb.getRegistrated(), "registrated column must not me empty");

		Assert.isTrue(userFromDb.getRegistrated().equals(user.getRegistrated()), "registrated must be equals");
		
			

	}
}
