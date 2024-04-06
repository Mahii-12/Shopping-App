package com.example.demo.DTO;

public class OrderDtoFailed {

	private String Description;
	
	
	
	/**
	 * @param description
	 */
	public OrderDtoFailed( String description) {
		super();
		Description = description;
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
