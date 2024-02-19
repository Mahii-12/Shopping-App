package com.example.demo.service;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
	    if (user == null) {
	        throw new UsernameNotFoundException("User not found with username: " + username);
	    }
	    // Create a new UserDetails object with user details
	    return  user;
	}


	public User save(User user) {
		return userRepository.save(user);
	}

}	
	
