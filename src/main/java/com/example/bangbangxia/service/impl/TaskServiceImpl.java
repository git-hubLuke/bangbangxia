package com.example.bangbangxia.service.impl;

import com.example.bangbangxia.dao.TaskMapper;
import com.example.bangbangxia.utils.RespBean;
import com.example.bangbangxia.utils.RespPageBean;
import com.example.bangbangxia.domain.Task;
import com.example.bangbangxia.domain.TotalSelect;
import com.example.bangbangxia.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * @param task_id,user_id,accept_userId,task_state
     * @return
     */
//    @Override
//    public int updateTaskByID(Integer task_id,Integer user_id, Integer accept_userId, Integer task_state) {
//        return taskMapper.updateTaskByID(task_id,user_id,accept_userId,task_state);
//    }
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
    public RespBean queryTaskList(Integer page, Integer size,Integer user_id) {
        if (page!=null && size!=null){
            page = (page-1) * size;
        }
        List<Task> data = taskMapper.queryTaskList(page,size,user_id);
        Long total = taskMapper.getTotal(new TotalSelect(user_id,null,1));
        RespPageBean bean = new RespPageBean(total,data);
        return RespBean.ok("查询成功",bean);
    }

    /**
     * 查看自己发布的任务（1.未被接/2.正在进行中/3.已完成)* / 查看自己接受的任务（2.正在进行/3.已完成）
     * @param page
     * @param size
     * @param user_id
     * @param accept_userId
     * @param task_state
     * @return
     */
    @Override
    public RespBean queryMyTask(Integer page, Integer size, Integer user_id, Integer accept_userId, Integer task_state) {
        if (page!=null && size!=null){
            page = (page-1) * 10;
        }
        /*if (user_id==null || user_id.equals("")){
            return RespBean.error("user_id为空");
        }*/
        List<Task> data = taskMapper.queryMyTask(page,size,user_id,accept_userId,task_state);
        Long total = taskMapper.getTotal(new TotalSelect(user_id,accept_userId,task_state));
        RespPageBean bean = new RespPageBean(total,data);
        return RespBean.ok("查询成功",bean);
    }

}
