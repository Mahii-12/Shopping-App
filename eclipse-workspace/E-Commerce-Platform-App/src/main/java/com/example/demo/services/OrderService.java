package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepo;

@Service
public class OrderService {

	@Autowired
    private OrderRepo orderRepository;
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Cacheable(cacheNames = "orders", key="#id")
    public Order getOrderById(Long id) {
    	 logger.info("fetching order from db");
    	 Optional<Order> order = orderRepository.findById(id);
         if (order.isPresent()) {
             return order.get();
         } else {
             return new Order();
         }
    }
    
    @CachePut(cacheNames = "orders", key="#order.id")
    public Order saveOrder(Order order) {
    	logger.info("adding order with id - {}", order.getId());
        return orderRepository.save(order);
    }
    
    @CacheEvict(cacheNames = "orders", key = "#id")
    public String deleteOrder(Long id) {
        orderRepository.deleteById(id);
        return "Book deleted";
    }

	public Object findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
