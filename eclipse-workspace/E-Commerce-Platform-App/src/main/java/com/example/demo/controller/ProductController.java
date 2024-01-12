package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Product;
import com.example.demo.services.ProductService;

@Controller
//@RequestMapping("/products")
public class ProductController {
   
	@Autowired
    private ProductService productService;

        

    /**
	 * @param productService
	 */
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/products")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/getProduct/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable Long id) {
        return (Product) productService.getProductById(id);
    }

    @PostMapping("/newProduct")
    @ResponseBody
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    @ResponseBody
    public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
	
}
