package com.sri.gab.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sri.gab.db.dto.User;
import com.sri.gab.db.exception.FetchDataException;
import com.sri.gab.services.impl.UserServiceImpl;

public class UserServiceTest {
	
	
	UserService userService; 
	
	@Before
	public void init() {
		userService = new UserServiceImpl();
	}
	
	
	
	@Test
	public void fetchUserDetailsTest() throws FetchDataException {
		User fetchUser =  userService.getUserDetails((long)2);
		Assert.assertNotNull(fetchUser);
	}
	

}
