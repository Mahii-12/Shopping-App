package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.service.UserServiceImplementation;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user/")
//@Validated
public class UserController {

	@Autowired
	private UserServiceImplementation userService;
	
	@PostMapping("/create")
	public ResponseEntity<Users> newUser(@Valid @RequestBody  Users user){
		Users newUser=userService.createUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<Users>> viewAll(){
		List<Users> users=userService.viewAllUsers();
		return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Users>> viewUser(@PathVariable("id")  Long user_id){
		Optional<Users> user=userService.viewUserWithId(user_id);
		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeUser(@PathVariable("id") Long user_id){
		String delete=userService.deleteUserWithId(user_id);
		return new ResponseEntity<>(delete, HttpStatus.ACCEPTED);
	}
}
