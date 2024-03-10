package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.exception.UsersException;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImplementation implements UsersService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public Users createUser(Users user) throws UsersException{
		String fullName=user.getFullName();
		if(user != null && fullName != null && !fullName.isEmpty()) {
			Long userID=user.getUser_id();
			Optional<Users> id=userRepository.findById(userID);
			if(!id.isPresent()) {
				user.setProjects(projectRepository.findAll());
				return userRepository.save(user);
			}
			else {
				throw new UsersException(userID + " User Already Exist!");
			}
		}
		else {
		    throw new UsersException("Please Register !");
		}
	}

	@Override
	public Optional<Users> viewUserWithId(Long user_id) throws UsersException{
		if(userRepository.existsById(user_id)) {
			return userRepository.findById(user_id);
		}
		else {
			throw new UsersException("Not Exist! ");
		}
	}

	@Override
	public List<Users> viewAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public String deleteUserWithId(Long user_id) throws UsersException{
		if(userRepository.existsById(user_id)) {
			userRepository.deleteById(user_id);
			throw new UsersException("Successfully Deleted!");
		}
		else {
			throw new UsersException("User Not Exist!");
		}
	}

}
