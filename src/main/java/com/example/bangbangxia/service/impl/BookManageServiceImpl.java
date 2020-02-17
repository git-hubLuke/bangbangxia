package com.example.bangbangxia.service.impl;

import com.example.bangbangxia.dao.BookManageMapper;
import com.example.bangbangxia.domain.*;
import com.example.bangbangxia.service.BookManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 图书管理业务层实现类
 */
@Service
public class BookManageServiceImpl implements BookManageService {

    @Autowired
    private BookManageMapper bookManageMapper;


    /**
     * 新增图书
     * @param bookManage
     * @return
     */
    @Override
    public int insertBook(BookManage bookManage) {
        return bookManageMapper.insertBook(bookManage);
    }

    /**
     * 更新图书
     * @param bookManage
     * @return
     */
    @Override
    public int updateBook(BookManage bookManage) {
        return bookManageMapper.updateBook(bookManage);
    }

    /**
     * 删除图书
     * @param book_id
     * @return
     */
    @Override
    public int deleteBookById(Integer book_id) {
        return bookManageMapper.deleteBookById(book_id);
    }

    /**
     * 查看图书列表
     * @param page
     * @param size
     * @return
     */
    @Override
    public RespPageBean queryBookList(Integer page, Integer size) {
        if (page != null && size != null){
            page = (page-1)*size;
        }
        List<Book> data = bookManageMapper.queryBookList(page,size);
        Long total = bookManageMapper.getTotal();
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    /**
     * 借阅图书
     * @param bookSub
     * @return
     */
    @Override
    public int addSubBook(BookSub bookSub) {
        return bookManageMapper.addSubBook(bookSub);
    }

    /**
     * 归还图书
     * @param bookSub
     * @return
     */
    @Override
    public int returnSubBook(BookSub bookSub) {
        return bookManageMapper.returnSubBook(bookSub);
    }

    /**
     * 查看借阅图书
     * @param page
     * @param size
     * @return
     */
    @Override
    public RespPageBean queryBookSub(Integer page, Integer size) {
        if (page!=null && size!=null){
            page = (page-1)*size;
        }
        List<BookSub> data = bookManageMapper.queryBookSub(page,size);
        Long total2 = bookManageMapper.getTotal2();
        RespPageBean bean2 = new RespPageBean();
        bean2.setData(data);
        bean2.setTotal(total2);
        return bean2;
    }

    /**
     * 更新图书库存
     * @param bookManage
     * @return
     */
    @Override
    public int updateInventory(BookManage bookManage) {
        return bookManageMapper.updateInventory(bookManage);
    }


}
