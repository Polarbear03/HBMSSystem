package com.example.model.entity;


import com.example.model.group.AddGroup;
import com.example.model.group.EditGroup;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.query.Param;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {
    private Integer adminId;

    private Integer userId;

    private Integer roleId;

    //@NotNull(message = "管理员姓名不能为空",
    //        groups = {AddGroup.class, EditGroup.class})
    private String fullName;

    //@NotBlank(message = "管理员必须要有联系方式",
    //            groups = {AddGroup.class, EditGroup.class})
    //@Pattern(regexp = "^[1]+[3,8]+\\d{9}$")
    private String contact;

    //@Email(message = "邮箱格式不符合规则",
    //        groups = {AddGroup.class, EditGroup.class})
    private String email;

    private String avatar;
}
