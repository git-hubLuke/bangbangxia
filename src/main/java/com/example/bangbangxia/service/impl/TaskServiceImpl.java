package com.example.bangbangxia.service.impl;

import com.example.bangbangxia.dao.TaskMapper;
import com.example.bangbangxia.domain.RespPageBean;
import com.example.bangbangxia.domain.Task;
import com.example.bangbangxia.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 任务的业务层实现类
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    /**
     * 添加任务
     * @param task
     * @return
     */
    @Override
    public int insertTask(Task task) {
        return taskMapper.insertTask(task);
    }

    /**
     * 删除任务
     * @param task_id
     * @return
     */
    @Override
    public int deleteTask(Integer task_id) {
        return taskMapper.deleteTask(task_id);
    }

    /**
     * 更新任务
     * @param task
     * @return
     */
    @Override
    public int updateTask(Task task) {
        return taskMapper.updateTask(task);
    }

    /**
     * 接受任务
     * @param task
     * @return
     */
    @Override
    public int updateTaskByID(Task task) {
        return taskMapper.updateTaskByID(task);
    }

    /**
     * 查询所有任务
     * @param page
     * @param size
     * @return
     */
    @Override
    public RespPageBean queryTaskList(Integer page, Integer size,Integer user_id,Integer task_state) {
        if (page!=null && size!=null){
            page = (page-1) * size;
        }
        List<Task> data = taskMapper.queryTaskList(page,size,user_id);
        Long total = taskMapper.getTotal(user_id,task_state);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

//    /**
//     * 查看自己发布的任务（1.未被接/2.正在进行中/3.已完成) / 查看自己接受的任务（2.正在进行/3.已完成）
//     * @param page
//     * @param size
//     * @param user_id
//     * @param accept_userId
//     * @param task_state
//     * @return
//     */
//    @Override
//    public RespPageBean queryMyTask(Integer page, Integer size, Integer user_id, Integer accept_userId, Integer task_state) {
//        if (page!=null && size!=null){
//            page = (page-1) * 10;
//        }
//        List<Task> data = taskMapper.queryMyTask(page,size,user_id,accept_userId,task_state);
//        Long total = taskMapper.getTotal(user_id,accept_userId,task_state);
//        RespPageBean bean = new RespPageBean();
//        bean.setData(data);
//        bean.setTotal(total);
//        return bean;
//    }

}
