package com.yupei.peirpc.proxy;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.yupei.peirpc.model.RpcRequest;
import com.yupei.peirpc.model.RpcResponse;
import com.yupei.peirpc.serializer.JdkSerializer;
import com.yupei.peirpc.serializer.Serializer;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 服务代理(JDK动态代理)
 */
public class ServiceProxy implements InvocationHandler {
    /**
     * 调用代理
     *
     * @param proxy  代理对象
     * @param method 代理方法
     * @param args   参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //指定序列化器
        Serializer serializer = new JdkSerializer();

        //构造请求
        RpcRequest request = RpcRequest.builder()
                .serviceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .parameterTypes(method.getParameterTypes())
                .parameters(args)
                .build();
        try {
            //序列化
            byte[] bodyBytes = serializer.serialize(request);
            //发送请求
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bodyBytes)
                    .execute()) {
                byte[] result = httpResponse.bodyBytes();
                RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
                return rpcResponse.getData();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
