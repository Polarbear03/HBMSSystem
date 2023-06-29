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
public class Order {
    private Integer orderId;
    private Integer customerId;
    private Integer merchantId;
    private Integer productId;
    private Date orderDate;
    private String orderStatus;
    private String paymentStatus;
    private Double totalAmount;
    private Integer quantity;
    private Double unitPrice;
    private String discount;
}
