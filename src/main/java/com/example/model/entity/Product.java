package com.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Integer productId;
    private Integer merchantId;
    private Integer categoryId;
    private String productName;
    private String description;
    private Double price;
    private Integer stock;
    private Date createDate;
    private Date updateDate;
    private String image;
}
