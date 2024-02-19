package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="wishlists")
public class Wishlist {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long wishlistId;
    private String title;
    private String status;
    
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> items=new ArrayList<>();
    
    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
   
    
	    
}
