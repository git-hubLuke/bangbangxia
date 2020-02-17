package com.example.bangbangxia.controller;

import com.example.bangbangxia.domain.BookManage;
import com.example.bangbangxia.domain.BookSub;
import com.example.bangbangxia.domain.RespBean;
import com.example.bangbangxia.domain.RespPageBean;
import com.example.bangbangxia.service.BookManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BookManageController {

    @Autowired
    private BookManageService bookManageService;

    /**
     * 新增图书
     * @param bookManage
     * @return
     */
    @PostMapping(value = "/insertBook")
    public RespBean insertBook(@RequestBody BookManage bookManage){
        if (bookManageService.insertBook(bookManage)==1){
            return  RespBean.ok("新增图书成功");
        }
        return RespBean.error("新增图书失败");
    }

    /**
     * 更新图书
     * @param bookManage
     * @return
     */
    @PostMapping(value = "/updateBook")
    public RespBean updateBook(@RequestBody BookManage bookManage){
        if (bookManageService.updateBook(bookManage)==1){
            return RespBean.ok("更新图书成功");
        }
        return RespBean.error("更新图书失败");
    }

    /**
     * 删除图书
     * @param book_id
     * @return
     */
    @DeleteMapping(value = "/deleteBookById")
    public RespBean deleteBookById(Integer book_id){
        if (bookManageService.deleteBookById(book_id)==1){
            return RespBean.ok("删除图书成功");
        }
        return RespBean.error("删除图书失败");
    }

    /**
     * 查看图书列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/queryBookList")
    public RespPageBean queryBookList(@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "10")Integer size){
        return bookManageService.queryBookList(page,size);
    }

    /**
     * 图书借阅
     * @param bookSub
     * @return
     */
    @PostMapping(value = "/addSubBook")
    public RespBean addSubBook(@RequestBody BookSub bookSub){
        if (bookManageService.addSubBook(bookSub)==1){
            return RespBean.ok("借书成功");
        }
        return RespBean.error("借书失败");
    }

    /**
     * 图书归还
     * @param bookSub
     * @return
     */
    @PostMapping(value = "/returnSubBook")
    public RespBean returnSubBook(@RequestBody BookSub bookSub){
        if (bookManageService.returnSubBook(bookSub)==1){
            return RespBean.ok("图书归还成功");
        }
        return RespBean.error("图书归还失败");
    }

    /**
     * 查看借阅图书
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/queryBookSub")
    public RespPageBean queryBookSub(@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "10")Integer size){
        return bookManageService.queryBookSub(page,size);
    }

    /**
     * 更新图书库存
     * @param bookManage
     * @return
     */
    @PostMapping(value = "/updateInventory")
    public RespBean updateInventory(@RequestBody BookManage bookManage){
        if (bookManageService.updateInventory(bookManage)==1){
            return RespBean.ok("更新库存成功");
        }
        return RespBean.error("更新库存失败");
    }

}
