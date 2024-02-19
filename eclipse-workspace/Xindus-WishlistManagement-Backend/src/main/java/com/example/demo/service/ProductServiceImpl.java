package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDto;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
     private ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product viewProduct(Long productId) throws ProductNotFoundException{
		Optional<Product> product=productRepository.findById(productId);
		if(product.isEmpty()) {
			throw new ProductNotFoundException(productId + " Is not there in the list");
		}
		Product prsntProduct=product.get();
		return prsntProduct;
	}

	@Override
	public Product updateProduct(double productId, double productPrice) throws ProductNotFoundException{
		Optional<Product> product=productRepository.findById((long) productId);
		if(product.isEmpty()) {
			throw new ProductNotFoundException(productId + " " + " is not available " + " " + productPrice);
		}
		Product prsntProduct = product.get();
		prsntProduct.setPrice(productPrice);
		return productRepository.save(prsntProduct);
	}

	@Override
	public List<Product> viewAllProducts() throws ProductNotFoundException{
		List<Product> product=productRepository.findAll();
		if(product.isEmpty()) {
			throw new ProductNotFoundException("There are No products");
		}
		List<Product> allProducts = new ArrayList<>();
		for(int i=0;i<product.size();i++) {
			allProducts.add(product.get(i));
		}
		return allProducts;
	}
	
	@Override
	public Product deleteProduct(Long productId) throws ProductNotFoundException{
		Optional<Product> product=productRepository.findById(productId);
		if(product.isEmpty()) {
			throw new ProductNotFoundException("No Products!");
		}
		Product delProduct=product.get();
		productRepository.delete(delProduct);
		return delProduct;
		
	}

}
