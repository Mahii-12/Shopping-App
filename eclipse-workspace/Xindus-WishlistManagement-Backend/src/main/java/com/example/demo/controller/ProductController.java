package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDto;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products/")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<Product>  createitem(@RequestBody Product product) {
		Product Createdproduct=productService.addProduct(product);
		return new ResponseEntity<>(Createdproduct,HttpStatus.CREATED);
	}
	
	@GetMapping("/view")
	public ResponseEntity<Product>  viewItem(@RequestParam Long productId) {
		Product viewItems=productService.viewProduct(productId);
		return new ResponseEntity<Product>(viewItems,HttpStatus.OK);
	}
	
	@GetMapping("/Allproduct")
	public ResponseEntity<List<Product>>  viewAllitems(){
		List<Product> allItems=productService.viewAllProducts();
		return new ResponseEntity<>(allItems,HttpStatus.OK);
	}
	
	@PutMapping("/Update")
	public ResponseEntity<Product>  updateItem(@RequestParam double productId, @RequestParam double price) {
		Product Existitem=productService.updateProduct(productId, price);
		return new ResponseEntity<>(Existitem,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Product>  deleteItem(@RequestParam Long productId) {
		Product removeItem=productService.deleteProduct(productId);
		System.out.println("DELETED");
		return new ResponseEntity<>(removeItem,HttpStatus.OK); 
	}
}
