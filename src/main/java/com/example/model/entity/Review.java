package com.example.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.model.group.AddGroup;
import com.example.model.group.EditGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("reviews")
public class Review {
    @TableId
    @NotNull(message = "你给出评论id才能修改",groups = {EditGroup.class})
    private Integer reviewId;

    @NotNull(message = "你不给订单ID改个锤子",groups = {EditGroup.class, AddGroup.class})
    private Integer orderId;

    @NotNull(message = "不给顾客id改个锤子",groups = {EditGroup.class, AddGroup.class})
    private Integer customerId;

    @NotBlank(message = "你不写评论个锤子",groups = {EditGroup.class, AddGroup.class})
    private String reviewContent;

    @NotNull(message = "不给评分评个锤子",groups = {EditGroup.class, AddGroup.class})
    private Integer rating;

    private Timestamp reviewDate;
}
