package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.OrderException;
import com.example.demo.exceptions.ProductException;
import com.example.demo.model.Product;
import com.example.demo.services.ProductServiceImpl;

@RestController
public class ProductController {

	@Autowired
	private ProductServiceImpl pService;
	
	@PostMapping("/add")
	public ResponseEntity<Product> aProduct(@RequestBody Product product) throws ProductException{
		return new ResponseEntity<>(pService.cProduct(product), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allProducts")
	public ResponseEntity<List<Product>> AllProducts(){
		return new ResponseEntity<>(pService.allProducts(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> GProductByID(@PathVariable Long productId) throws ProductException{
		return new ResponseEntity<>(pService.gProductById(productId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/Byorder/{orderId}")
	public ResponseEntity<List<Product>> GProductByOrder(@PathVariable Long orderId) throws OrderException{
		return new ResponseEntity<>(pService.gProductByOrderid(orderId), HttpStatus.ACCEPTED);
	}
	
}
