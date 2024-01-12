package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.cache.annotation.Cacheable;

import com.example.demo.model.Product;




public interface ProductRepo extends JpaRepository<Product,Long>{
	  
}
