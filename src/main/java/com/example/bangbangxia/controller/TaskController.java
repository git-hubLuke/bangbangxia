package com.example.bangbangxia.controller;

import com.example.bangbangxia.domain.RespBean;
import com.example.bangbangxia.domain.RespPageBean;
import com.example.bangbangxia.domain.Task;
import com.example.bangbangxia.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 任务的控制类
 */
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * 添加任务
     * @param task
     * @return
     */
    @PostMapping(value = "/insertTask")
    public RespBean insertTask(@RequestBody Task task){
        if (taskService.insertTask(task)==1){
            return RespBean.ok("添加任务成功");
        }
        return  RespBean.error("添加任务失败");
    }

    /**
     * 删除任务
     * @param task_id
     * @return
     */
    @DeleteMapping(value = "/deleteTask")
    public RespBean deleteTask(Integer task_id){
        if (taskService.deleteTask(task_id)==1){
            return RespBean.ok("删除任务成功");
        }
        return RespBean.error("删除任务失败");
    }

    /**
     * 更新任务
     * @param task
     * @return
     */
    @PostMapping(value = "updateTask")
    public RespBean updateTask(@RequestBody Task task){
        if (taskService.updateTask(task)==1){
            return RespBean.ok("更新任务成功");
        }
        return RespBean.error("更新任务失败");
    }

    /**
     * 接受任务
     * @param task
     * @return
     */
    @PostMapping(value = "/updateTaskByID")
    public RespBean updateTaskByID(@RequestBody Task task){
        if (taskService.updateTaskByID(task)==1){
            return RespBean.ok("接受任务成功");
        }
        return RespBean.error("接受任务失败");
    }

    /**
     * 查询所有任务
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/queryTaskList")
    public RespPageBean queryTaskList(@RequestParam (defaultValue = "1")Integer page,@RequestParam (defaultValue = "10")Integer size,Integer task_id){
        return taskService.queryTaskList(page,size,task_id);
    }

    /**
     * 查看自己发布的进行中的任务
     * @param page
     * @param size
     * @param user_id
     * @return
     */
    @GetMapping(value = "/queryMyTaskProcess")
    public RespPageBean queryMyTaskProcess(@RequestParam Map<String,Object> map){
        return taskService.queryMyTaskProcess(map);
    }

}
