package com.example.bangbangxia.service;


import com.example.bangbangxia.utils.RespBean;
import com.example.bangbangxia.utils.RespPageBean;
import com.example.bangbangxia.domain.User;

/**
 * 用户业务层接口
 */
public interface UserService {

    //插入User
    int insertUser(User user);

    //查询所有用户
    RespBean getUserByPage(Integer page, Integer size);

    //更新用户
    int updateUser(User user);

    //删除用户
    int deleteUserById(Integer user_id);

    //修改用户密码
    int updateUserPassword(User user);

    //根据id查询用户信息
    User findUserById(int user_id);

    //根据姓名查找用户
    User findUserByName(String user_name);

    //登录
    RespBean login(String user_name, String user_password);

    //注册
    RespBean register(String user_name, String user_password, String user_confirmPassword);
}
