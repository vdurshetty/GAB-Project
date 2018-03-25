package com.sri.gab.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sri.gab.db.dao.UserDAO;
import com.sri.gab.db.dto.GABFunctionalities;
import com.sri.gab.db.dto.User;
import com.sri.gab.db.exception.AddException;
import com.sri.gab.db.exception.FetchDataException;
import com.sri.gab.db.exception.PrimaryKeyException;
import com.sri.gab.db.exception.RecordNotFoundException;
import com.sri.gab.db.exception.UpdateException;
import com.sri.gab.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	UserDAO uDAO;
	
	public UserServiceImpl() {
		uDAO = new UserDAO();
	}

	@Override
	public boolean addUser(User user) throws AddException, PrimaryKeyException {
		boolean retValue = false;
		if (user!=null) {
			if (uDAO.addUser(user)) {
				retValue = true;
			}
		} else {
			throw new AddException("User Object passed cannot be empty!");
		}
		return retValue;
	}

	@Override
	public boolean updateUserDetails(User user) throws UpdateException, RecordNotFoundException {
		boolean retValue = false;
		if (user!=null) {
			if (uDAO.updateUser(user)) {
				retValue = true;
			}
		} else {
			throw new RecordNotFoundException("User Object passed cannot be empty!");
		}
		return retValue;
	}

	@Override
	public User getUserDetails(long uid) throws FetchDataException {
		if (uid <= 0) {
			throw new FetchDataException("User ID must be valid and greater than zero!");
		}
		return uDAO.getUser(uid);
	}

	@Override
	public User AuthenticateUser(User user) throws FetchDataException {
		User retUser;
		if (user!=null) {
			 retUser = uDAO.validateUser(user);
		} else {
			throw new FetchDataException("User Object passed cannot be empty!");
		}
		return retUser;
	}

	
	@Override
	public List<User> getAllUsers() throws FetchDataException {
		return uDAO.getAllUsers();
	}
	
	
	@Override
	public User deactivateUser(User user) throws UpdateException {
		return null;
	}

	@Override
	public boolean resetPassword(User user) throws UpdateException {
		return false;
	}

	@Override
	public boolean addUserPermissions(User user, GABFunctionalities funcs) throws AddException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserPermissions(User user, GABFunctionalities funcs) throws UpdateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GABFunctionalities getUserPermissions(User user) throws FetchDataException {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	

}
