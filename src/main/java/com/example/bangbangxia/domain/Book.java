package com.example.bangbangxia.domain;

import lombok.Data;

/**
 * 图书实体类
 */
@Data
public class Book {

    private Integer book_id;

    private String book_name;

    private String book_author;

    private Integer book_inventory;

    private Double book_price;
}
