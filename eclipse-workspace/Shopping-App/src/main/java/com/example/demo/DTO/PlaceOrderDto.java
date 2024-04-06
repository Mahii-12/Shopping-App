package com.example.demo.DTO;


public class PlaceOrderDto {

	private Long orderId;
	private Long userId;
	private int Quantity;
	private double amount;
	private String coupon;
	
	/**
	 * @param orderId
	 * @param quantity
	 * @param userId
	 * @param amount
	 * @param coupon
	 */
	public PlaceOrderDto(Long orderId, Long userId, int quantity, double amount, String coupon) {
		super();
		this.orderId = orderId;
		Quantity = quantity;
		this.userId = userId;
		this.amount = amount;
		this.coupon = coupon;
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
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return Quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		Quantity = quantity;
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
	 * @return the coupon
	 */
	public String getCoupon() {
		return coupon;
	}

	/**
	 * @param coupon the coupon to set
	 */
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	
	
	
}
