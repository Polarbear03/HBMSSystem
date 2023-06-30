package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.model.bean.JsonResponse;
import com.example.model.entity.Installer;
import com.example.model.entity.Product;
import com.example.model.entity.Task;
import com.example.service.inter.TaskService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@Slf4j(topic = "Task Operator")
public class TaskController {

    @Resource
    private TaskService taskService;

    @GetMapping("/listTask")
    @Transactional(readOnly = true)
    public JsonResponse<List<Task>> getAllTask(Task task) {
        QueryWrapper<Task> taskQueryWrapper = null;
        boolean flag = false;
        if (task != null) {
            taskQueryWrapper = new QueryWrapper<>(task);
            flag = true;
        }
        if (flag) {
            return JsonResponse.success(taskService.list(taskQueryWrapper));
        }
        return JsonResponse.success(taskService.list());
    }

    @RequestMapping (value = "/removeTask/{tskId}",method = RequestMethod.DELETE)
    public JsonResponse<String> removeTask(@PathVariable Integer tskId) {
        boolean removeSuccess = taskService.removeById(tskId);
        if (removeSuccess) {
            return JsonResponse.success("删除安装任务信息成功");
        }
        return JsonResponse.error("删除安装任务信息失败，请稍后重试");
    }

    @PostMapping("/saveTask")
    public JsonResponse<String> saveTask(Task task) {
        boolean saveSuccess = taskService.save(task);
        if (saveSuccess) {
            return JsonResponse.success("安装任务添加成功！");
        }
        return JsonResponse.error("安装任务添加失败，请稍后重试！");
    }

    @PostMapping("/updateTask")
    public JsonResponse<String> updateTask(Task task) {
        boolean updateSuccess = taskService.updateById(task);
        if (updateSuccess) {
            return JsonResponse.success("安装任务信息更新成功!");
        }
        return JsonResponse.error("安装任务信息更新失败，请稍后重试！");
    }

    @GetMapping("/getTskIds")
    @Transactional(readOnly = true)
    public JsonResponse<List<Task>> getProIds() {
        QueryWrapper<Task> tskQueryWrapper = new QueryWrapper<>();
        tskQueryWrapper.select("task_id");
        return JsonResponse.success(taskService.list(tskQueryWrapper));
    }
}
