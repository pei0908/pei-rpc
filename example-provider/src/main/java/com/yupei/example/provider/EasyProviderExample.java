package com.yupei.example.provider;


import com.yupei.example.common.model.User;
import com.yupei.example.common.service.UserService;
import com.yupei.peirpc.registry.LocalRegistry;
import com.yupei.peirpc.server.HttpServer;
import com.yupei.peirpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        //注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
        //启动web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.dpStart(8080);
    }
}
