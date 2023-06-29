package com.example.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("product")
public class Product {
    @TableId
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
