package com.example.bangbangxia.service;

import com.example.bangbangxia.domain.BookManage;
import com.example.bangbangxia.domain.BookSub;
import com.example.bangbangxia.domain.RespPageBean;

/**
 * 图书管理业务层接口
 */
public interface BookManageService {
    //新增图书
    int insertBook(BookManage bookManage);

    //更新图书
    int updateBook(BookManage bookManage);

    //删除图书
    int deleteBookById(Integer book_id);

    //查看图书列表
    RespPageBean queryBookList(Integer page, Integer size);

    //借阅图书
    int addSubBook(BookSub bookSub);

    //归还图书
    int returnSubBook(BookSub bookSub);

    //查看借阅图书
    RespPageBean queryBookSub(Integer page, Integer size);

    //更新图书库存
    int updateInventory(BookManage bookManage);
}
