package com.spring.mvc.controller;

import com.spring.mvc.mock.MockData;
import com.spring.mvc.model.Product;
import com.spring.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    /*
        - Inject bean ProductRepositoryImpl co trong IOC container
        - Đây là Field injection
        - Ví dụ về Contructor injection ở class ProductService
     */
    private ProductService productService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("content", "Heloo AE");
        return "index";
    }

    @GetMapping("/product")
    // GET Request method để truy vấn dữ liệu
    public String getProduct(Model model) {
        List<Product> products = productService.getProductFromRepo();
        model.addAttribute("productsList", products);
        return "addProduct";
    }

    @PostMapping("/product")
    // POST Request method để thêm mới dữ liêu
    public String addProduct(@ModelAttribute Product product, Model model) {
        model.addAttribute("productsList", productService.addProduct(product));
        return "index";
    }


}
