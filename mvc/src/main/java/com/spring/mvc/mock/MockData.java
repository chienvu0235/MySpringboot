package com.spring.mvc.mock;

import com.spring.mvc.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MockData {
    public static List<Product> getProductsFromDataMock() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Áo Polo", 100_000));
        products.add(new Product("Áo Cadigan", 200_000));
        products.add(new Product("T-Shirt hoạ tiết", 150_000));
        products.add(new Product("Quần Jean cạp cao", 500_000));
        products.add(new Product("Áo Croptop", 300_000));

        return products;
    }
}
