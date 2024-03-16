package com.example.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {
	
	@Autowired
	private UserDetailsService userDetailsService;

    @Autowired
	private AuthenticationFilter authFilter;
	
	@Autowired
	private JWTAuthenticationEntryPoint entryPoint;
	
	@Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	  http.csrf(csrf -> csrf.disable())
	  .authorizeHttpRequests((authorize) -> {
		 // authorize.requestMatchers("/auth/**").permitAll();
		  authorize.requestMatchers("/users/**").permitAll();
		  authorize.requestMatchers("/account/**").permitAll();
		  authorize.requestMatchers("/transaction/**").permitAll();
	  });
	  
     http.exceptionHandling(exception -> exception
		  .authenticationEntryPoint(entryPoint)
			  );	  
	  http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
	  
	  return http.build();
	}
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
