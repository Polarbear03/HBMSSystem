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

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("merchants")
public class Merchant {
    @TableId
    @NotNull(message = "管理员ID不能为空",groups = {EditGroup.class})
    private Integer merchantId;

    @NotNull(message = "没有该用户的Id",groups = {EditGroup.class, AddGroup.class})
    @Min(value = 1,message = "用户Id从1开始",groups = {EditGroup.class, AddGroup.class})
    private Integer userId;

    @NotNull(message = "权限未分配，请确保你已经注册系统",groups = {EditGroup.class, AddGroup.class})
    @Min(value = 1,message = "用户Id从1开始",groups = {EditGroup.class, AddGroup.class})
    private Integer roleId;

    @NotBlank(message = "请正确填写店铺名",groups = {EditGroup.class, AddGroup.class})
    private String merchantName;

    @NotBlank(message = "联系方式不能位空",groups = {EditGroup.class,AddGroup.class})
    @Pattern(regexp = "^[1]+[3,8]+\\d{9}$",message = "请正确填写你的联系方式",groups = {EditGroup.class,AddGroup.class})
    @Length(min = 11,max = 11,message = "电话号码长度应是11位",groups = {EditGroup.class,AddGroup.class})
    private String contact;

    @NotBlank(message = "请正确填写你的地址",groups = {EditGroup.class, AddGroup.class})
    private String address;

    @NotBlank(message = "请填写邮箱地址",groups = {EditGroup.class,AddGroup.class})
    @Email(message = "邮箱格式错误",groups = {EditGroup.class,AddGroup.class})
    private String email;
    @NotNull(message = "请正确填写营业执照编号",groups = {EditGroup.class, AddGroup.class})
    private String businessLicenseNumber;
    @Past(message = "日期出错，请正确填写注册日期",groups = {EditGroup.class, AddGroup.class})
    @NotNull(message = "日期出错，请正确填写注册日期",groups = {EditGroup.class, AddGroup.class})
    private Date registrationDate;

    @NotNull(message = "给店铺一点介绍才能吸引更多的顾客哦",groups = {EditGroup.class,AddGroup.class})
    private String introduction;
    private String avatar;
}
