package com.sri.gab.services;

import java.util.List;

import com.sri.gab.db.dto.Customer;
import com.sri.gab.db.exception.AddException;
import com.sri.gab.db.exception.DeleteException;
import com.sri.gab.db.exception.FetchDataException;
import com.sri.gab.db.exception.PrimaryKeyException;
import com.sri.gab.db.exception.RecordNotFoundException;
import com.sri.gab.db.exception.UpdateException;

public interface CustomerService {
	
	public boolean addCustomer(Customer customer) throws AddException, PrimaryKeyException;
	
	public boolean updateCustomer(Customer customer) throws RecordNotFoundException, UpdateException;
	
	public Customer getCustomer(long custId) throws FetchDataException;
	
	public List<Customer> searchCustomers(Customer customer) throws FetchDataException;
	
	public List<Customer> getAllCustomers() throws FetchDataException;
	
	public boolean deleteCustomer(Customer customer) throws DeleteException, RecordNotFoundException;
	

}
