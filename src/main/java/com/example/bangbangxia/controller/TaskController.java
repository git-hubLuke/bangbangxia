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
    public RespPageBean queryTaskList(@RequestParam (defaultValue = "1")Integer page,@RequestParam (defaultValue = "10")Integer size,
                                      Integer user_id, Integer task_state){
        return taskService.queryTaskList(page,size,user_id,task_state);
    }


//    /**
//     * 查看自己发布的任务（1.未被接/2.正在进行中/3.已完成）/ 查看自己接受的任务（2.正在进行中/3.已完成）
//     * @param page
//     * @param size
//     * @param user_id
//     * @param accept_userId
//     * @param task_state
//     * @return
//     */
//    @GetMapping(value = "/queryMyTask")
//    public RespPageBean queryMyTask(@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "10")Integer size,
//                                    Integer user_id,Integer task_state,Integer accept_userId){
//        return taskService.queryMyTask(page,size,user_id,accept_userId,task_state);
//    }

}
