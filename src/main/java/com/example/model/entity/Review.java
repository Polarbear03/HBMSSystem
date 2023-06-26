package com.example.model.entity;

import org.springframework.stereotype.Component;


public class Review {
    private Integer reviewid;

    private Integer orderid;

    private String reviewcontent;

    private Integer reviewrating;

    public Integer getReviewid() {
        return reviewid;
    }

    public void setReviewid(Integer reviewid) {
        this.reviewid = reviewid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getReviewcontent() {
        return reviewcontent;
    }

    public void setReviewcontent(String reviewcontent) {
        this.reviewcontent = reviewcontent == null ? null : reviewcontent.trim();
    }

    public Integer getReviewrating() {
        return reviewrating;
    }

    public void setReviewrating(Integer reviewrating) {
        this.reviewrating = reviewrating;
    }
}
