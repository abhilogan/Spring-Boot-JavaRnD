package com.example.demo.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/user")
public class UserResource {

	@GetMapping
	public List<User> getUsers(){
		
		return Arrays.asList(
				new User("Sam" , 2000l),
				new User("Ken" , 2050l));
		
	}
	
	@GetMapping("/{userName}")
	public User getUser(@PathVariable("userName") final String userName) {
		
		return new User(userName, 1000l);
		
	}
	
}
