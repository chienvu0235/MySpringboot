package com.spring.mvc.repository;

import com.spring.mvc.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProductsFromDB();
    Product getAllProductsByIdFromDB(int id);
    List<Product> addProductToDB(Product product);

}
