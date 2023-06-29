package com.example.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("customers")
public class Customer {
    @TableId
    private Integer customerId;
    private Integer userId;
    private Integer roleId;
    private String fullName;
    private String contact;
    private String address;
    private String email;
    private String gender;
    private Date dateOfBirth;
    private Date registrationDate;
    private String avatar;

}
