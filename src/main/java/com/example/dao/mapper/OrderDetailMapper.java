package com.example.dao.mapper;

import com.example.model.entity.OrderDetail;
import com.example.model.entity.OrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailMapper {
    long countByExample(OrderDetailExample example);

    int deleteByExample(OrderDetailExample example);

    int deleteByPrimaryKey(Integer orderDetailId);

    int insert(OrderDetail row);

    int insertSelective(OrderDetail row);

    List<OrderDetail> selectByExample(OrderDetailExample example);

    OrderDetail selectByPrimaryKey(Integer orderDetailId);

    int updateByExampleSelective(@Param("row") OrderDetail row, @Param("example") OrderDetailExample example);

    int updateByExample(@Param("row") OrderDetail row, @Param("example") OrderDetailExample example);

    int updateByPrimaryKeySelective(OrderDetail row);

    int updateByPrimaryKey(OrderDetail row);
}