package com.yupei.peirpc.serializer;

import io.vertx.core.buffer.Buffer;

import java.io.*;

/**
 * JDK序列化器
 */
public class JdkSerializer implements Serializer {
    /**
     * 序列化
     *
     * @param object
     * @return
     * @throws IOException
     */
    @Override
    public byte[] serialize(Object object) throws IOException {
        // 创建一个内存字节输出流，用来存储序列化后的字节数据
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // 创建一个对象输出流，包装在字节输出流之上，用于将对象写入字节流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        // 将传入的对象序列化写入对象输出流
        objectOutputStream.writeObject(object);
        // 关闭对象输出流，确保所有缓冲数据被写入字节流，同时释放资源
        objectOutputStream.close();
        // 从字节输出流中获取序列化后的字节数组并返回
        return outputStream.toByteArray();
    }

    /**
     * 反序列化
     *
     * @param bytes
     * @param type
     * @param <T>
     * @return
     * @throws IOException
     */
    @Override
    public <T> T deserialize(byte[] bytes, Class<T> type) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        try {
            return (T) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            objectInputStream.close();
        }
    }
}
