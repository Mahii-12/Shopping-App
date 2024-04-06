package com.example.demo.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.example.demo.DTO.InventoryDto;
import com.example.demo.DTO.PerfectOrder;
import com.example.demo.exceptions.OrderException;
import com.example.demo.model.Orders;
import com.example.demo.services.OrderServiceImpl;

@WebMvcTest(OrderServiceImpl.class)
public class OrderServiceImplTest {

	@Autowired
	private OrderServiceImpl oService;
	
	@Test
	void inventorytest() throws OrderException {
		Long orderId = 1234L;
		int ordered=10;
        InventoryDto result = oService.inventory(orderId, ordered);
        assertNotNull(result);
        assertEquals(orderId, result.getAvailable());
        assertEquals(ordered, result.getOrdered());
	}
	
	@Test
	void testAllCoupons() throws OrderException {
		final String off5="OFF5";
		final String off10="OFF10";
		Orders or=new Orders();
		List<String> result = oService.AllCoupons();
		assertNotNull(result);
        assertEquals(off5, or.getCoupon());
        assertEquals(off10, or.getCoupon());
	}
	
	@Test
	void testpOrder() throws OrderException {
		Long userId=123L;
		int qty=10; 
		String couponCode="OFF5";
		Orders or=new Orders();
		Object result=oService.pOrder(userId, qty, couponCode);
		assertNotNull(result);
        assertEquals(userId, or.getUsername());
        assertEquals(qty, or.getQuantity());
        assertEquals(couponCode, or.getCoupon());
	}
	
	@Test
	void testPOrderByUser() throws OrderException {
		Long userId=123L;
		Long orderId=12L;
		double Amount=200;
		Orders or=new Orders();
		Object result=oService.POrderByUser(userId, orderId, Amount);
		assertNotNull(result);
        assertEquals(userId, or.getUsername());
        assertEquals(orderId, or.getOrderId());
        assertEquals(Amount, or.getAmount());
	}
	
	@Test
	void testOrderByUserId() throws OrderException {
		Long userId=123L;
		Orders or=new Orders();
		List<PerfectOrder> result=oService.OrderByUserId(userId);
		assertNotNull(result);
        assertEquals(userId, or.getUsername());
	}
	
	@Test
	void testOrderById() throws OrderException {
		Long orderId=123L;
		Long userId=123L;
		Orders or=new Orders();
		Object result=oService.OrderById(orderId, userId);
		assertNotNull(result);
        assertEquals(userId, or.getUsername());
        assertEquals(orderId, or.getOrderId());
	}
	
	
}









