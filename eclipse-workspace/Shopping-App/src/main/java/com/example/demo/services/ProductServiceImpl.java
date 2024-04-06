package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.OrderException;
import com.example.demo.exceptions.ProductException;
import com.example.demo.model.Orders;
import com.example.demo.model.Product;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository pRepository;
	
	@Autowired
	private OrderRepository oRepository;

	@Override
	public Product cProduct(Product product) throws ProductException{
		Product nProduct=new Product();
		if(product != null) {
			nProduct.setProductId(product.getProductId());
			nProduct.setAvailableQuantities(product.getAvailableQuantities());
			nProduct.setProductName(product.getProductName());
			nProduct.setProductPrice(product.getProductPrice());
			
			pRepository.save(nProduct);
			return nProduct;
		}
		else {
			throw new ProductException("Product is Empty!");
		}
	}

	@Override
	public List<Product> allProducts() {
		return pRepository.findAll();
	}

	@Override
	public Product gProductById(Long productId) throws ProductException{
		if(pRepository.existsById(productId)) {
			return pRepository.findById(productId).get();
		}
		else {
			throw new ProductException("Product is Empty!");
		}
	}

	@Override
	public List<Product> gProductByOrderid(Long orderId) throws OrderException{
		Optional<Orders> orderOptional = oRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Orders order = orderOptional.get();
            List<Product> products = order.getProducts();
            return products;
        } else {
            throw new OrderException("Order with orderId " + orderId);
        }
	}
	
	
}
