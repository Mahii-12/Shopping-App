package com.example.demo.DTO;

public class FailedOrderDto {

	private Long orderId;
	private Long userId;
	private String transactionId;
	private String Status;
	private String description;
	
	/**
	 * @param orderId
	 * @param userId
	 * @param transactionId
	 * @param status
	 * @param description
	 */
	public FailedOrderDto(Long orderId, Long userId, String transactionId, String status, String description) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.transactionId = transactionId;
		Status = status;
		this.description = description;
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
		return Status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		Status = status;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
