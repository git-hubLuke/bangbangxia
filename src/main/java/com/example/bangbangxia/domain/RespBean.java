package com.example.bangbangxia.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 */
@Data
@AllArgsConstructor
public class RespBean {

    private Integer status;
    private String msg;
    private Object obj;

    public static RespBean ok(String msg) {
        return new RespBean(200,msg,null);
    }

    public static RespBean error(String msg) {
        return new RespBean(400, msg, null);
    }
}
