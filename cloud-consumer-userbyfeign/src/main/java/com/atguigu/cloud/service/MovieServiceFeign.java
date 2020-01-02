package com.atguigu.cloud.service;

import com.atguigu.cloud.bean.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yutongxue
 * @create 2020-01-02 13:19
 */
@FeignClient(value="CLOUD-PROVIDER-MOVIE") //与被调用端的服务名称一致
public interface MovieServiceFeign {
    @GetMapping("/movie")
    public Movie getNewMovie(); //与被调用服务端的映射方法一致
}

