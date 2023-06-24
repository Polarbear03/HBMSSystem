package com.example.service.inter;

import com.example.model.entity.Admin;
import com.example.model.entity.AdminExample;

import java.util.List;

public interface AdminService {
    /**
     * 按条件统计
     * @param adminExample 内含条件
     * @return
     */
    long countByExample(AdminExample adminExample);

    /**
     * 按条件删除
     * @param adminExample
     * @return
     */
    int deleteByExample(AdminExample adminExample);

    /**
     * 按管理员ID删除
     * @param adminId
     * @return
     */
    int deleteByAdminId(Integer adminId);

    /**
     * 新增完整管理员信息
     * @param admin
     * @return
     */
    int insertAdmin(Admin admin);

    /**
     * 新增部分管理员信息
     * @param admin
     * @return
     */
    int insertAdminPart(Admin admin);

    /**
     * 按条件查询管理员信息
     * @param adminExample
     * @return
     */
    List<Admin> selectByExample(AdminExample adminExample);

    /**
     * 按管理员ID查询
     * @param adminId
     * @return
     */
    Admin selectByAdminId(Integer adminId);

    /**
     * 修改选中的一条记录
     * @param row
     * @param example
     * @return
     */
    int updateByExampleSelective(Admin row, AdminExample example);

    /**
     * 修改管理员多个信息
     * @param row
     * @param example
     * @return
     */
    int updateByExample(Admin row, AdminExample example);

    /**
     * 按管理员ID修改选中一行记录
     * @param admin
     * @return
     */
    int updateByAdminIdSelective(Admin admin);

    /**
     * 按主键修改管理员信息
     * @param admin
     * @return
     */
    int updateByAdminId(Admin admin);
}

