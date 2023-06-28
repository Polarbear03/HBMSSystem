package com.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    private Integer taskId;

    private Integer installerId;

    private Integer orderId;

    private String taskStatus;

    private Date createDate;

    private Date dueDate;

    private String taskDescription;

}
