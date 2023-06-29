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
public class Customer {
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
