package com.atguigu.cloud.dao;

import com.atguigu.cloud.bean.Movie;
import org.springframework.stereotype.Repository;

/**
 * @author yutongxue
 * @create 2020-01-02 0:12
 * dao层设置假数据返回
 */
@Repository
public class MovieDao {
    public Movie getNewMovie(){
        Movie movie = new Movie();
        movie.setId(1);
        movie.setMovieName("战狼");
        return movie;
    }
}

