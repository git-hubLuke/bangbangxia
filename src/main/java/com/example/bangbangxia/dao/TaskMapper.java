package com.example.bangbangxia.dao;

import com.example.bangbangxia.domain.Task;
import com.example.bangbangxia.domain.TotalSelect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
    int updateTaskByID(@Param("task_id") Integer task_id,@Param("user_id") Integer user_id,@Param("accept_userId") Integer accept_userId, @Param("task_state") Integer task_state);

    //查询所有任务
    List<Task> queryTaskList(@Param("page") Integer page, @Param("size") Integer size,@Param("user_id") Integer user_id);
    //查询所有任务的总条数
    Long getTotal(TotalSelect totalSelect);

    //查询自己的任务（发布的/接受的）
    List<Task> queryMyTask(@Param("page") Integer page, @Param("size") Integer size, @Param("user_id") Integer user_id,@Param("accept_userId") Integer accept_userId,@Param("task_state") Integer task_state);


}
