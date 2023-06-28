package com.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Integer productid;

    private String productname;

    private Integer merchantid;

    private BigDecimal price;

    private Integer stockquantity;

}
