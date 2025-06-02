package com.yupei.peirpc.server;

/**
 * HTTP服务器接口
 */
public interface HttpServer {
    /**
     * 启动HTTP服务器
     * @param port 端口
     */
    void dpStart(int port);
}
