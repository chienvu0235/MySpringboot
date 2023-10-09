package com.springboot.mvc.controller;

import com.springboot.mvc.entities.dao.Product;
import com.springboot.mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
