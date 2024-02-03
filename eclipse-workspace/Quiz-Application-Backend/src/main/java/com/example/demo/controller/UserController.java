package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

import ch.qos.logback.core.model.Model;

@Controller
public class UserController {
	 
	    @Autowired
	    private UserRepo userRepository;

	    @GetMapping("/register")
	    public String showRegistrationForm(Model model) {
	        model.addAttribute("user", new User());
	        return "registration";
	    }

	    @PostMapping("/register")
	    public String registerUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
	        if (result.hasErrors()) {
	            return "registration";
	        }
	        userRepository.save(user);
	        return "redirect:/users/login";
	    }

	    @GetMapping("/login")
	    public String showLoginForm() {
	        return "login";
	    }
}
