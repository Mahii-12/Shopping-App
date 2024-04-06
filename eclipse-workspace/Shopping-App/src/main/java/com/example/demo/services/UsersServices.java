package com.example.demo.services;

import java.util.List;

import com.example.demo.DTO.UsersDto;
import com.example.demo.exceptions.UsersExceptions;
import com.example.demo.model.Users;

public interface UsersServices {

	public UsersDto createUser(Users user) throws UsersExceptions;
	public UsersDto getUserByID(Long userId) throws UsersExceptions;
	public List<Users> getAllUsers() throws UsersExceptions;
	public String deleteUserByID(Long userId);
	
}
