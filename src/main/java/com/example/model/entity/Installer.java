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
@TableName("installers")
public class Installer {
    @TableId
    private Integer installerId;
    private Integer userId;
    private Integer roleId;
    private String fullName;
    private String contact;
    private String email;
    private String avatar;

}
