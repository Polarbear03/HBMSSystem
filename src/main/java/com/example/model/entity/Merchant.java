package com.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Merchant {
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
