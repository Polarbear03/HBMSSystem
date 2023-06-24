package com.example.dao.mapper;

import com.example.model.entity.Task;
import com.example.model.entity.TaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskMapper {
    long countByExample(TaskExample example);

    int deleteByExample(TaskExample example);

    int deleteByPrimaryKey(Integer taskId);

    int insert(Task row);

    int insertSelective(Task row);

    List<Task> selectByExampleWithBLOBs(TaskExample example);

    List<Task> selectByExample(TaskExample example);

    Task selectByPrimaryKey(Integer taskId);

    int updateByExampleSelective(@Param("row") Task row, @Param("example") TaskExample example);

    int updateByExampleWithBLOBs(@Param("row") Task row, @Param("example") TaskExample example);

    int updateByExample(@Param("row") Task row, @Param("example") TaskExample example);

    int updateByPrimaryKeySelective(Task row);

    int updateByPrimaryKeyWithBLOBs(Task row);

    int updateByPrimaryKey(Task row);
}