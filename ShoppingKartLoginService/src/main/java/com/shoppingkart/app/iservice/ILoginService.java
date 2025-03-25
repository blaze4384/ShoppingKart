package com.shoppingkart.app.iservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingkart.app.entity.Login;
import com.shoppingkart.app.repository.ILoginRepo;
import com.shoppingkart.app.request.UserRequest;
import com.shoppingkart.app.response.UserResponse;
import com.shoppingkart.app.service.LoginService;

@Service
public class ILoginService implements LoginService {

	@Autowired
	ILoginRepo repo;

	@Override
	public UserResponse createUser(UserRequest userRequest) {
		if (repo.findUser(userRequest.getUserName()).isEmpty()) {
			Login login = new Login();
			UserResponse response = new UserResponse();
			login.setUserName(userRequest.getUserName());
			login.setPassword(userRequest.getPassword());
			Login l = repo.save(login);
			response.setId(l.getId());
			response.setUserName(l.getUserName());
			return response;
		}
		return null;
	}

	@Override
	public boolean validateUser(UserRequest request) {
		List<Login> userList = repo.findUser(request.getUserName());
		if (!userList.isEmpty() && userList.get(0).getPassword().equals(request.getPassword()))
			return true;

		return false;

	}

}
