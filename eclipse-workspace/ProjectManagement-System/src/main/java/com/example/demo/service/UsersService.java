package com.example.demo.service;

import java.util.*;

import com.example.demo.entity.Users;

public interface UsersService {

	public Users createUser(Users user);
	public Optional<Users> viewUserWithId(Long user_id);
	public List<Users> viewAllUsers();
	public String deleteUserWithId(Long user_id);
}
