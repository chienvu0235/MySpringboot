package com.springboot.mvc.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductMapperDTO {
    private int productId;
    private String productName;
    private int productAmount;
    private double price;
    private int categoryId;
    private String categoryName;
    private int category_id;
}
