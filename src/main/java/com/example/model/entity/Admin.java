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
@TableName("admins")
public class Admin {
    @TableId
    private Integer adminId;
    private Integer userId;
    private Integer roleId;
    private String fullName;
    private String contact;
    private String email;
    private String avatar;
}
