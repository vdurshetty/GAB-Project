package com.sri.gab.services.impl;

import java.util.List;

import com.sri.gab.db.dao.CustomerDAO;
import com.sri.gab.db.dto.Customer;
import com.sri.gab.db.exception.AddException;
import com.sri.gab.db.exception.DeleteException;
import com.sri.gab.db.exception.FetchDataException;
import com.sri.gab.db.exception.PrimaryKeyException;
import com.sri.gab.db.exception.RecordNotFoundException;
import com.sri.gab.db.exception.UpdateException;
import com.sri.gab.services.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	CustomerDAO cDAO;
	
	public CustomerServiceImpl() {
		cDAO = new CustomerDAO();
	}
	
	
	@Override
	public boolean addCustomer(Customer customer) throws AddException, PrimaryKeyException {
		boolean retValue = false;
		if (customer!=null) {
			if (cDAO.addCustomer(customer) ) {
				retValue = true;
			}
		} else {
			throw new AddException("Customer Object passed cannot be empty!");
		}
		return retValue;
	}

	@Override
	public boolean updateCustomer(Customer customer) throws RecordNotFoundException, UpdateException {
		boolean retValue = false;
		if (customer!=null) {
			if (cDAO.updateCustomer(customer) ) {
				retValue = true;
			}
		} else {
			throw new RecordNotFoundException("Customer Object passed cannot be empty!");
		}
		return retValue;
	}

	@Override
	public Customer getCustomer(long custId) throws FetchDataException {
		return cDAO.getCustomer(custId);
	}

	@Override
	public List<Customer> searchCustomers(Customer customer) throws FetchDataException {
		List<Customer> customers;
		customers = cDAO.getCustomerBy(customer);
		return customers;
	}

	@Override
	public List<Customer> getAllCustomers(Customer customer) throws FetchDataException {
		return cDAO.getAllCustomers();
	}

	@Override
	public boolean deleteCustomer(Customer customer) throws DeleteException,RecordNotFoundException {
		boolean retValue = false;
		if (customer!=null) {
			if (cDAO.deleteCustomer(customer) ) {
				retValue = true;
			}
		} else {
			throw new DeleteException("Customer Object passed cannot be empty!");
		}
		return retValue;
	}
	
	

}
