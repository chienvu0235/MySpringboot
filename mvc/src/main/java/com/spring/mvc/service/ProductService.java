package com.spring.mvc.service;

import com.spring.mvc.model.Product;
import com.spring.mvc.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/*
    - IOC Container thấy anotation này sẽ tạo bean có type ProductService
    - Anotation này đánh dấu class này sẽ xử lý nghiệp vu-business
 */
public class ProductService {

    // CONSTRUCTOR INJECTION start
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    // CONSTRUCTOR INJECTION end

    public List<Product> getProductFromRepo() {
        // Gọi repository để truy vấn data
        return productRepository.getAllProductsFromDB();
    }

    public Product getProductByIdFromRepo(int id) {
        // Gọi repository để truy vấn data
        Product product = null;
        try {
            product = productRepository.getProductsByIdFromDB(id);
        } catch (Exception e) {

        }
        return product;
    }

    public List<Product> addProduct(Product product) {

        return productRepository.addProductToDB(product);
    }
}
