package com.sri.gab.db.dao;


import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sri.gab.db.dao.CustomerDAO;
import com.sri.gab.db.dao.impl.CustomerDAOImpl;
import com.sri.gab.db.dto.Customer;
import com.sri.gab.db.exception.FetchDataException;
import com.sri.gab.logger.GABLogger;


public class CustomerDAOTest {
	
	static GABLogger log = GABLogger.getLogger(CustomerDAOTest.class.getName());

	@Test
	public void dispAllcustomers() {
	 CustomerDAO cDao = new CustomerDAOImpl();
		List<Customer> customers = null;
		try {
			customers =  cDao.getAllCustomers();
			Customer cust = null;
			int totCount = customers.size();
			for (int i = 0; i < totCount; i++) {  
			  cust = (Customer) customers.get(i);
			   log.info("Customer ID :" + cust.getCustID() );
			   log.info(" First Name :" + cust.getFirstName());
			   log.info(" Middle Name :" + cust.getMiddleName());
			   log.info(" Last Name :" + cust.getLastName());
			   log.info(" Astro ID:" + cust.getAstroId() );
			   log.info(" Date Of Birth :" + cust.getDob() );
			   log.info(" Place Of Birth :" + cust.getPob() );
			   log.info(" Email :" + cust.getEmail() );
			   log.info(" Mobile :" + cust.getPhone1() );
			   log.info(" Mobile2 :" + cust.getPhone2() );
			   log.info("_________________");
			 }
		} catch (FetchDataException fde ) {
			log.error("Unable to fetch data " + fde.getMessage());
			Assert.assertNull(customers);
		}
	}
	

	private static void addCustomer() throws Exception {
		Customer cust = new Customer();
		cust.setAstroId("1212");
		cust.setFirstName("Customer First Name ");
		cust.setMiddleName("Customer Middle Name ");
		cust.setLastName("Customer Last Name");
		cust.setDob(new GregorianCalendar().getTime());
		cust.setPob("test");
		cust.setEmail("My Email");
		cust.setPhone1("3343434");
		cust.setPhone2("3343434");
		CustomerDAO cDao = new CustomerDAOImpl();
		cDao.addCustomer(cust);
	}
	
	private static void updateCustomer() throws Exception {
		Customer cust = new Customer();
		cust.setCustID(1);
		cust.setAstroId("121");
		cust.setFirstName("Customer First Name2 ");
		cust.setMiddleName("Customer Middle Name 1");
		cust.setLastName("Customer Last Name1");
		cust.setDob(new GregorianCalendar().getTime());
		cust.setPob("test1");
		cust.setEmail("My Email1");
		cust.setPhone1("33434341");
		cust.setPhone2("33434341");
		
		CustomerDAO cDao = new CustomerDAOImpl();
		if (cDao.updateCustomer(cust)) {
			System.out.println("Customer Successfully Added....");
		}
	}


}
