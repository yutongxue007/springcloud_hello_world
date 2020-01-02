package com.atguigu.cloud.service;

import com.atguigu.cloud.bean.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yutongxue
 * @create 2020-01-02 13:30
 */
/*使用Hystrix进行服务的熔断
 * 1）、引入Hystrix的starter
 * 2）、开启xxx功能 ：@EnableCircuitBreaker
 * 3）、@FeignClient(value="CLOUD-PROVIDER-MOVIE",fallback=指定这个接口的异常处理类（异常处理类必须实现这个接口）)
 */
@FeignClient(value="CLOUD-PROVIDER-MOVIE",fallback=MovieFeignExceptionHandlerService.class)
public interface MovieServiceFeign {
    //  未来这个接口就会调用很多方法，定制每一个方法远程出错如何返回兜底mock数据；
    @GetMapping("/movie")
    public Movie getNewMovie();
}
