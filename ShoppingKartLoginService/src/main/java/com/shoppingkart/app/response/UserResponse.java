package com.shoppingkart.app.response;

public class UserResponse {

	private int id;
	private String userName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserResponse [id=" + id + ", userName=" + userName + "]";
	}

}
