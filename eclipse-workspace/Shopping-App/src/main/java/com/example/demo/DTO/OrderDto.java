package com.example.demo.DTO;

public class OrderDto {

	private Long userId;
	private Long orderId;
	private String transactionId;
	private String status;
	
	/**
	 * @param userId
	 * @param orderId
	 * @param transactionId
	 * @param status
	 */
	public OrderDto(Long orderId, Long userId, String status, String transactionId) {
		this.orderId = orderId;
		this.userId = userId;
		this.transactionId = transactionId;
		this.status = status;
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
	
	

}
