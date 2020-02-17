package com.example.bangbangxia.dao;

import com.example.bangbangxia.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    //保存用户
    public int insertUser(User user);

    //分页查询所有用户
    List<User> getUserByPage(Integer page, Integer size);

    //总条数
    Long getTotal();

    //更新用户
    int updateUser(User user);

    //删除用户
    int deleteUserById(Integer user_id);

    //修改用户密码
    int updateUserPassword(User user);



}
