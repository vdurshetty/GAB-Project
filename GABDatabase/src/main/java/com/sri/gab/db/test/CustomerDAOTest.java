package com.sri.gab.db.test;


import java.util.GregorianCalendar;
import java.util.List;

import com.sri.gab.db.dao.CustomerDAO;
import com.sri.gab.db.dto.Customer;
import com.sri.gab.logger.GABLogger;


public class CustomerDAOTest {
	
	static GABLogger log = GABLogger.getLogger(CustomerDAOTest.class.getName());
	public static void main(String a[]) throws Exception{
		
		log.error("In Customer  Test");
		addCustomer();
		updateCustomer();
		dispAllcustomers();
		System.exit(0);
		
	}
	
	


	
	private static void dispAllcustomers()  throws Exception{
	 CustomerDAO cDao = new CustomerDAO();
		List<Customer> customers =  cDao.getAllCustomers();
		Customer cust = null;
		int totCount = customers.size();
		  for (int i = 0; i < totCount; i++) {  
			  cust = (Customer) customers.get(i);
			   log.error("Customer ID :" + cust.getCustID() );
			   log.error(" First Name :" + cust.getFirstName());
			   log.error(" Middle Name :" + cust.getMiddleName());
			   log.error(" Last Name :" + cust.getLastName());
			   log.error(" Astro ID:" + cust.getAstroId() );
			   log.error(" Date Of Birth :" + cust.getDob() );
			   log.error(" Place Of Birth :" + cust.getPob() );
			   log.error(" Email :" + cust.getEmail() );
			   log.error(" Mobile :" + cust.getPhone1() );
			   log.error(" Mobile2 :" + cust.getPhone2() );
			   log.error("_________________");
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
		CustomerDAO cDao = new CustomerDAO();
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
		
		CustomerDAO cDao = new CustomerDAO();
		if (cDao.updateCustomer(cust)) {
			System.out.println("Customer Successfully Added....");
		}
	}


}
