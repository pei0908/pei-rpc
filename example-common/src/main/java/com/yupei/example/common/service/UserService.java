package com.yupei.example.common.service;

import com.yupei.example.common.model.User;

/**
 * 用户服务
 */
public interface UserService {
    /**
     * 获取用户
     * @param user
     * @return
     */
    User getUser(User  user);

    /**
     * 获取数字1
     */
    default short getNum(){
        return 1;
    }
}
