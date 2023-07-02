package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.model.bean.JsonResponse;
import com.example.model.entity.Installer;
import com.example.model.entity.Product;
import com.example.model.entity.Task;
import com.example.service.inter.TaskService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('/task/**','task:query')")
    @Transactional(readOnly = true)
    public JsonResponse<Page<Task>> getAllTask(@RequestParam(value = "taskId", required = false) Integer taskId,
                                               @RequestParam(value = "taskDescription", required = false) String taskDescription,
                                               @RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                               @RequestParam(value = "pageSize",defaultValue = "10") int pageSize) {
        QueryWrapper<Task> taskQueryWrapper = new QueryWrapper<>();
        boolean flag = false;
        if (taskId != null) {
            taskQueryWrapper.eq("task_id", taskId);
        }
        if (taskDescription != null && !taskDescription.isEmpty()) {
            taskQueryWrapper.like("task_description", taskDescription);
        }
        Page<Task> page = new Page<>(pageNo,pageSize);
        if (flag) {
            taskService.page(page,taskQueryWrapper);
            return JsonResponse.success(page);
        }
        taskService.page(page);
        return JsonResponse.success(page);
    }

    @RequestMapping(value = "/removeTask/{tskId}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyAuthority('/task/**','task:delete')")
    public JsonResponse<String> removeTask(@PathVariable Integer tskId) {
        boolean removeSuccess = taskService.removeById(tskId);
        if (removeSuccess) {
            return JsonResponse.success("删除安装任务信息成功");
        }
        return JsonResponse.error("删除安装任务信息失败，请稍后重试");
    }

    @PostMapping("/saveTask")
    @PreAuthorize("hasAnyAuthority('/task/**','task:add')")
    public JsonResponse<String> saveTask(Task task) {
        boolean saveSuccess = taskService.save(task);
        if (saveSuccess) {
            return JsonResponse.success("安装任务添加成功！");
        }
        return JsonResponse.error("安装任务添加失败，请稍后重试！");
    }

    @PostMapping("/updateTask")
    @PreAuthorize("hasAnyAuthority('/task/**','task:update')")
    public JsonResponse<String> updateTask(Task task) {
        boolean updateSuccess = taskService.updateById(task);
        if (updateSuccess) {
            return JsonResponse.success("安装任务信息更新成功!");
        }
        return JsonResponse.error("安装任务信息更新失败，请稍后重试！");
    }

    @GetMapping("/getTskIds")
    @PreAuthorize("hasAnyAuthority('/task/**','task:query')")
    @Transactional(readOnly = true)
    public JsonResponse<List<Task>> getProIds() {
        QueryWrapper<Task> tskQueryWrapper = new QueryWrapper<>();
        tskQueryWrapper.select("task_id");
        return JsonResponse.success(taskService.list(tskQueryWrapper));
    }
}
