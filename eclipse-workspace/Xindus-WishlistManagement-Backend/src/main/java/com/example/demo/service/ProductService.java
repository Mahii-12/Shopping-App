package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDto;

public interface ProductService {
	 
    public Product addProduct(Product product);
	
    public Product viewProduct(Long productId);
    
	public List<Product> viewAllProducts();

	public Product updateProduct(double productId, double productPrice);
	
	public Product deleteProduct(Long productId);

}
