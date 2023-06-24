package com.example.service.inter;

import com.example.model.entity.Task;
import com.example.model.entity.TaskExample;

import java.util.List;

public interface TaskService {
    long countByExample(TaskExample example);

    int deleteByExample(TaskExample example);

    int deleteByPrimaryKey(Integer taskId);

    int insert(Task row);

    int insertSelective(Task row);

    List<Task> selectByExampleWithBLOBs(TaskExample example);

    List<Task> selectByExample(TaskExample example);

    Task selectByPrimaryKey(Integer taskId);

    int updateByExampleSelective( Task row, TaskExample example);

    int updateByExampleWithBLOBs(Task row, TaskExample example);

    int updateByExample(Task row, TaskExample example);

    int updateByPrimaryKeySelective(Task row);

    int updateByPrimaryKeyWithBLOBs(Task row);

    int updateByPrimaryKey(Task row);
}
