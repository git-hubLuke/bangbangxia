package com.example.bangbangxia.dao;

import com.example.bangbangxia.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    //保存用户
    int insertUser(User user);

    //查询所有用户
    List<User> getUserByPage(@Param("page") Integer page, @Param("size") Integer size);

    //总条数
    Long getTotal();

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
}
