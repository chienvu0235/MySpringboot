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
        return "index";
    }

    @GetMapping("/test")
    public String test(Model model) {
        return "ManagerClass";
    }

    @GetMapping("/fashion")
    public String fashion(Model model) {
        return "fashion";
    }

    @GetMapping("/electronic")
    public String electronic(Model model) {
        return "electronic";
    }

    @GetMapping("/jewellery")
    public String jewellery(Model model) {
        return "jewellery";
    }
}
