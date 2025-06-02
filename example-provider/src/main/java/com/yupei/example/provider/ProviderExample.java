package com.yupei.example.provider;

import com.yupei.example.common.service.UserService;
import com.yupei.peirpc.RpcApplication;
import com.yupei.peirpc.registry.LocalRegistry;
import com.yupei.peirpc.server.HttpServer;
import com.yupei.peirpc.server.VertxHttpServer;

/**
 * 服务者示例
 */
public class ProviderExample {
    public static void main(String[] args) {
        // 初始化RPC框架
        RpcApplication.init();

        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.dpStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
