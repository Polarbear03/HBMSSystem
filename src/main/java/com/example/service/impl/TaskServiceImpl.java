package com.example.service.impl;

import com.example.dao.mapper.TaskMapper;
import com.example.model.entity.Task;
import com.example.model.entity.TaskExample;
import com.example.service.inter.TaskService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {
    @Resource
    private TaskMapper taskMapper;
    @Override
    public long countByExample(TaskExample example) {
        return taskMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(TaskExample example) {
        return taskMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer taskId) {
        return taskMapper.deleteByPrimaryKey(taskId);
    }

    @Override
    public int insert(Task row) {
        return taskMapper.insert(row);
    }

    @Override
    public int insertSelective(Task row) {
        return taskMapper.insertSelective(row);
    }

    @Override
    public List<Task> selectByExampleWithBLOBs(TaskExample example) {
        return taskMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<Task> selectByExample(TaskExample example) {
        return taskMapper.selectByExample(example);
    }

    @Override
    public Task selectByPrimaryKey(Integer taskId) {
        return taskMapper.selectByPrimaryKey(taskId);
    }

    @Override
    public int updateByExampleSelective(Task row, TaskExample example) {
        return taskMapper.updateByExampleSelective(row,example);
    }

    @Override
    public int updateByExampleWithBLOBs(Task row, TaskExample example) {
        return taskMapper.updateByExampleWithBLOBs(row,example);
    }

    @Override
    public int updateByExample(Task row, TaskExample example) {
        return taskMapper.updateByExample(row,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Task row) {
        return taskMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Task row) {
        return taskMapper.updateByPrimaryKeyWithBLOBs(row);
    }

    @Override
    public int updateByPrimaryKey(Task row) {
        return taskMapper.updateByPrimaryKey(row);
    }
}
