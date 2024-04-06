package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.FailedOrderDto;
import com.example.demo.DTO.GetDetailsFailed;
import com.example.demo.DTO.InventoryDto;
import com.example.demo.DTO.OrderDto;
import com.example.demo.DTO.OrderDtoFailed;
import com.example.demo.DTO.OrdersDto;
import com.example.demo.DTO.PerfectOrder;
import com.example.demo.DTO.PlaceOrderDto;
import com.example.demo.exceptions.OrderException;
import com.example.demo.model.Coupon;
import com.example.demo.model.Orders;
import com.example.demo.model.Users;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderServices{

	@Autowired
	private OrderRepository oRepository;
	
	@Autowired
	private UserRepository uRepository;

	@Override
	public InventoryDto inventory(Long orderId, int ordered) throws OrderException {
		Orders order=oRepository.findById(orderId).get();
		InventoryDto in = new InventoryDto();
		if(ordered < 0 || ordered > order.getQuantity()) {
			throw new OrderException("Invalid Orders");
		}
		else {
			in.setAvailable(order.getQuantity());
			in.setOrdered(ordered);
			in.setPrice(order.getAmount());
			return in;
		}
	}
	
	@Override
	public List<String> AllCoupons() throws OrderException {
		return Coupon.getAllCoupons();
	}
	
	@Override
	public Object pOrder(Long userId, int qty, String couponCode) throws OrderException {
		Users user = uRepository.findById(userId).get();
		Orders order = oRepository.findById(userId).get();
		if(!uRepository.existsById(user.getUserId())) {
			throw new OrderException(userId + " Is not Exist! ");
		}
		else {
			 double totalPrice = calculateTotalPrice(qty);
			 double discountedPrice = applyCoupon(totalPrice, couponCode);
			 System.out.println("The Order got qnty is: " + order.getQuantity() + " USER ID " + user.getUserId());
			// System.out.println("The User got qnty is: " + user.getUserId());
			 if (qty < 1 || qty > order.getQuantity()) {
				 return new OrderDtoFailed("Invalid Quantity !");
			 }
			 if(!couponCode.equals("OFF5") && !couponCode.equals("OFF10")) {
				 return new OrderDtoFailed("Invalid Coupon !");
			 }
				 order.setOrderId(user.getUserId());
				 order.setUsername(user);
				 order.setQuantity(qty);
				 order.setAmount(discountedPrice);
				 order.setCoupon(couponCode);
				 order = oRepository.save(order);
				 return new PlaceOrderDto(order.getOrderId(), user.getUserId(), qty, totalPrice, couponCode);
		}
		
	}
	
	@Override
	public Object POrderByUser(Long userId, Long orderId, double Amount) throws OrderException {
		Users user = uRepository.findById(userId).get();
		Orders order = oRepository.findById(orderId).get();
		if(!uRepository.existsById(userId)) {
			throw new OrderException(userId + " Is not Exist! ");
		}
		else if(!oRepository.existsById(orderId)) {
			throw new OrderException(orderId + " Is not Exist! ");
		}
		String transactionId = generateTransactionId();
		int statusCode = (int) (Math.random() * 6) + 1;
		switch (statusCode) {
			 case 1:
				 order.setOrderId(orderId);
				 order.setUsername(user);
				 order.setQuantity(order.getQuantity());
				 order.setAmount(Amount);
				 order.setCoupon(order.getCoupon());
				 order.setStatus("Successfull");
				 order.setTransactionId(transactionId);
				 order = oRepository.save(order);
				 return new OrderDto(order.getOrderId(), user.getUserId(),"Successfull", transactionId);
			
		     case 2:
		         return new FailedOrderDto(userId, orderId, transactionId, "failed",
		                         "Payment Failed as amount is invalid");
		     case 3:
		         return new FailedOrderDto(userId, orderId, transactionId, "failed",
		                         "Payment Failed from bank");
		     case 4:
		         return new FailedOrderDto(userId, orderId, transactionId, "failed",
		                         "Payment Failed due to invalid order id");
		     case 5:
		         return new FailedOrderDto(userId, orderId, transactionId, "failed",
		                         "No response from payment server");
		     case 6:
		         return new FailedOrderDto(userId, orderId, transactionId, "failed",
		                         "Order is already paid for");
		     default:
	             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	}
	
	@Override
	public List<PerfectOrder> OrderByUserId(Long userId) throws OrderException {
		List<PerfectOrder> orderDtos = new ArrayList<>();
		if(!uRepository.existsById(userId)) {
			throw new OrderException(userId + " Is not Exist! ");
		}
		else {
			List<Orders> userOrders = oRepository.findByUserUserId(userId);
	        for (Orders order : userOrders) {
	            orderDtos.add(new PerfectOrder(order.getOrderId(), order.getAmount(), order.getDate(), order.getCoupon()));
	        }

	        return orderDtos;
		}
	}

	@Override
	public Object OrderById(Long orderId, Long userId) throws OrderException {
		List<Orders> orders = oRepository.findByUserUserIdAndOrderId(userId, orderId);
		if(uRepository.existsById(userId) && oRepository.existsById(orderId)) {
			List<OrdersDto> orderDetails = new ArrayList<>();
            for (Orders order : orders) {
                orderDetails.add(new OrdersDto(order.getOrderId(), order.getAmount(), order.getDate(), order.getCoupon(), "Successfull"));
            }
            return orderDetails;	
		}
		else {
			 return new GetDetailsFailed(orderId, "Orders not found for user with ID: " + userId);
	    }	
		
	}
	
	private double calculateTotalPrice(int qty) {
        double productPrice = 100; 
        return qty * productPrice;
    }
	
	private double applyCoupon(double totalPrice, String couponCode) {
        if (couponCode != null) {
            if (Coupon.OFF10_CODE.equals(couponCode)) {
                double discount = (double) Coupon.OFF10_DISCOUNT_PERCENTAGE / 100;
                return totalPrice * (1 - discount);
            }
            else if(Coupon.OFF5_CODE.equals(couponCode)){
            	double discount = (double) Coupon.OFF5_DISCOUNT_PERCENTAGE / 100;
                return totalPrice * (1 - discount);
            }
        }
        return totalPrice;
    }

	
	private String generateTransactionId() {
		 Random random = new Random();
		    int transactionNumber = 1000 + random.nextInt(1000); 
		    return "tran" + transactionNumber;
	}
	
    public Orders created(Orders order) {
    	return oRepository.save(order);
    }
	
}
