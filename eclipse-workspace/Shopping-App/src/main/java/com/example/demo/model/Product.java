package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	private String productName;
	private double productPrice;
	private int availableQuantities;
	
    public Product() {}

	/**
	 * @param productId
	 * @param productName
	 * @param productPrice
	 * @param availableQuantities
	 */
	public Product(Long productId, String productName, double productPrice, int availableQuantities) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.availableQuantities = availableQuantities;
	}

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the availableQuantities
	 */
	public int getAvailableQuantities() {
		return availableQuantities;
	}

	/**
	 * @param availableQuantities the availableQuantities to set
	 */
	public void setAvailableQuantities(int availableQuantities) {
		this.availableQuantities = availableQuantities;
	}
    
    
	
}
