package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Order;
import com.example.demo.services.OrderService;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserService;

@Controller
public class OrderController {
	@Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;
    
    
    
    /**
	 * @param orderService
	 * @param productService
	 * @param userService
	 */
	public OrderController(OrderService orderService, ProductService productService, UserService userService) {
		super();
		this.orderService = orderService;
		this.productService = productService;
		this.userService = userService;
	}

	@GetMapping("/api/orders")
    public String showOrders(Model model) {
    	 model.addAttribute("TheOrder", orderService.findAll());
        return "redirect:/";
    }
    
    @GetMapping("/seeorders")
    @ResponseBody
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/getOrder/{id}")
    @ResponseBody
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/placeOrder")
    @ResponseBody
    public Order saveOrder(@RequestBody Order order) {
        // Assuming order includes product and user details in the request
        order.setProduct(productService.getProductById(order.getProduct().getId()));
        order.setUser(userService.getUserById(order.getUser().getId()));
        return orderService.saveOrder(order);
    }

    @DeleteMapping("/deleteOrder/{id}")
    @ResponseBody
    public String deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
}
