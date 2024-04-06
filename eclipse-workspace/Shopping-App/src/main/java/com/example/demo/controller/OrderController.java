package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.InventoryDto;
import com.example.demo.exceptions.OrderException;
import com.example.demo.model.Orders;
import com.example.demo.services.OrderServiceImpl;

@RestController
public class OrderController {

	@Autowired
	private OrderServiceImpl oService;

	@GetMapping("/inventory/{ordered}")
	public ResponseEntity<InventoryDto> in(@RequestParam Long orderId, @PathVariable int ordered) throws OrderException{
		return new ResponseEntity<>(oService.inventory(orderId, ordered), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/fetchCoupons")
	public ResponseEntity<List<String>> aCoupons() throws OrderException{
		return new ResponseEntity<>(oService.AllCoupons(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{userId}/order")
	public ResponseEntity<?> pOrders(@PathVariable Long userId, @RequestParam int qty, @RequestParam String couponCode) throws OrderException{
		return new ResponseEntity<>(oService.pOrder(userId, qty, couponCode), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{userId}/{orderId}/pay")
	public ResponseEntity<?> pOrderUser(@PathVariable Long userId, @PathVariable Long orderId, @RequestParam double amount) throws OrderException {
		return new ResponseEntity<>(oService.POrderByUser(userId, orderId, amount), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{userId}/orders")
	public ResponseEntity<?> gOrderById(@PathVariable Long userId) throws OrderException{
		return new ResponseEntity<>(oService.OrderByUserId(userId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{userId}/orders/{orderId}")
	public ResponseEntity<?> gOrderByUserandOrder(@PathVariable Long userId, @PathVariable Long orderId) throws OrderException{
		return new ResponseEntity<>(oService.OrderById(orderId, userId), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/addd")
	public ResponseEntity<Orders> AA(@RequestBody Orders order){
		return new ResponseEntity<>(oService.created(order), HttpStatus.ACCEPTED);
	}
}
























