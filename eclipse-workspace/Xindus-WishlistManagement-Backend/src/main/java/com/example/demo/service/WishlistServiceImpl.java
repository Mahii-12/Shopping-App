package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDto;
import com.example.demo.entity.User;
import com.example.demo.entity.Wishlist;
import com.example.demo.entity.WishlistDto;
import com.example.demo.exception.InvalidException;
import com.example.demo.exception.NotAuthorisedException;
import com.example.demo.exception.UserException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WishlistRepository;

@Service
public class WishlistServiceImpl implements WishlistService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WishlistRepository wishlistRepository;
	
	
	public WishlistDto createItemWishlist(Long wishlistId) throws UserException {
	    String username = SecurityContextHolder.getContext().getAuthentication().getName();
	   
	    Optional<Product> pro = productRepository.findById(wishlistId);

	    if (pro.isEmpty()) {
	        // Handle the case when product is not found
	        throw new UserException("Product not found");
	    }

	    Product prod = pro.get();
	    User authUser = prod.getWishlist().getUser(); // Assuming each product has a wishlist and each wishlist belongs to a user

	    if (authUser == null) {
	        // Handle the case when user is not found
	        throw new UserException("User not found");
	    }


	    List<Wishlist> wishlists = authUser.getWishlists();

	    // If the user has no wishlist, create a new one
	    if (wishlists.isEmpty()) {
	        Wishlist newWishlist = new Wishlist();
	        newWishlist.setUser(authUser);
	        wishlists.add(newWishlist);
	    }

	    // Add the product to each wishlist
	    for (Wishlist wishlist : wishlists) {
	        wishlist.getItems().add(prod);
	    }

	    userRepository.save(authUser); // This will cascade save the wishlists

	    // Create response DTO and populate it with wishlist ID and product details
	    WishlistDto responseDto = new WishlistDto();
	    responseDto.setWishlistId(wishlistId);

	    List<ProductDto> productDtos = new ArrayList<>();
	    for (Wishlist wishlist : wishlists) {
	        for (Product product : wishlist.getItems()) {
	            ProductDto productDto = new ProductDto();
	            productDto.setProductId(product.getProductId());
	            productDto.setName(product.getName());
	            productDto.setDescription(product.getDescription());
	            productDto.setPrice(product.getPrice());
	            productDto.setStockQuantity(product.getStockQuantity());
	            productDtos.add(productDto);
	        }
	    }
	    responseDto.setItems(productDtos);

	    return responseDto;
	}
	
	
	@Override
	public List<Wishlist> getItemWishlist()throws UserException{
		String authUser=SecurityContextHolder.getContext().getAuthentication().getName();
		Optional<User> usr = userRepository.findByEmail(authUser);
		if(usr.isEmpty()) {
			throw new UserException("User not found");
		}
		User loggedUser = usr.get();
		
		List<Wishlist> wishlist = loggedUser.getWishlists();
		return wishlist;
	}
	
	
	@Override
	public Wishlist deleteWishlistItemById(Long wishlistId)throws UserException,NotAuthorisedException,InvalidException{
	    // Get the authenticated user's username
	    String authUsername = SecurityContextHolder.getContext().getAuthentication().getName();

	    // Find the user by ID
	    Optional<User> userOptional = userRepository.findById(wishlistId);
	    if (userOptional.isEmpty()) {
	        throw new UserException("User not found with ID");
	    }
	    User user = userOptional.get();

	    // Check if the authenticated user is the owner of the wishlist
	    if (!user.getUsername().equals(authUsername)) {
	        throw new NotAuthorisedException("You are not authorized to delete this wishlist item");
	    }

	    // Find the product by ID
	    Optional<Product> productOptional = productRepository.findById(wishlistId);
	    if (productOptional.isEmpty()) {
	        throw new InvalidException("Product not found with ID");
	    }
	    Product product = productOptional.get();

	    // Get the user's wishlist
	    List<Wishlist> wishlist = user.getWishlists();

	    // Find the wishlist containing the product
	    Wishlist userWishlist = wishlist.stream()
	            .filter(w -> w.getItems().contains(product))
	            .findFirst()
	            .orElseThrow(() -> new InvalidException("Wishlist containing the product not found"));

	    // Remove the product from the wishlist
	    userWishlist.getItems().remove(product);

	    // Save the changes
	    wishlistRepository.save(userWishlist);

	    return userWishlist;
	}





	

	
}



















