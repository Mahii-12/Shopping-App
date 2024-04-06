package com.example.demo.DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrdersDto {

	private Long orderId;
	private double amount;
	private LocalDate date;
	private String coupon;
	private String status;
	
	public OrdersDto() {}
	
	/**
	 * @param orderId
	 * @param amount
	 * @param date
	 * @param coupon
	 * @param status
	 */
	public OrdersDto(Long orderId, double amount, LocalDate date, String coupon, String status) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.date = date;
		this.coupon = coupon;
		this.status = status;
	}
	
	/**
	 * @return the userId
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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
	
	 public String getFormattedDate() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        return date.format(formatter);
	    }
	
}
