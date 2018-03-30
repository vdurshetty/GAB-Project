package com.sri.gab.db.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sri.gab.db.dao.UserDAO;
import com.sri.gab.db.dao.impl.UserDAOImpl;
import com.sri.gab.db.dto.User;
import com.sri.gab.db.exception.FetchDataException;
import com.sri.gab.logger.GABLogger;



public class UserDAOTest {
	
	static GABLogger log = GABLogger.getLogger(UserDAOTest.class.getName());
	

	@Test
	public void dispAllUsers()  throws Exception{
		UserDAO uDao = new UserDAOImpl();
		List<User> users = null;
		try {
			users =  uDao.getAllUsers();
			if (users!=null) {
			  User user = null;
			  int totCount = users.size();
			  for (int i = 0; i < totCount; i++) {  
				  user = (User) users.get(i);
				  log.info(" User id:" + user.getUid());
				  log.info(" Name :" + user.getUserName());
				  log.info(" Full Name :" + user.getFullName());
				  log.info(" Email :" + user.getEmail());
				  log.info(" Mobile :" + user.getPhone() );
				  log.info(" pwd :" + user.getPwd() );
				  log.info("_________________");
			  }
			}
		} catch (FetchDataException fde ) {
			log.error("Unable to fetch data " + fde.getMessage());
			Assert.assertNull(users);
		}
	}
	

	private static void addUser() throws Exception {
		UserDAO uDao = new UserDAOImpl();

		User user = new User();
		user.setUserName("Gopal");
		user.setFullName("Venugopal Durshetty");
		
		if (uDao.addUser(user)) {
			System.out.println("User Added successfully.");
		} 
	}
	
	
}
