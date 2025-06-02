package com.yupei.peirpc.serializer;

import io.vertx.core.buffer.Buffer;

import java.io.IOException;

/**
 * 序列化器接口
 */
public interface Serializer {

    /**
     * 序列化
     *
     * @param object
     * @return
     * @throws IOException
     */
    byte[] serialize(Object object) throws IOException;

    /**
     * 反序列化
     *
     * @param body
     * @param type
     * @param <T>
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    <T> T deserialize(byte[] body, Class<T> type) throws IOException;
}
