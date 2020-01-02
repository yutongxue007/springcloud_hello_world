package com.atguigu.cloud.service;

import com.atguigu.cloud.bean.Movie;
import org.springframework.stereotype.Component;

/**
 * @author yutongxue
 * @create 2020-01-02 13:31
 */
@Component
public class MovieFeignExceptionHandlerService implements MovieServiceFeign{

    /**
     * 远程这个方法调用出问题就会调用此方法
     */
    @Override
    public Movie getNewMovie() {
        Movie movie = new Movie();
        movie.setId(-100);
        movie.setMovieName("无此电影呀...");
        return movie;
    }
}

