package com.yupei.example.consumer;

import com.yupei.example.common.model.User;
import com.yupei.example.common.service.UserService;
import com.yupei.peirpc.config.RpcConfig;
import com.yupei.peirpc.proxy.ServiceProxyFactory;
import com.yupei.peirpc.utils.ConfigUtils;

/**
 * 消费者示例
 */
public class ConsumerExample {
    public static void main(String[] args) {
        //获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("yupei");
        //调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
        long number = userService.getNum();
        System.out.println(number);
    }
}
