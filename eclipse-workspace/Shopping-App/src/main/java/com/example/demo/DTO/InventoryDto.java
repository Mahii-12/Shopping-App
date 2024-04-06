package com.example.demo.DTO;

public class InventoryDto {

	private int ordered;
    private double price;
    private int available;
    
    public InventoryDto() {};
    
	/**
	 * @param ordered
	 * @param price
	 * @param available
	 */
	public InventoryDto(int ordered, double price, int available) {
		super();
		this.ordered = ordered;
		this.price = price;
		this.available = available;
	}

	/**
	 * @return the ordered
	 */
	public int getOrdered() {
		return ordered;
	}

	/**
	 * @param ordered the ordered to set
	 */
	public void setOrdered(int ordered) {
		this.ordered = ordered;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the available
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(int available) {
		this.available = available;
	}
    
    

}
