package com.spring.mvc.controller;

import com.spring.mvc.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class controller {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("content", "Heloo AE");
        return "index";
    }

    @GetMapping("/product")
    public String getProduct(Model model) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Áo cộc", 100000));
        products.add(new Product("Áo polo", 1200000));
        products.add(new Product("Áo sơ mi", 5100000));
        products.add(new Product("Áo T", 2100000));
// service.getProduct();
        model.addAttribute("productsList", products);
        return "index";
    }
}
