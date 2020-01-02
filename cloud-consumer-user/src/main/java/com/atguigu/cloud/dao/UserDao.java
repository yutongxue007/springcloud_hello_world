package com.atguigu.cloud.dao;

import com.atguigu.cloud.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @author yutongxue
 * @create 2020-01-02 0:28
 * dao层返回用户的假数据
 */
@Repository
public class UserDao {
    public User getUser(Integer id){
        User user = new User();
        user.setId(id);
        user.setUserName("张三");
        return user;
    }
}
