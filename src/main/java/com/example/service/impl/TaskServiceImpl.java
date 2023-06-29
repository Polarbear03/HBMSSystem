package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.mapper.TaskMapper;
import com.example.model.entity.Task;
import com.example.service.inter.TaskService;

public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {
}
