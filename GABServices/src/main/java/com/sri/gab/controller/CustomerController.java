package com.sri.gab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sri.gab.db.dto.Customer;
import com.sri.gab.db.dto.User;
import com.sri.gab.db.exception.AddException;
import com.sri.gab.db.exception.FetchDataException;
import com.sri.gab.db.exception.PrimaryKeyException;
import com.sri.gab.db.exception.RecordNotFoundException;
import com.sri.gab.db.exception.UpdateException;
import com.sri.gab.services.CustomerService;
import com.sri.gab.services.UserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping ( value = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "Hello Goddies......";
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.PUT)
	public ResponseEntity<?> createCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {
		System.out.println("in add Customer");
		ResponseEntity<?> response = null;
		try {
			if (customerService.addCustomer(customer) ) {
				HttpHeaders headers = new HttpHeaders();
				headers.setLocation(ucBuilder.path("/api/customer/{id}").buildAndExpand(customer.getCustID()).toUri());
				response = new ResponseEntity<String>(headers,HttpStatus.CREATED );
			} 
		} catch (AddException | PrimaryKeyException e) {
			response = new ResponseEntity<Object>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return response;
	}
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {
		System.out.println("in update Customer");
		ResponseEntity<?> response = null;
		try {
			if (customerService.updateCustomer(customer) ) {
				HttpHeaders headers = new HttpHeaders();
				headers.setLocation(ucBuilder.path("/api/customer/{id}").buildAndExpand(customer.getCustID()).toUri());
				response = new ResponseEntity<String>(headers,HttpStatus.OK);
			}
		} catch (UpdateException | RecordNotFoundException e) {
			response = new ResponseEntity<Object>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return response;
	}
		
	@RequestMapping(value = "/searchCustomers", method = RequestMethod.POST)
	public ResponseEntity<?> findCustomers(@RequestBody Customer customer) {
		System.out.println("in Serach Customers");
		ResponseEntity<?> response = null;
		List<Customer> customers; 
		try {
			customers = customerService.searchCustomers(customer);
			if (customers!=null) {
				response = new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
			} else {
				response = new ResponseEntity<String>("No Data Found!",HttpStatus.CONFLICT);
			}
		} catch (FetchDataException e) {
			response = new ResponseEntity<Object>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return response;
	}
	
	
	@RequestMapping(value = "/listCustomers", method = RequestMethod.GET)
	public ResponseEntity<?> listUsers() {
		System.out.println("in List Customers");
		ResponseEntity<?> response = null;
		List<Customer> customers; 
		try {
			customers = customerService.getAllCustomers();
			if (customers!=null) {
				response = new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
			} else {
				response = new ResponseEntity<String>("No Data Found!",HttpStatus.CONFLICT);
			}
		} catch (FetchDataException e) {
			response = new ResponseEntity<Object>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCustomerDetails(@PathVariable("id") long id ) {
		System.out.println("in get Customer!!");
		ResponseEntity<?> response = null;
		Customer customer; 
		try {
			customer = customerService.getCustomer(id);
			if (customer!=null) {
				response = new ResponseEntity<Customer>(customer,HttpStatus.OK);
			} else {
				response = new ResponseEntity<String>("No Data Found!",HttpStatus.CONFLICT);
			}
		} catch (FetchDataException e) {
			response = new ResponseEntity<Object>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return response;
	}
}
