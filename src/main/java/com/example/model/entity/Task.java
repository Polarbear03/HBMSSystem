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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("tasks")
public class Task {
    @TableId
    @NotNull(message = "不给任务id改个锤子",groups = {EditGroup.class})
    private Integer taskId;
    @NotNull(message = "不给安装员任务分配个锤子",groups = {EditGroup.class, AddGroup.class})
    private Integer installerId;
    @NotNull(message = "不给订单分配个锤子",groups = {EditGroup.class, AddGroup.class})
    private Integer orderId;
    @NotBlank(message = "不给任务描述分配个锤子",groups = {EditGroup.class, AddGroup.class})
    private String taskDescription;
    @NotBlank(message = "任务状态不知道安装个锤子",groups = {EditGroup.class, AddGroup.class})
    private String taskStatus;
    private Timestamp createDate;
    private Timestamp dueDate;
}
