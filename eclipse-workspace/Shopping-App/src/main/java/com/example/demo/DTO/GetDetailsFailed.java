package com.example.demo.DTO;

public class GetDetailsFailed {

	private Long orderid;
	private String Description;
	
	/**
	 * @param orderid
	 * @param description
	 */
	public GetDetailsFailed(Long orderid, String description) {
		super();
		this.orderid = orderid;
		Description = description;
	}

	/**
	 * @return the orderid
	 */
	public Long getOrderid() {
		return orderid;
	}

	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	
	
}
