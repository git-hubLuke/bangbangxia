package com.example.bangbangxia.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *   数据返回格式化类
 *   200：表示成功
 *   500：表示错误，错误信息存在msg字段中
 *   501：bean验证错误，不管多少个错误都以Map形式返回
 *   502：拦截器拦截到用户token出错
 *   555：异常抛出信息
 */
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class RespBean {

    private Integer status;//状态码
    private String msg;//状态信息
    private Object obj;

    //构造方法
    public RespBean(){}

    public RespBean(Integer status, String msg, Object obj){
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public RespBean(Object obj){
        this.status = 200;
        this.msg = "ok";
        this.obj = obj;
    }

    public static RespBean ok(String msg,Object obj) {
        return new RespBean(200,msg,obj);
    }

    //重载
    public static RespBean ok(String msg) {
        return new RespBean(200,msg,null);
    }

    public static RespBean ok(Object obj){
        return new RespBean(obj);
    }

    public static RespBean error(String msg) {
        return new RespBean(400, msg, null);
    }

    //设置状态信息
    public static RespBean toJson(Integer status, String msg, Object obj){
        return new RespBean(status,msg,obj);
    }
}
