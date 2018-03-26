
package com.sri.gab.db.dao;

import java.util.List;

import com.sri.gab.db.dto.Customer;
import com.sri.gab.db.exception.AddException;
import com.sri.gab.db.exception.DeleteException;
import com.sri.gab.db.exception.FetchDataException;
import com.sri.gab.db.exception.PrimaryKeyException;
import com.sri.gab.db.exception.RecordNotFoundException;
import com.sri.gab.db.exception.UpdateException;


public interface CustomerDAO {
	
	public boolean addCustomer(Customer cust) throws AddException, PrimaryKeyException;
	public boolean updateCustomer(Customer cust ) throws UpdateException, RecordNotFoundException;
	public boolean deleteCustomer(Customer cust) throws DeleteException,RecordNotFoundException;
	public Customer getCustomer(long cid) throws FetchDataException;
	public List<Customer> getCustomerBy(Customer cust) throws FetchDataException;
	public List<Customer> getAllCustomers() throws FetchDataException;
}
