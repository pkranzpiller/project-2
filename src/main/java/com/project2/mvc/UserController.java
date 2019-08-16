package com.project2.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project2.data.UserRepository;
import com.project2.data.Users;

@CrossOrigin
@RestController
@RequestMapping(path = "login")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping
	public List<Users> getAllUsers(){
		return this.userRepository.getAllUsers();
	}
	
	
	@PostMapping
	public ResponseEntity<?> validateUser(@RequestBody Users u){
		Users user = this.userRepository.getUser(u.getUsername());
		if(user != null)
			if(user.getUsername().equals(u.getUsername()) && user.getPassword().equals(u.getPassword())) {
				return ResponseEntity.status(HttpStatus.OK).body("login successful");
			}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("hax, intruder alert!");
	}
	
	@PostMapping(path = "/newUser")
	public ResponseEntity<?> storeUser(@RequestBody Users user) {
		Users newUser = new Users();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setUsertype("user");
		if(userRepository.doesUserExist(user.getUsername())) {
			System.out.println("username exists");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed to store user");
		}
		this.userRepository.storeUser(newUser);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("stored user");
	}
}
