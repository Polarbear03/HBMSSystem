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
@TableName("merchants")
public class Merchant {
    @TableId
    private Integer merchantId;
    private Integer userId;
    private Integer roleId;
    private String merchantName;
    private String contact;
    private String address;
    private String email;
    private String businessLicenseNumber;
    private Date registrationDate;
    private String introduction;
    private String avatar;
}
