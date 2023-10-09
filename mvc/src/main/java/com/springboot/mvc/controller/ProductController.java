package com.springboot.mvc.controller;

import com.springboot.mvc.entities.dao.Product;
import com.springboot.mvc.entities.dto.ProductDTO;
import com.springboot.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/search")
    public List<ProductDTO> getProducts2(@RequestParam int id) {
        String sql = "Select" +
                        " p.id AS productId," +
                        " p.name AS productName," +
                        " p.amount AS productAmount," +
                        " p.price AS productPrice," +
                        " c.id AS categoryId," +
                        " c.name AS categoryName " +
                    "FROM" +
                        " product p LEFT OUTER JOIN category c on p.category_id = c.id "
                    + "WHERE p.id = :productId"
                ;
        MapSqlParameterSource nameParameters = new MapSqlParameterSource()
                .addValue("productId", id);
        return namedParameterJdbcTemplate.query(sql,nameParameters, new BeanPropertyRowMapper<>(ProductDTO.class));
    }

    @GetMapping("/searchlist")
    public List<Product> getProducts3() {
        String sql = "Select * FROM product";
        return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }
    @PostMapping("/add")
    public int addProducts(@RequestBody Product product) {
        String sql = "INSERT INTO product (name, price, amount, category_id) VALUES (:name, :price, :amount, :category_id)";
        MapSqlParameterSource nameParameters = new MapSqlParameterSource()
                .addValue("name", product.getName())
                .addValue("price", product.getPrice())
                .addValue("amount", product.getAmount())
                .addValue("category_id", product.getCategoryId());
        return namedParameterJdbcTemplate.update(sql, nameParameters);
    }


    @GetMapping("/index")
    public String index(Model model) {
        // Gọi service xử lý gì đó
//        List<Product> products = List.of(
//                new Product("Áo thun", 100000),
//                new Product("Áo Gió", 500000),
//                new Product("Áo Khoác", 200000)
//        );
//        model.addAttribute("content", products);
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
