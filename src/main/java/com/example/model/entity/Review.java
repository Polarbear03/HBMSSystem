package com.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
    private Integer reviewid;

    private Integer orderid;

    private String reviewcontent;

    private Integer reviewrating;

}
