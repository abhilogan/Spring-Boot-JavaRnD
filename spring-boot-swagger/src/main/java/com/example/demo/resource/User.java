package com.example.demo.resource;

import io.swagger.annotations.ApiModelProperty;

public class User {

	@ApiModelProperty(notes = "name of the user")
	private String userName;

	private Long salary;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public User(String userName, long salary) {
		this.userName = userName;
		this.salary = salary;
	}

}
