package com.example.bangbangxia.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 任务实体类
 */
@Data
public class Task implements Serializable {

    private Integer task_id;//任务id

    private String task_name;//任务名称

    private String task_content;//任务内容

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date task_createtime;//任务创建的时间

    private Integer accept_userId;//接受任务的用户id

    private Integer task_state;//任务的状态   1：发布了任务未接 2：任务被接在进行中 3：任务已完成  1：任务被放弃 5：发布人删除了任务

    private Float task_money;//执行任务的钱

    private Integer user_id;//用户id
}
