package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;

@Service
public class ProductService {
   
	@Autowired
    private ProductRepo productRepository;
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Cacheable(cacheNames = "products", key="#id")
    public Product getProductById(Long id) {
    	logger.info("fetching product from db");
   	 Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            return new Product();
        }
    }

    @CachePut(cacheNames = "products", key="#product.id")
    public Product saveProduct(Product product) {
    	logger.info("adding product with id - {}",product.getId());
        return productRepository.save(product);
    }

    @CacheEvict(cacheNames="products", key="#id")
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "DELETED";
    }
	
}
