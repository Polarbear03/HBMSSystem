package com.example.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.model.group.AddGroup;
import com.example.model.group.EditGroup;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("product")
public class Product {
    @TableId
    @NotNull(message = "没有找到该商品信息，商品可能已下架哦",groups = {EditGroup.class})
    @Min(value = 1,message = "商品id必须从1开始",groups = {EditGroup.class})
    private Integer productId;

    @NotNull(message = "没有找到该商家信息",groups = {EditGroup.class, AddGroup.class})
    @Min(value = 1,message = "商家ID必须从1开始",groups = {EditGroup.class, AddGroup.class})
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
