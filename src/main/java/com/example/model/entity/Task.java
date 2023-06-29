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
@TableName("tasks")
public class Task {
    @TableId
    private Integer taskId;
    private Integer installerId;
    private Integer orderId;
    private String taskDescription;
    private String taskStatus;
    private Date createDate;
    private Date dueDate;
}
