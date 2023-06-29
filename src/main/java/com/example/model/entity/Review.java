package com.example.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("reviews")
public class Review {
    @TableId
    private Integer reviewId;
    private Integer orderId;
    private Integer customerId;
    private String reviewContent;
    private Integer reting;
    private Date reviewDate;
}
