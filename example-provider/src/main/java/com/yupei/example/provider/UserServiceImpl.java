package com.yupei.example.provider;


import com.yupei.example.common.model.User;
import com.yupei.example.common.service.UserService;

/**
 * 用户服务实现类
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(User user) {
        System.out.println("用户名" + user.getName());
         return user;
    }
}
