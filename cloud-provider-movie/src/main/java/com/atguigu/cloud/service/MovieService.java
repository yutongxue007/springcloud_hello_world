package com.atguigu.cloud.service;

import com.atguigu.cloud.bean.Movie;
import com.atguigu.cloud.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author yutongxue
 * @create 2020-01-02 0:13
 */
@Service
public class MovieService {
    @Autowired
    MovieDao movieDao;

    //标注调用此提供者的消费者
    @Value("${server.port}")
    private int port;

    public Movie getNewMovie(){
        System.out.println("port："+port);
        return movieDao.getNewMovie();
    }

}

