package com.example.bangbangxia.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 实现数据库分页功能
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespPageBean {
    //总记录数
    private Long total;
    //返回的数据
    private List<?> data;
}
