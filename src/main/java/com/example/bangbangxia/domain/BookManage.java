package com.example.bangbangxia.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 图书管理实体类
 */
@Data
public class BookManage implements Serializable {

    private Integer book_id; //主键，自增

    private String book_name;//图书名称

    private String book_author;//作者

    private Integer book_inventory;//库存

    private Double book_price;//价格
}
