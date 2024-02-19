package com.example.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.service.UserServiceImpl;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
	@Autowired
    private UserServiceImpl userService;
     
    @Autowired
    private JwtFilter jwtFilter;
     
    @Bean
 	public BCryptPasswordEncoder passwordEncoder() {
 		return new BCryptPasswordEncoder();
 	}
    
//	@Bean
//  public UserServiceImpl userDetailsService() {
//      UserServiceImpl userDetails = User.builder().
//              username("Mahender")
//              .password(passwordEncoder().encode("mahee123@gmail.com")).roles("User").
//              build();
//      return new InMemoryUserDetailsManager(userDetails);
//  }
     
     @Bean
 	public DaoAuthenticationProvider authenticationProvider() {
 		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
 		auth.setUserDetailsService(userService);
 		auth.setPasswordEncoder(passwordEncoder());
 		return auth;
 	}
     
     @Bean
 	public AuthenticationManager authenticationManager(AuthenticationConfiguration autheticationConfiguration)
 			throws Exception {
 		return autheticationConfiguration.getAuthenticationManager();
 	}
     
     @SuppressWarnings("removal")
	@Bean
 	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
 		http.cors().and().csrf().disable().authorizeRequests().requestMatchers("/AuthUser/**").permitAll().requestMatchers("/api/wishlists/**").permitAll()
 		.requestMatchers("/products/**").permitAll().anyRequest()
 				.authenticated().and().sessionManagement()
                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
 		 http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
 		return http.build();

 	}
}
