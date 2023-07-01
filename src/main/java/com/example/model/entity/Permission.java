package com.example.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("permissions")
public class Permission {
    @TableId
    private Integer permissionId;
    private String permissionName;
    private String permissionDescription;
    private Integer status;
    private Integer usable;
}
