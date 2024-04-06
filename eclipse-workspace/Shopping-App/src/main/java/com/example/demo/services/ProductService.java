package com.example.demo.services;

import java.util.List;

import com.example.demo.exceptions.OrderException;
import com.example.demo.exceptions.ProductException;
import com.example.demo.model.Product;

public interface ProductService {

	public Product cProduct(Product product) throws ProductException;
	public List<Product> allProducts();
	public Product gProductById(Long productId)throws ProductException;
	public List<Product> gProductByOrderid(Long orderId)throws OrderException;
	
}
