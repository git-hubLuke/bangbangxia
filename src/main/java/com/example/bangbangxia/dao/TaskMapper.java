package com.example.bangbangxia.dao;

import com.example.bangbangxia.domain.Task;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 任务的持久层接口
 */
@Repository
@Mapper
public interface TaskMapper {

    //添加任务
    int insertTask(Task task);

    //删除任务
    int deleteTask(Integer task_id);

    //更新任务
    int updateTask(Task task);

    //接受任务
    int updateTaskByID(Task task);

    //查询所有任务
    List<Task> queryTaskList(Integer page, Integer size,Integer task_id);
    //查询所有任务的总条数
    Long getTotal();

    //查询自己发布的进行中的任务
    List<Task> queryMyTaskProcess(Integer page, Integer size, Integer user_id);
    //查看自己发布的进行中的任务的总条数
    Long getTotal2(Integer task_state,Integer user_id);
}
