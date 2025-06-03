package com.yupei.peirpc.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Mock服务代理(JDK动态代理)
 *
 * @author pei
 */
@Slf4j
public class MockServiceProxy implements InvocationHandler {
    /**
     * 调用代理
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //根据方法的返回值类型，生成特定的默认值对象
        Class<?> methoddReturnType = method.getReturnType();
        log.info("mock invoke {}",method.getName());
        return getDefaultObject(methoddReturnType);
    }

    /**
     * 根据返回值类型，生成默认值对象
     *
     * @param type
     * @return
     */
    private Object getDefaultObject(Class<?> type) {
        //基本类型
        if (type.isPrimitive()) {
            if (type == boolean.class) {
                return false;
            }else if (type == byte.class) {
                return (byte) 0;
            }else if (type == short.class) {
                return (short) 0;
            }else if (type == int.class) {
                return 0;
            }else if (type == long.class) {
                return 0L;
            }else if (type == float.class) {
                return 0.0f;
            }else if (type == double.class) {
                return 0.0d;
            }else if (type == char.class) {
                return (char) 0;
            }else if (type == void.class) {
                return null;
            }
        }
        return null;
    }
}
