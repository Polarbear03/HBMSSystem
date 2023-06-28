package com.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCategories {
    private Integer categoryId;

    private String categoryName;

    private Integer parentCategoryId;

    private Date createDate;

    private Date updateDate;

    private String description;


}
