package com.project2.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project2.data.UserRepository;
import com.project2.data.Users;

@RestController
@RequestMapping(path = "users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping
	public List<Users> getAllUsers(){
		return this.userRepository.getAllUsers();
	}
}
