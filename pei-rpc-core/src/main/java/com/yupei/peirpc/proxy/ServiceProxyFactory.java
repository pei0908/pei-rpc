package com.yupei.peirpc.proxy;

import com.yupei.peirpc.RpcApplication;

import java.lang.reflect.Proxy;

/**
 * 服务代理工厂(用于创建代理对象)
 */
public class ServiceProxyFactory {
    /**
     * 根据服务类型获取代理对象
     *
     * @param serviceClass 服务接口
     * @param <T>          服务接口
     * @return 代理对象
     */
    public static <T> T getProxy(Class<T> serviceClass) {
        if (RpcApplication.getRpcConfig().isMock()){
            return getMockProxy(serviceClass);
        }
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class<?>[]{serviceClass},
                new ServiceProxy());
    }
    /**
     * 获取Mock代理对象
     *
     * @param serviceClass 服务接口
     * @param <T>          服务接口
     * @return 模拟代理对象
     */
    private static <T> T getMockProxy(Class<T> serviceClass) {
         return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class<?>[]{serviceClass},
                new MockServiceProxy());
    }
}
