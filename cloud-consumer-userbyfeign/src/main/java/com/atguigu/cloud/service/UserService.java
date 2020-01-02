package com.atguigu.cloud.service;

import com.atguigu.cloud.bean.Movie;
import com.atguigu.cloud.bean.User;
import com.atguigu.cloud.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yutongxue
 * @create 2020-01-02 0:28
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    //面向接口编程
    @Autowired
    MovieServiceFeign movieServiceFeign; //调用Feign接口；其实就是调用远程服务


    //获取用户信息给下面方法调用
    public User getUserById(Integer id){
        User user = userDao.getUser(id);
        return user;
    }

    public Map<String, Object> buyMovie(Integer id){
        Map<String, Object> result = new HashMap<>();
        //1、查询用户信息
        User userById = getUserById(id);
        //2、查到最新电影票  Feign方式发起远程调用
        Movie movie = movieServiceFeign.getNewMovie();

        result.put("user", userById);
        result.put("movie", movie);
        return result;
    }


    /*public Map<String, Object> hystrix(Integer id){
        User user = new User();
        user.setId(-1);
        user.setUserName("未知用户");

        Movie movie = new Movie();
        movie.setId(-100);
        movie.setMovieName("无此电影");

        Map<String, Object>  result = new HashMap<>();
        result.put("user", user);
        result.put("movie", movie);
        return result;
    }*/


}
