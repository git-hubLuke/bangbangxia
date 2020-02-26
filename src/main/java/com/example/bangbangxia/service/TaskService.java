package com.example.bangbangxia.service;

import com.example.bangbangxia.domain.RespPageBean;
import com.example.bangbangxia.domain.Task;

import java.util.Map;

/**
 * 任务的业务层接口
 */
public interface TaskService {

    //添加任务
    int insertTask(Task task);

    //删除任务
    int deleteTask(Integer task_id);

    //更新任务
    int updateTask(Task task);

    //接受任务
    int updateTaskByID(Task task);

    //查询所有任务
    RespPageBean queryTaskList(Integer page, Integer size,Integer user_id,Integer task_state);

//    //查看自己发布的或接受的任务
//    RespPageBean queryMyTask(Integer page, Integer size, Integer user_id,Integer accept_userId, Integer task_state);

}
