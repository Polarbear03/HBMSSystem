package com.example.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.model.group.EditGroup;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("product_categories")
public class ProductCategories {
    @TableId
    @NotNull(message = "商品分类错误",groups = {EditGroup.class})
    private Integer categoryId;
    private String categoryName;
    private Integer parentCategoryId;
    private String description;
    private Date createDate;
    private Date updateDate;
}
