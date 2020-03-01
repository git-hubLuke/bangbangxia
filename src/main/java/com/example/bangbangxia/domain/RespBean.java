package com.example.bangbangxia.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {

    private Integer status;
    private String msg;
    private Object obj;

    public static RespBean ok(String msg,Object obj) {
        return new RespBean(200,msg,obj);
    }

    //重载
    public static RespBean ok(String msg) {
        return new RespBean(200,msg,null);
    }

    public static RespBean error(String msg) {
        return new RespBean(400, msg, null);
    }
}
