package com.example.bangbangxia.domain;

import lombok.Data;

/**
 * 用户借书记录
 */
@Data
public class BookSub {
    private Integer id;//主键，自增

    private Integer user_id;//用户id

    private Integer book_id;//图书id

    private String subDateTime;//借阅时间

    private String returnDateTime;//归还时间

    private Integer booktype;//图书状态

    private Integer returntype;//归还状态


}
