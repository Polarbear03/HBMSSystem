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
public class Task {
    private Integer taskId;
    private Integer installerId;
    private Integer orderId;
    private String taskDescription;
    private String taskStatus;
    private Date createDate;
    private Date dueDate;
}
