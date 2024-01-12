package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {

	@Autowired
    private UserRepo userRepository;
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    @Cacheable(cacheNames = "users", key="#id")
    public User getUserById(Long id) {
    	logger.info("fetching user from db");
      	 Optional<User> user = userRepository.findById(id);
           if (user.isPresent()) {
               return user.get();
           } else {
               return new User();
           }
    }

    @CachePut(cacheNames = "users", key="#user.id")
    public User saveUser(User user) {
    	logger.info("adding user with id - {}",user.getId());
        return userRepository.save(user);
    }

    @CacheEvict(cacheNames="users", key="#id")
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "DELETED";
    }

	public void register(String username, String password) throws Exception {
		if (userRepository.existsByUsername(username)) {
            throw new Exception("Username is already taken. Please choose another.");
        }

        // Perform user registration logic, such as creating a new user entity
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password); // Note: In a real-world scenario, you would hash the password

        // Save the new user to the database
        userRepository.save(newUser);
		
	}

	public boolean loginUser(String username, String password) {
		User newUser = new User();
        newUser.getUsername();
        newUser.getPassword(); 
        if(newUser.getUsername().equals(newUser.getPassword())) {
        	return false;
        }
        else {
        	return true;
        }
   
		
	}

	

	
	
}
