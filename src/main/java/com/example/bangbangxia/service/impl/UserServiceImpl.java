package com.example.bangbangxia.service.impl;

import com.example.bangbangxia.dao.UserMapper;
import com.example.bangbangxia.utils.JwtUtils;
import com.example.bangbangxia.utils.RespBean;
import com.example.bangbangxia.utils.RespPageBean;
import com.example.bangbangxia.domain.User;
import com.example.bangbangxia.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    private Log log = LogFactory.getLog(UserService.class);

    @Autowired
    private UserMapper userMapper;

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
     * 查询所有用户
     * @param page
     * @param size
     * @return
     */
    @Override
    public RespBean getUserByPage(Integer page, Integer size) {
        if(page != null && size != null){
            page = (page - 1) * size;
        }
        List<User> data=userMapper.getUserByPage(page,size);
        Long total=userMapper.getTotal();
        RespPageBean bean = new RespPageBean(total,data);
        return RespBean.ok("查询成功",bean);
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

    /**
     * 根据id查询用户信息
     * @param user_id
     * @return
     */
    @Override
    public User findUserById(int user_id) {
        return userMapper.findUserById(user_id);
    }

    /**
     * 根据姓名查找用户
     * @param user_name
     * @return
     */
    @Override
    public User findUserByName(String user_name) {
        return userMapper.findUserByName(user_name);
    }

    /**
     * 登录
     * @param user_name
     * @param user_password
     * @return
     */
    @Override
    public RespBean login(String user_name, String user_password) {
        if (user_name == null || user_name == ""){
            log.error("登录用户名为空");
            return RespBean.error("登录用户名不能为空");
        }else {
            User user = userMapper.findUserByName(user_name);
            if (user != null && user.getUser_password().equals(user_password)){
                log.info("登录成功");
                Map<String,Object> map = new HashMap<String, Object>();
                JwtUtils jwtUtils = new JwtUtils();
                map.put("user",user);
                map.put("loginToken",jwtUtils.getToken(user));
                return RespBean.ok(map);
            }
            log.error("登录失败，用户名或密码错误");
            return RespBean.error("账号或密码不正确！");

        }
    }

    /**
     * 注册
     * @param user_name
     * @param user_password
     * @param user_confirmPassword
     * @return
     */
    @Override
    public RespBean register(String user_name, String user_password, String user_confirmPassword) {
        if (user_name == null || user_name == ""){
            log.error("注册用户名为空");          //提示信息
            return RespBean.error("用户名不能为空"); //返回错误信息
        }else if (user_password == null || user_password == ""){
            log.error("注册密码为空");
            return RespBean.error("密码不能为空");
        } else if (user_password.length() < 6){
            log.error("您的密码长度小于6个字符");
            return RespBean.error("密码长度小于6个字符");
        }else if (!user_password.equals(user_confirmPassword)){
            log.error("两次密码不匹配");
            return RespBean.error("两次输入的密码不匹配");
        }else {
            User user = userMapper.findUserByName(user_name);
            if (user != null){
                log.error("已存在用户名：" + user_name);
                return RespBean.error("此用户已存在，注册失败");
            }else {
                user = new User();
                user.setUser_name(user_name);
                user.setUser_password(user_password);
                int id = userMapper.insertUser(user);
                user.setUser_id(id);
                log.info("注册成功" + user_name);
                Map<String,Object> map = new HashMap<String,Object>();
                JwtUtils jwtUtils = new JwtUtils();
                map.put("user",user);
                map.put("loginToken",jwtUtils.getToken(user));
                return RespBean.ok(map);
            }
        }
    }

}
