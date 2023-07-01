package com.example.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("users")
public class User implements Serializable {
    @TableId
    private Integer userId;
    private String username;
    private String password;
    private Integer roleId;
    private String fullName;
    private String contact;
    private String address;
    private String email;
    private String gender;
    private Timestamp dateOfBirth;
    private Timestamp registrationDate;
    private String avatar;
    private Integer enable;
    private Integer accountNoExpired;
    private Integer credentialsNoExpired;
    private Integer accountNoLocked;
}
