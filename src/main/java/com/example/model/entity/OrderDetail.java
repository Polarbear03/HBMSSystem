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
public class OrderDetail {
    private Integer orderDetailId;

    private Integer orderId;

    private Integer productId;

    private Integer quantity;

    private BigDecimal unitPrice;

    private BigDecimal discount;

}
