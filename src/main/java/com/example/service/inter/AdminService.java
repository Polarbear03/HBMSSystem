package com.example.service.inter;

import com.example.model.entity.Admin;
import com.example.model.entity.AdminExample;

import java.util.List;

public interface AdminService {
    /**
     * 按某个条件进行统计
     * @param example
     * @return
     */
    long count(AdminExample example);

    /**
     * 按某个条件进行删除
     * @param example
     * @return
     */
    int deleteByExample(AdminExample example);

    /**
     * 按管理员ID删除
     * @param adminId
     * @return
     */
    int deleteByID(Integer adminId);

    /**
     * 插入管理员数据
     * @param admin
     * @return
     */
    int insert(Admin admin);

    /**
     * 插入一些数据，这些数据有的可以为空
     * @param admin
     * @return
     */
    int insertSelective(Admin admin);

    /**
     * 按条件查询数据
     * @param adminExample
     * @return
     */
    List<Admin> selectByExample(AdminExample adminExample);

    /**
     * 按主键查询数据
     * @param adminId
     * @return
     */
    Admin selectByAdminId(Integer adminId);
}
