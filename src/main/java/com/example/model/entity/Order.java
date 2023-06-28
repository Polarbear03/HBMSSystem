package com.example.model.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private Integer orderid;

    private Integer customerid;

    private Date orderdate;

    private String orderstatus;

}
