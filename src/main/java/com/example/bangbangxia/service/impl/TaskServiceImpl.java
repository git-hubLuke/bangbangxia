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
    public RespPageBean queryTaskList(Integer page, Integer size,Integer task_id) {
        if (page!=null && size!=null){
            page = (page-1) * size;
        }
        List<Task> data = taskMapper.queryTaskList(page,size,task_id);
        Long total = taskMapper.getTotal();
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    /**
     * 查看自己发布的进行中的任务
     * @param page
     * @param size
     * @param user_id
     * @param task_state
     * @return
     */
    @Override
    public RespPageBean queryMyTaskProcess(Map<String,Object> map) {
        //1.
        String page="";
        if (map.containsKey(page)){

        }

        if (page!=null && size!=null){
            page = (page-1) * 10;
        }
        List<Task> data2 = taskMapper.queryMyTaskProcess(map);
//        Long total2 = taskMapper.getTotal2(user_id);
        RespPageBean bean2 = new RespPageBean();
        bean2.setData(data2);
//        bean2.setTotal(total2);
        return bean2;
    }

}
