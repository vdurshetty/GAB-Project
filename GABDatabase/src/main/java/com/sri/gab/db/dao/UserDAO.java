package com.sri.gab.db.dao;

import java.util.List;
import java.util.Vector;

import com.sri.gab.db.dto.GABFunctionalities;
import com.sri.gab.db.dto.KeyValueMaster;
import com.sri.gab.db.dto.User;
import com.sri.gab.db.exception.AddException;
import com.sri.gab.db.exception.DeleteException;
import com.sri.gab.db.exception.FetchDataException;
import com.sri.gab.db.exception.PrimaryKeyException;
import com.sri.gab.db.exception.RecordNotFoundException;
import com.sri.gab.db.exception.UpdateException;

public interface UserDAO {
	
	public boolean addUser(User user) throws AddException, PrimaryKeyException;
	public boolean updateUser(User user ) throws UpdateException,RecordNotFoundException;
	public boolean deleteUser(User user) throws DeleteException,RecordNotFoundException;
	public User getUser(long uid) throws FetchDataException;
	public User validateUser(User user) throws FetchDataException;
	public List<User> getAllUsers() throws FetchDataException;
	public Vector<GABFunctionalities> getAllFunctionalities1() throws FetchDataException;
	public Vector<KeyValueMaster> getAllFunctionalities() throws FetchDataException;
	public boolean addUserPermissions(User user) throws AddException;
	public List<Object[]> getUserPermissions(int uid) throws FetchDataException;
}
