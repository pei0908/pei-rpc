package com.yupei.peirpc.server;

import io.vertx.core.Vertx;

public class VertxHttpServer implements HttpServer {
    /**
     * 启动服务器
     *
     * @param port 服务端口
     */
    @Override
    public void dpStart(int port) {
        //创建 Vert.x 实例
        Vertx vertx = Vertx.vertx();

        //创建 HTTP 服务器
        io.vertx.core.http.HttpServer server = vertx.createHttpServer();

        //监听端口并处理请求
        server.requestHandler(new HttpServerHandler());

        //启动HTTP服务器并监听指定端口
        server.listen(port, result -> {
            if (result.succeeded()) {
                System.out.println("Server is now listening on port" + port);
            } else {
                System.out.println("Failed to start HTTP server: " + result.cause());
            }
        });

    }
}
