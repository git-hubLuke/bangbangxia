package com.example.bangbangxia.controller;

import com.example.bangbangxia.domain.User;
import com.example.bangbangxia.service.UserService;
import com.example.bangbangxia.utils.RespBean;
import com.example.bangbangxia.utils.WxUserByHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://domain2.com",
        maxAge = 3600,
        methods = {RequestMethod.GET, RequestMethod.POST})

@RestController
public class LoginController {

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
    private WxUserByHttp wxUserByHttp;

    /**
     * 登录
     * @param user_name
     * @param user_password
     * @return
     */
    @RequestMapping(value = "/login")
    public RespBean login(String user_name, String user_password){
        return userService.login(user_name,user_password);
    }

    /**
     * 注册
     * @param user_name
     * @param user_password
     * @param user_confirmPassword
     * @return
     */
    @RequestMapping(value = "/register")
    public RespBean register(String user_name, String user_password, String user_confirmPassword){
        return userService.register(user_name,user_password,user_confirmPassword);
    }

    /**
     * 微信登录
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = "/weixinlogin")
    public @ResponseBody User weixinlogin(String code, Model model){
        //调用方法获取微信User
//        User user=WxUserByHttp.getUser(code);
//        return user;
        return null;
    }

    /**
     * 测试登录是否成功
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/testWeixinlogin")
    public @ResponseBody String testWeixinlogin(String username, String password){
        System.out.println("访问到啦");
        return "success";
    }
}
