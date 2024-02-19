package com.example.demo.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
   

   private String username;
   private String email;
   private String password;
   private List<Wishlist> wishlists;

		
   
		
		   
}
