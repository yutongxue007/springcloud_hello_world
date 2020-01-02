package com.atguigu.cloud.contoller;

import com.atguigu.cloud.bean.User;
import com.atguigu.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yutongxue
 * @create 2020-01-02 0:29
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    //获取用户信息(通过?id=1给id传值)
    @GetMapping("/user")
    public User getUser(@RequestParam("id")Integer id){
        User user = userService.getUserById(id);
        return user;
    }

    //获取电影信息(通过?id=1给id传值)
    @GetMapping("/buyMovie")
    public Map<String, Object> buyMovie(@RequestParam("id")Integer id){
        Map<String, Object> map = userService.buyMovie(id);
        return map;
    }

}

