package com.example.demo.entity;

import lombok.*;

@Getter
@Setter
public class ProductDto {

	private Long productId;
    private String name;
    private String description;
    private double price;
    private double stockQuantity;
    private Long wishlistId;
	

}
