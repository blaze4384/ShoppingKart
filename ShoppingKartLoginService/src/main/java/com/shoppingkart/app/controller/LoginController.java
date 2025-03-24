package com.shoppingkart.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingkart.app.request.UserRequest;
import com.shoppingkart.app.response.UserResponse;
import com.shoppingkart.app.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService service;
	
	@PostMapping("/create")
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
		UserResponse response = service.createUser(request);
		if (response != null)
			return ResponseEntity.ok().body(response);

		return ResponseEntity.badRequest().build();

	}

}
