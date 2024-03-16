package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.JwtAuthResponse;
import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.UsersResponse;
import com.example.demo.entity.Users;
import com.example.demo.exception.UsersException;
import com.example.demo.service.UsersServiceImpl;

@RestController
@RequestMapping("/users/")
public class UserController {

	@Autowired
	private UsersServiceImpl uService;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDTO loginDto){
        String token = uService.login(loginDto);
        loginDto.setPassword(passwordEncoder.encode(loginDto.getPassword()));
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }
	
	@PostMapping("/create")
	public ResponseEntity<UsersResponse> Cusers(@RequestBody Users user) throws UsersException{
		user.setFullName(user.getFullName());
		user.setUsername(user.getUsername());
		user.setEmail(user.getEmail());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setDateOfBirth(user.getDateOfBirth());
		user.setAddress(user.getAddress());
		user.setPhoneNumber(user.getPhoneNumber());
		UsersResponse new_user=uService.cUsers(user);
		return new ResponseEntity<>(new_user, HttpStatus.CREATED);
	}
	
	@GetMapping("getToken")
	public ResponseEntity<String> getAPI()throws UsersException {
	    return ResponseEntity.ok("Hello User");
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<UsersResponse>> Gusers()throws UsersException{
		List<UsersResponse> all_users=uService.gAllusers();
		return new ResponseEntity<>(all_users, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<UsersResponse> GusersById(@PathVariable("Id") Long userId, @RequestBody LoginDTO logins) throws UsersException{
		UsersResponse single_user=uService.gUsersId(userId,logins);
		return new ResponseEntity<>(single_user, HttpStatus.OK);
	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<String> DusersById(@PathVariable("Id") Long userId){
		String deletion=uService.dUsersId(userId);
		return new ResponseEntity<>(deletion, HttpStatus.ACCEPTED);
	}
}
