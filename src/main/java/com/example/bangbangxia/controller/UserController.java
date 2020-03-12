package com.example.bangbangxia.controller;

import com.example.bangbangxia.utils.RespBean;
import com.example.bangbangxia.utils.RespPageBean;
import com.example.bangbangxia.domain.User;
import com.example.bangbangxia.service.UserService;
import com.example.bangbangxia.utils.WxUserByHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

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
     * 查询所有用户
     * @return
     */
    @GetMapping(value = "/getUserByPage")
    public RespBean getUserByPage(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "10") Integer size){
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
