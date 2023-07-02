package com.example.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.model.group.AddGroup;
import com.example.model.group.EditGroup;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
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

    @NotNull(message = "商品还没分类啊，你干嘛~",groups = {EditGroup.class, AddGroup.class})
    private Integer categoryId;

    @NotBlank(message = "商品名字呢？不加名字你卖个锤子",groups = {EditGroup.class, AddGroup.class})
    private String productName;
    @NotBlank(message = "商品描述呢？不加描述你卖个锤子",groups = {EditGroup.class, AddGroup.class})
    private String description;
    @NotNull(message = "白给小王子",groups = {EditGroup.class, AddGroup.class})
    @Min(value = 0,message = "大甩卖",groups = {EditGroup.class, AddGroup.class})
    private Double price;

    @NotNull(message = "没东西卖吗？",groups = {EditGroup.class, AddGroup.class})
    @Min(value = 0,message = "没货了",groups = {EditGroup.class, AddGroup.class})
    private Integer stock;
    private Timestamp createDate;
    private Timestamp updateDate;
    private String image;
}
