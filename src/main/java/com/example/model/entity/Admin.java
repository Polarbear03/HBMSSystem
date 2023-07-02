package com.example.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.model.group.AddGroup;
import com.example.model.group.EditGroup;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("admins")
public class Admin {
    @TableId
    @NotNull(message = "管理员ID不能为空",groups = {EditGroup.class})
    private Integer adminId;
    @NotNull(message = "没有该用户的Id",groups = {EditGroup.class, AddGroup.class})
    @Min(value = 1,message = "用户Id从1开始",groups = {EditGroup.class, AddGroup.class})
    private Integer userId;

    @NotBlank(message = "请正确填写该管理员的姓名",groups = {EditGroup.class,AddGroup.class})
    @Size(min = 1,max = 8,message = "用户姓名过长",groups = {EditGroup.class, AddGroup.class})
    private String fullName;

    @NotBlank(message = "联系方式不能位空",groups = {EditGroup.class,AddGroup.class})
    @Pattern(regexp = "^[1]+[3,8]+\\d{9}$",message = "请正确填写你的联系方式",groups = {EditGroup.class,AddGroup.class})
    @Length(min = 11,max = 11,message = "电话号码长度应是11位",groups = {EditGroup.class,AddGroup.class})
    private String contact;
    @NotBlank(message = "请填写邮箱地址",groups = {EditGroup.class,AddGroup.class})
    @Email(message = "邮箱格式错误",groups = {EditGroup.class,AddGroup.class})
    private String email;
    private String avatar;
}
