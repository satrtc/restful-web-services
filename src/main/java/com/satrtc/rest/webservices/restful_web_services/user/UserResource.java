package com.satrtc.rest.webservices.restful_web_services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;
	
	
	//getAll users
	@GetMapping(path="/users")
	public List<User> allUsers()
	{
		return userDaoService.getAllUsers();
	}
	
	//get specific user
	@GetMapping(path="/users/{id}")
	public User getSpecificUser(@PathVariable int id)
	{
		return userDaoService.getUserDetail(id);
	}
	
	//create a user
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		userDaoService.addUser(user);
		return ResponseEntity.created(null).build();
	}
}
