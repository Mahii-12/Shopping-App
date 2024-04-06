package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.UsersDto;
import com.example.demo.exceptions.UsersExceptions;
import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UsersServiceImpl implements UsersServices{
	
	@Autowired
	private UserRepository uRepository;

	@Override
	public UsersDto createUser(Users user)throws UsersExceptions{
		Optional<Users> byUserName=uRepository.getByUsername(user.getUsername());
		if(byUserName.isPresent()) {
			throw new UsersExceptions(byUserName + " Is Already Exists !");
		}
		else {
			uRepository.save(user);
			UsersDto gUser = mapToUsersDto(user);
			return gUser;
		}
	}

	@Override
	public UsersDto getUserByID(Long userId) throws UsersExceptions{
		if(!uRepository.findById(userId).isPresent()) {
			throw new UsersExceptions(userId + " Is not Exist!");
		}
		else {
			  Users nUser = uRepository.findById(userId).get();
	          UsersDto gUser = mapToUsersDto(nUser);
	          return gUser;
		}
	}

	@Override
	public List<Users> getAllUsers() {
		List<Users> users=uRepository.findAll();
		return users;
	}

	@Override
	public String deleteUserByID(Long userId) {
		if(uRepository.existsById(userId)) {
			uRepository.deleteById(userId);
			return userId + " Is Successfully Deleted! ";
		}
		else {
			return userId + " Is Not Exists! ";
		}
	}
	
	private UsersDto mapToUsersDto(Users user) {
	     UsersDto response = new UsersDto();
	     response.setUserId(user.getUserId());
	     response.setUsername(user.getUsername());
	     response.setEmail(user.getEmail());
	     return response;
	}

	
}
