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
public class ProductCategories {
    private Integer categoryId;
    private String categoryName;
    private Integer parentCategoryId;
    private String description;
    private Date createDate;
    private Date updateDate;
}
