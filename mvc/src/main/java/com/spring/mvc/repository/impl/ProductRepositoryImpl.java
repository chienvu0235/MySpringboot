package com.spring.mvc.repository.impl;

import com.spring.mvc.mock.MockData;
import com.spring.mvc.model.Product;
import com.spring.mvc.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/*
    - IOC Container thấy anotation này sẽ tạo bean có type ProductRepository
    - Anotation này đánh dấu class này sẽ xử lý tác vụ với database
 */
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> getAllProductsFromDB() {
        // Tương tác database để lấy dữ liệu
        return MockData.getProductsFromDataMock();
    }

    @Override
    public Product getProductsByIdFromDB(int id) {
        // Tương tác database để lấy dữ liệu
        return MockData.getProductsFromDataMock().get(id);
    }

    @Override
    public List<Product> addProductToDB(Product product) {
        List<Product> newList = MockData.getProductsFromDataMock();
        newList.add(product);
        return newList;
    }
}
