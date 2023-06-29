package com.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    private Integer reviewId;
    private Integer orderId;
    private Integer customerId;
    private String reviewContent;
    private Integer reting;
    private Date reviewDate;
}
