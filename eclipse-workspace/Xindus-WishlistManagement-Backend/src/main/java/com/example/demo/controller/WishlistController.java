package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Wishlist;
import com.example.demo.entity.WishlistDto;
import com.example.demo.service.UserServiceImpl;
import com.example.demo.service.WishlistServiceImpl;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {
     
	@Autowired
	private WishlistServiceImpl wishlistService;
	
	@Autowired
	private UserServiceImpl userService;
	
	
	// Endpoint to create a new wishlist
   @PostMapping("/create")
	public ResponseEntity<WishlistDto> createWishlist(@RequestParam Long wishlistId){
		WishlistDto addedProduct = wishlistService.createItemWishlist(wishlistId);
		return new ResponseEntity<>(addedProduct,HttpStatus.CREATED);
	}

    // Endpoint to get a wishlists
    @GetMapping("/Getwishlists")
	public ResponseEntity<List<Wishlist>> getLoggedInUserWishlistHandler() {
		List<Wishlist> loggedUserWishlist = wishlistService.getItemWishlist();
		return new ResponseEntity<>(loggedUserWishlist,HttpStatus.OK);
	}
    
    // Endpoint to delete a wishlist by wishlistId
    @DeleteMapping("/wishlists/{Id}")
    public ResponseEntity<Wishlist> deleteProductFromWishlistHandler(@PathVariable("Id") Long Id) {
		Wishlist deletedProduct = wishlistService.deleteWishlistItemById(Id);
		return new ResponseEntity<>(deletedProduct,HttpStatus.OK);
	}
   	
}
