package com.example.model.entity;

import java.util.Date;

public class Order {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.OrderID
     *
     * @mbg.generated
     */
    private Integer orderid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.CustomerID
     *
     * @mbg.generated
     */
    private Integer customerid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.OrderDate
     *
     * @mbg.generated
     */
    private Date orderdate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.OrderStatus
     *
     * @mbg.generated
     */
    private String orderstatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.OrderID
     *
     * @return the value of orders.OrderID
     *
     * @mbg.generated
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.OrderID
     *
     * @param orderid the value for orders.OrderID
     *
     * @mbg.generated
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.CustomerID
     *
     * @return the value of orders.CustomerID
     *
     * @mbg.generated
     */
    public Integer getCustomerid() {
        return customerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.CustomerID
     *
     * @param customerid the value for orders.CustomerID
     *
     * @mbg.generated
     */
    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.OrderDate
     *
     * @return the value of orders.OrderDate
     *
     * @mbg.generated
     */
    public Date getOrderdate() {
        return orderdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.OrderDate
     *
     * @param orderdate the value for orders.OrderDate
     *
     * @mbg.generated
     */
    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.OrderStatus
     *
     * @return the value of orders.OrderStatus
     *
     * @mbg.generated
     */
    public String getOrderstatus() {
        return orderstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.OrderStatus
     *
     * @param orderstatus the value for orders.OrderStatus
     *
     * @mbg.generated
     */
    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus == null ? null : orderstatus.trim();
    }
}