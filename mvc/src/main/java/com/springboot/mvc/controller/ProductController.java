package com.springboot.mvc.controller;

import com.springboot.mvc.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    @GetMapping("/index")
    public String index(Model model) {
        // Gọi service xử lý gì đó
        List<Product> products = List.of(
                new Product("Áo thun", 100000),
                new Product("Áo Gió", 500000),
                new Product("Áo Khoác", 200000)
        );
        model.addAttribute("content", products);
        return "index"; // Tên file html
    }

    @GetMapping("/404")
    public String test(Model model) {
        return "404";
    }

    @GetMapping("/blog")
    public String blog(Model model) {
        return "blog";
    }

    @GetMapping("/blog/single")
    public String blogSingle(Model model) {
        return "blog-single";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        return "cart";
    }
    @GetMapping("/checkout")
    public String checkOut(Model model) {
        return "checkout";
    }
    @GetMapping("/contact")
    public String contact(Model model) {
        return "contact-us";
    }
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    @GetMapping("/product/details")
    public String productDetail(Model model) {
        return "product-details";
    }
    @GetMapping("/shop")
    public String shop(Model model) {
        return "shop";
    }
}
