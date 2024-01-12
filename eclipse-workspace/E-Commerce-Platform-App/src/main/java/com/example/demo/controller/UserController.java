package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.User;
import com.example.demo.services.UserService;

@Controller
public class UserController {

	@Autowired
    private UserService userService;
	
	 /**
	 * @param userService
	 */
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/api/register")
	@ResponseBody
	public String registerUser(@RequestParam("username") String username,
	                               @RequestParam("password") String password) {
	        // Process user registration logic using UserService
	        try {
				userService.register(username, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        // Redirect to a success page or the home page
	        return "redirect:/home";
	    }
	 @GetMapping("/get")
	 @ResponseBody
	 public User getUserr( long id) {
		 return userService.getUserById(id);
		 
	 }
	 
	 @PostMapping("/api/login")
	 public String login(@RequestParam("username") String username,
	                               @RequestParam("password") String password) {
	        boolean loginSuccessful = userService.loginUser(username, password);

	        // Redirect to appropriate page based on login success
	        if (loginSuccessful) {
	            // Redirect to the home page or a dashboard
	            return "redirect:/home";
	        } else {
	            // Redirect back to the login page with an error message
	            return "redirect:/login?error";
	        }
	    

	 }
	
}
