package com.atguigu.cloud.controller;

import com.atguigu.cloud.bean.Movie;
import com.atguigu.cloud.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yutongxue
 * @create 2020-01-02 0:13
 */
@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    /**
     * 获取最新电影
     * 接口名/movie
     */
    @GetMapping("/movie")
    public Movie getNewMovie(){
        return movieService.getNewMovie();
    }

}

