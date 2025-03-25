package com.shoppingkart.app.service;

import com.shoppingkart.app.request.UserRequest;
import com.shoppingkart.app.response.UserResponse;

public interface LoginService {

	UserResponse createUser(UserRequest userRequest);

	boolean validateUser(UserRequest request);

}
