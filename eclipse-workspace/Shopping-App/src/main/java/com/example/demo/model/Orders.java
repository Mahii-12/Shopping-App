package com.example.demo.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	private int quantity;
	private String coupon;          
	private double amount;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate date;                  
    private String status;               
	private String transactionId; 
	
	
	@ManyToOne
    @JoinColumn(name = "userId")
    private Users user;
	
	@ManyToMany
    @JoinTable(
        name = "products",
        joinColumns = @JoinColumn(name = "orderId"),
        inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product> products;

	
	public Orders() {}

	/**
	 * @param orderId
	 * @param quantity
	 * @param coupons
	 * @param amount
	 * @param date
	 * @param status
	 * @param transactionId
	 * @param username
	 */
	public Orders(Long orderId, int quantity, String coupon, double amount, LocalDate date, String status,
			String transactionId, Users user, List<Product> products) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.coupon = coupon;
		this.amount = amount;
		this.date = date;
		this.status = status;
		this.transactionId = transactionId;
		this.user = user;
		this.products=products;
	}

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the coupons
	 */
	public String getCoupon() {
		return coupon;
	}

	/**
	 * @param coupons the coupons to set
	 */
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the username
	 */
	public Users getUsername() {
		return user;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(Users user) {
		this.user = user;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
}
