package com.example.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.model.group.AddGroup;
import com.example.model.group.EditGroup;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("orders")
public class Order {
    @TableId
    @NotNull(message = "找不到该订单的信息，请确保你填写的订单编号存在", groups = {EditGroup.class})
    private Integer orderId;
    @NotNull(message = "没有找到该顾客的购买信息", groups = {EditGroup.class, AddGroup.class})
    @Min(value = 1, message = "顾客Id从1开始", groups = {EditGroup.class, AddGroup.class})
    private Integer customerId;
    @NotNull(message = "没有找到该商家信息", groups = {EditGroup.class, AddGroup.class})
    @Min(value = 1, message = "商家ID必须从1开始", groups = {EditGroup.class, AddGroup.class})
    private Integer merchantId;
    @NotNull(message = "没有找到该商品信息，商品可能已下架哦", groups = {EditGroup.class, AddGroup.class})
    @Min(value = 1, message = "商品id必须从1开始", groups = {EditGroup.class, AddGroup.class})
    private Integer productId;
    @Past(message = "日期出错，请正确填写下单日期", groups = {EditGroup.class, AddGroup.class})
    @NotNull(message = "日期出错，请正确填写下单日期", groups = {EditGroup.class, AddGroup.class})
    private Timestamp orderDate;
    @NotNull(message = "订单状态出错", groups = {EditGroup.class, AddGroup.class})
    private String orderStatus;
    @NotNull(message = "付款状态出错，请确保你已经付款", groups = {EditGroup.class, AddGroup.class})
    private String paymentStatus;
    @Min(value = 0, message = "价格出错", groups = {EditGroup.class, AddGroup.class})
    private Double totalAmount;
    @NotNull(message = "库存量不能为空", groups = {EditGroup.class, AddGroup.class})
    private Integer quantity;
    @NotNull(message = "请正确填写价格单位（元）", groups = {EditGroup.class, AddGroup.class})
    private Double unitPrice;
    @NotBlank(message = "请正确填写折扣", groups = {EditGroup.class, AddGroup.class})
    private String discount;
}
