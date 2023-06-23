package com.example.dao.mapper;

import com.example.model.entity.OrderDetail;
import com.example.model.entity.OrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetails
     *
     * @mbg.generated
     */
    long countByExample(OrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetails
     *
     * @mbg.generated
     */
    int deleteByExample(OrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetails
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer detailid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetails
     *
     * @mbg.generated
     */
    int insert(OrderDetail row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetails
     *
     * @mbg.generated
     */
    int insertSelective(OrderDetail row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetails
     *
     * @mbg.generated
     */
    List<OrderDetail> selectByExample(OrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetails
     *
     * @mbg.generated
     */
    OrderDetail selectByPrimaryKey(Integer detailid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetails
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("row") OrderDetail row, @Param("example") OrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetails
     *
     * @mbg.generated
     */
    int updateByExample(@Param("row") OrderDetail row, @Param("example") OrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetails
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(OrderDetail row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetails
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(OrderDetail row);
}