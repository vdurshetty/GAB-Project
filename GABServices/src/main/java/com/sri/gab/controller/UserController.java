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

import com.sri.gab.db.dto.User;
import com.sri.gab.db.exception.AddException;
import com.sri.gab.db.exception.FetchDataException;
import com.sri.gab.db.exception.PrimaryKeyException;
import com.sri.gab.db.exception.RecordNotFoundException;
import com.sri.gab.db.exception.UpdateException;
import com.sri.gab.services.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping ( value = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "Hello Goddies......";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.PUT)
	public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		System.out.println("in add User");
		ResponseEntity<?> response = null;
		try {
			if (userService.addUser(user)) {
				HttpHeaders headers = new HttpHeaders();
				headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getUid()).toUri());
				response = new ResponseEntity<String>(headers,HttpStatus.CREATED );
			} 
		} catch (AddException | PrimaryKeyException e) {
			response = new ResponseEntity<Object>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return response;
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		System.out.println("in update User");
		ResponseEntity<?> response = null;
		try {
			if (userService.updateUserDetails(user)) {
				HttpHeaders headers = new HttpHeaders();
				headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getUid()).toUri());
				response = new ResponseEntity<String>(headers,HttpStatus.OK);
			}
		} catch (UpdateException | RecordNotFoundException e) {
			response = new ResponseEntity<Object>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return response;
	}
		
	@RequestMapping(value = "/AuthUser", method = RequestMethod.POST)
	public ResponseEntity<?> AuthenticateUser(@RequestBody User user) {
		System.out.println("in Authenticate User");
		ResponseEntity<?> response = null;
		User retUser;
		try {
			retUser = userService.AuthenticateUser(user);
			response = new ResponseEntity<User>(retUser,HttpStatus.OK);
		} catch (FetchDataException e) {
			response = new ResponseEntity<Object>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return response;
	}
	
	@RequestMapping(value = "/listUsers", method = RequestMethod.GET)
	public ResponseEntity<?> listUsers() {
		System.out.println("in List User");
		ResponseEntity<?> response = null;
		List<User> users; 
		try {
			users = userService.getAllUsers();
			if (users!=null) {
				response = new ResponseEntity<List<User>>(users,HttpStatus.OK);
			} else {
				response = new ResponseEntity<String>("No Data Found!",HttpStatus.CONFLICT);
			}
		} catch (FetchDataException e) {
			response = new ResponseEntity<Object>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserDetails(@PathVariable("id") long id ) {
		System.out.println("in get User");
		ResponseEntity<?> response = null;
		User user; 
		try {
			user = userService.getUserDetails(id);
			if (user!=null) {
				response = new ResponseEntity<User>(user,HttpStatus.OK);
			} else {
				response = new ResponseEntity<String>("No Data Found!",HttpStatus.CONFLICT);
			}
		} catch (FetchDataException e) {
			response = new ResponseEntity<Object>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return response;
	}
}
