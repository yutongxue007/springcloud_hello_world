package com.atguigu.cloud.service;

import com.atguigu.cloud.bean.Movie;
import com.atguigu.cloud.bean.User;
import com.atguigu.cloud.dao.UserDao;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    RestTemplate restTemplate;

    //获取用户信息给下面方法调用
    public User getUserById(Integer id){
        User user = userDao.getUser(id);
        return user;
    }

    /**
     * 未使用RestTemplate
     */
    //@HystrixCommand(fallbackMethod="hystrix")
    /*public Map<String, Object> buyMovie(Integer id){
        Map<String, Object> result = new HashMap<>();
        //1、查询用户信息
        User user = getUserById(id);
        //2、查到最新电影票
        result.put("user", user);
        result.put("movie", null);//暂时为null
        return result;
    }*/

    /**
     * 使用RestTemplate实现远程调用
     */
    @HystrixCommand(fallbackMethod="hystrix")
    public Map<String, Object> buyMovie(Integer id){
        Map<String, Object> result = new HashMap<>();
        //1、查询用户信息
        User user = getUserById(id);
        //2、查到最新电影票  restTemplate使用java代码来模拟发请求
        Movie movie = restTemplate.getForObject("http://CLOUD-PROVIDER-MOVIE/movie", Movie.class);

        result.put("user", user);
        result.put("movie", movie);
        return result;
    }

    public Map<String, Object> hystrix(Integer id){
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
    }


}
