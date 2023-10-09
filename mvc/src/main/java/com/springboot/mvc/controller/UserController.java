package com.springboot.mvc.controller;

import com.springboot.mvc.entities.dao.User;
import com.springboot.mvc.entities.dto.ProductMapperDTO;
import com.springboot.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @GetMapping("/user")
    public User getUsers(){
        return userRepository.findByName("chen");
    }

    @GetMapping("/user/id")
    public Optional<User> getUserById(@RequestParam int id){
        return userRepository.findById(id);
    }

    @GetMapping("/user/jdbc")
    public List<User> getAllUsers(){
        String sql = "SELECT * FROM users";
        return namedParameterJdbcTemplate
                .query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @GetMapping("/product/jdbc")
    public List<ProductMapperDTO> getAllProducts(@RequestParam String name){
        String sql =
                "SELECT " +
                    "p.id AS productId, " +
                    "p.name AS productName, " +
                    "p.amount AS productAmount, " +
                    "p.price, " +
                    "p.category_id, " +
                    "c.id AS categoryId, " +
                    "c.name AS categoryName " +
                "FROM " +
                    "product p LEFT OUTER JOIN category c " +
                    "ON p.category_id = c.id " +
                "WHERE p.name = :name";
        MapSqlParameterSource pramMap = new MapSqlParameterSource()
                .addValue("name", name);
        return namedParameterJdbcTemplate
                .query(sql, pramMap, new BeanPropertyRowMapper<>(ProductMapperDTO.class));
    }
}
