package com.example.bangbangxia.dao;

import com.example.bangbangxia.domain.Book;
import com.example.bangbangxia.domain.BookManage;
import com.example.bangbangxia.domain.BookSub;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 图书管理持久层接口
 */
@Repository
@Mapper
public interface BookManageMapper {

    //新增图书
    int insertBook(BookManage bookManage);

    //更新图书
    int updateBook(BookManage bookManage);

    //删除图书
    int deleteBookById(Integer book_id);

    //查看图书列表
    List<Book> queryBookList(Integer page, Integer size);

    //总条数
    Long getTotal();

    //借阅图书
    int addSubBook(BookSub bookSub);

    //归还图书
    int returnSubBook(BookSub bookSub);

    //查看图书借阅
    List<BookSub> queryBookSub(Integer page, Integer size);

    Long getTotal2();

    //更新图书库存
    int updateInventory(BookManage bookManage);
}
