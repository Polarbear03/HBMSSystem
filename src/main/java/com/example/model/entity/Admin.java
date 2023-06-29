package com.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {
    private Integer adminId;
    private Integer userId;
    private Integer roleId;
    private String fullName;
    private String contact;
    private String email;
    private String avatar;
}
