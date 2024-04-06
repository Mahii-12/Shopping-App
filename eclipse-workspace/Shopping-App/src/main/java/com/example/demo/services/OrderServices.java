package com.example.demo.services;

import java.util.List;

import com.example.demo.DTO.InventoryDto;
import com.example.demo.DTO.PerfectOrder;
import com.example.demo.exceptions.OrderException;

public interface OrderServices {

	public Object pOrder(Long userId, int qty, String couponCode) throws OrderException;
	public Object POrderByUser(Long userId, Long orderId, double Amount) throws OrderException;
	public List<PerfectOrder> OrderByUserId(Long userId)throws OrderException;
	public Object OrderById(Long orderId, Long userId) throws OrderException;
	public List<String> AllCoupons() throws OrderException;
	public InventoryDto inventory(Long orderId, int ordered) throws OrderException;
	
}
