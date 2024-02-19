package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configurations.JwtGenVal;
import com.example.demo.entity.User;
import com.example.demo.entity.UserDto;
import com.example.demo.service.UserServiceImpl;

@RestController
@RequestMapping("/AuthUser")
public class UserController {
   
	@Autowired
	private UserServiceImpl userservice;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JwtGenVal jwtGenVal;
	
	@Autowired
	BCryptPasswordEncoder bcCryptPasswordEncoder;
	
	
	 
	@PostMapping("/registration")
	public ResponseEntity<Object> registeruser(@RequestBody UserDto userDto) {
		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setPassword(bcCryptPasswordEncoder.encode(userDto.getPassword()));
		user.setUsername(userDto.getUsername());
		User users = userservice.save(user);
		if (users.equals(null))
			return generateRespose("Not able to save user ", HttpStatus.BAD_REQUEST, user);
		else
			return generateRespose("User saved successfully : " + users.getId(), HttpStatus.OK, users);
	}
	
    @GetMapping("/login")
	public String generateJwtToken(@RequestBody UserDto userDto) throws Exception {
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
		} catch (Exception ex) {
			throw new Exception("invalid username/password");
		}
		return jwtGenVal.generateToken(userDto.getUsername());
	}

	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}
	
	public ResponseEntity<Object> generateRespose(String message, HttpStatus st, Object responseobj) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("meaasge", message);
		map.put("Status", st.value());
		map.put("data", responseobj);

		return new ResponseEntity<Object>(map, st);
	}
	
}
