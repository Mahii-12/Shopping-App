package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserDto;
import com.example.demo.entity.Wishlist;
import com.example.demo.entity.WishlistDto;

public interface WishlistService {
 
	public WishlistDto createItemWishlist(Long wishlistId);
	public List<Wishlist> getItemWishlist();
	public Wishlist deleteWishlistItemById(Long wishlistId);
	
	
}
