package com.example.service.inter;

import com.example.model.entity.Review;
import com.example.model.entity.ReviewExample;

import java.util.List;

public interface ReviewService {
    long countByExample(ReviewExample example);

    int deleteByExample(ReviewExample example);

    int deleteByPrimaryKey(Integer reviewid);

    int insert(Review row);

    int insertSelective(Review row);

    List<Review> selectByExample(ReviewExample example);

    Review selectByPrimaryKey(Integer reviewid);

    int updateByExampleSelective( Review row,  ReviewExample example);

    int updateByExample( Review row, ReviewExample example);

    int updateByPrimaryKeySelective(Review row);

    int updateByPrimaryKey(Review row);
}
