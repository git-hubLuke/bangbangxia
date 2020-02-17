package com.example.bangbangxia.controller;

import com.example.bangbangxia.domain.BookManage;
import com.example.bangbangxia.domain.RespBean;
import com.example.bangbangxia.domain.RespPageBean;
import com.example.bangbangxia.domain.User;
import com.example.bangbangxia.service.UserService;
import com.example.bangbangxia.utils.WxUserByHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://domain2.com",
        maxAge = 3600,
        methods = {RequestMethod.GET, RequestMethod.POST})

@RestController
public class UserController {
    @Value("${appid}")
    private String appid;
    @Value("${secret}")
    private String secret;
    @Value("${grant_type}")
    private String grant_type;
    @Value("${token_urlImpl}")
    private String token_urlImpl;
    @Value("${user_urlImpl}")
    private String user_urlImpl;


    @Autowired
    private UserService userService;
    @Autowired
    private WxUserByHttp WxUserByHttp;


    @RequestMapping(value = "/")
    public @ResponseBody String hello() {
        System.out.println("你好");
        return "success";
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping(value = "/insertUser")
    public RespBean insertUser(@RequestBody User user){
        if (userService.insertUser(user) == 1) {
            return RespBean.ok("保存用户成功");
        }
        return RespBean.error("保存用户失败");
    }

    /**
     * 微信登录
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = "/login")
    public @ResponseBody User login(String code, Model model){
        //调用方法获取微信User
        User user=WxUserByHttp.getUser(code);
        return user;
    }

    @RequestMapping(value = "/testlogin")
    public @ResponseBody String testlogin(String username,String password){
        System.out.println("访问到啦");
        return "success";
    }

    /**
     * 查询所有用户(分页)
     * @return
     */
    @GetMapping(value = "/getUserByPage")
    public RespPageBean getUserByPage(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "10") Integer size){
        return userService.getUserByPage(page,size);
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PostMapping(value = "/updateUser")
    public RespBean updateUser(@RequestBody User user){
        if (userService.updateUser(user)==1){
            return RespBean.ok("更新用户成功");
        }
        return RespBean.error("更新用户失败");
    }

    /**
     * 删除用户
     * @param user_id
     * @return
     */
    @DeleteMapping(value = "/deleteUserById")
    public RespBean deleteUserById(Integer user_id){
        if (userService.deleteUserById(user_id)==1){
            return RespBean.ok("删除用户成功");
        }
        return RespBean.error("删除用户失败");
    }


    /**
     * 修改用户密码
     * @param user
     * @return
     */
    @PostMapping(value = "/updateUserPassword")
    public RespBean updateUserPassword(@RequestBody User user){
        if (userService.updateUserPassword(user)==1){
            return RespBean.ok("修改密码成功");
        }
        return RespBean.error("修改密码失败");
    }

}
