package com.shoppingkart.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingkart.app.request.UserRequest;
import com.shoppingkart.app.response.UserResponse;
import com.shoppingkart.app.service.LoginService;

@RestController
@RequestMapping("/shoppingkart")
public class LoginController {

	@Autowired
	LoginService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody UserRequest request) {
		UserResponse response = service.createUser(request);
		if (response != null)
			return new ResponseEntity<UserResponse>(response,HttpStatus.CREATED);

		return new ResponseEntity<String>("User already registered", HttpStatus.CONFLICT);

	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserRequest request){
		boolean response = service.validateUser(request);
		if(response == true)
			return new ResponseEntity<Boolean>(response,HttpStatus.OK);
		
		return new ResponseEntity<String>("check userid or password", HttpStatus.UNAUTHORIZED);
	}

}
