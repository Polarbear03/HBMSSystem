package com.example.service.impl;

import com.example.dao.mapper.ReviewMapper;
import com.example.model.entity.Review;
import com.example.model.entity.ReviewExample;
import com.example.service.inter.ReviewService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReviewServiceImpl implements ReviewService {
    @Resource
    private ReviewMapper reviewMapper;
    @Override
    public long countByExample(ReviewExample example) {
        return reviewMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ReviewExample example) {
        return reviewMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer reviewid) {
        return reviewMapper.deleteByPrimaryKey(reviewid);
    }

    @Override
    public int insert(Review row) {
        return reviewMapper.insert(row);
    }

    @Override
    public int insertSelective(Review row) {
        return reviewMapper.insertSelective(row);
    }

    @Override
    public List<Review> selectByExample(ReviewExample example) {
        return reviewMapper.selectByExample(example);
    }

    @Override
    public Review selectByPrimaryKey(Integer reviewid) {
        return reviewMapper.selectByPrimaryKey(reviewid);
    }

    @Override
    public int updateByExampleSelective(Review row, ReviewExample example) {
        return reviewMapper.updateByExampleSelective(row,example);
    }

    @Override
    public int updateByExample(Review row, ReviewExample example) {
        return reviewMapper.updateByExample(row,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Review row) {
        return reviewMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(Review row) {
        return reviewMapper.updateByPrimaryKey(row);
    }
}
