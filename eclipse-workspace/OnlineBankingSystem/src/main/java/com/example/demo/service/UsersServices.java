package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.UsersResponse;
import com.example.demo.entity.Users;
import com.example.demo.exception.UsersException;

public interface UsersServices {
	
	public UsersResponse cUsers(Users user) throws UsersException;
	public List<UsersResponse> gAllusers();
	public UsersResponse gUsersId(Long userId, LoginDTO logins) throws UsersException;
	public Users uUsers(Users user);
	public String dUsersId(Long userId);
	public String login(LoginDTO loginDto) ;

}
