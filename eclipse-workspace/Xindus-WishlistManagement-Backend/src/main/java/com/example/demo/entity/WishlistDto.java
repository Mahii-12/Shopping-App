package com.example.demo.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishlistDto {
   
	private Long wishlistId;
    private String title;
    private String status;
    private List<ProductDto> items;
    
}
