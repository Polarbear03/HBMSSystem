package com.example.dao.mapper;

import com.example.model.entity.Review;
import com.example.model.entity.ReviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReviewMapper {
    long countByExample(ReviewExample example);

    int deleteByExample(ReviewExample example);

    int deleteByPrimaryKey(Integer reviewid);

    int insert(Review row);

    int insertSelective(Review row);

    List<Review> selectByExample(ReviewExample example);

    Review selectByPrimaryKey(Integer reviewid);

    int updateByExampleSelective(@Param("row") Review row, @Param("example") ReviewExample example);

    int updateByExample(@Param("row") Review row, @Param("example") ReviewExample example);

    int updateByPrimaryKeySelective(Review row);

    int updateByPrimaryKey(Review row);
}