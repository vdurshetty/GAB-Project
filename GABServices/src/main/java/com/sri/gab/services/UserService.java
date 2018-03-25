package com.sri.gab.services;

import java.util.List;

import com.sri.gab.db.dto.GABFunctionalities;
import com.sri.gab.db.dto.User;
import com.sri.gab.db.exception.AddException;
import com.sri.gab.db.exception.FetchDataException;
import com.sri.gab.db.exception.PrimaryKeyException;
import com.sri.gab.db.exception.RecordNotFoundException;
import com.sri.gab.db.exception.UpdateException;

public interface UserService {
	
	public boolean addUser(User user) throws AddException, PrimaryKeyException;
	
	public boolean updateUserDetails(User user) throws UpdateException, RecordNotFoundException;
	
	public User getUserDetails(long uid) throws FetchDataException;
	
	public User AuthenticateUser(User user) throws FetchDataException;

	public List<User> getAllUsers() throws FetchDataException;
	
	public User deactivateUser(User user) throws UpdateException;
	
	public boolean resetPassword(User user) throws UpdateException;
	
	
	
	public boolean addUserPermissions(User user, GABFunctionalities funcs) throws AddException;
	
	public boolean updateUserPermissions(User user, GABFunctionalities funcs) throws UpdateException;
	
	public GABFunctionalities getUserPermissions(User user) throws FetchDataException;

}
