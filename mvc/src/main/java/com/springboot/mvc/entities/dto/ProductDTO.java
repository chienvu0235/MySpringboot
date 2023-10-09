package com.springboot.mvc.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {
    private int productId;
    private String productName;
    private int productAmount;
    private double productPrice;
    private int categoryId;
    private String categoryName;
}
