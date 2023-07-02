package com.example.model.dto;

import com.example.model.entity.Customer;
import com.example.model.entity.Merchant;
import com.example.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderInfo {
    private Integer orderId;
    private String customer;
    private String merchant;
    private String product;
    private Timestamp orderDate;
    private String orderStatus;
    private String paymentStatus;
    private Double totalAmount;
    private Integer quantity;
    private Double unitPrice;
    private String discount;
}
