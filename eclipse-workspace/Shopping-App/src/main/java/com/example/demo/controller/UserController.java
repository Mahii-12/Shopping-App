package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.DTO.UsersDto;
import com.example.demo.exceptions.UsersExceptions;
import com.example.demo.model.Users;
import com.example.demo.services.UsersServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UsersServiceImpl uService;
	
	@PostMapping("/register")
	public ResponseEntity<UsersDto> rUsers(@RequestBody Users user) throws UsersExceptions{
		return new ResponseEntity<>(uService.createUser(user), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/byId/{userId}")
	public ResponseEntity<UsersDto> guserbyId(@PathVariable Long userId) throws UsersExceptions{
		return new ResponseEntity<>(uService.getUserByID(userId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<Users>> aUsers()throws UsersExceptions{
		return new ResponseEntity<>(uService.getAllUsers(), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> dUsers(@PathVariable Long userId){
		return new ResponseEntity<>(uService.deleteUserByID(userId), HttpStatus.ACCEPTED);
	}
}
























