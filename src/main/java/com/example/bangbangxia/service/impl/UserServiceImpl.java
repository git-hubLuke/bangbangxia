package com.example.bangbangxia.service.impl;

import com.example.bangbangxia.dao.UserMapper;
import com.example.bangbangxia.domain.BookManage;
import com.example.bangbangxia.domain.RespPageBean;
import com.example.bangbangxia.domain.User;
import com.example.bangbangxia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录验证
     * @param user
     * @return
     */
    @Override
    public User loginCheck(User user) {
        User u = userMapper.loginCheck(user);
        return u;
    }

    /**
     * 注册用户
     * @param user
     */
    @Override
    public void register(User user) {
        userMapper.register(user);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    /**
     * 分页查询所有用户
     * @param page
     * @param size
     * @return
     */
    @Override
    public RespPageBean getUserByPage(Integer page, Integer size) {
        if(page != null && size != null){
            page = (page - 1) * size;
        }
        List<User> data=userMapper.getUserByPage(page,size);
        Long total=userMapper.getTotal();
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    /**
     * 删除用户
     * @param user_id
     * @return
     */
    @Override
    public int deleteUserById(Integer user_id) {
        return userMapper.deleteUserById(user_id);
    }

    /**
     * 修改用户密码
     * @param user
     * @return
     */
    @Override
    public int updateUserPassword(User user) {
        return userMapper.updateUserPassword(user);
    }
}
