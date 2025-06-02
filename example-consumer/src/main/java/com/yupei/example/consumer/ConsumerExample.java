package com.yupei.example.consumer;

import com.yupei.peirpc.config.RpcConfig;
import com.yupei.peirpc.utils.ConfigUtils;

/**
 * 消费者示例
 */
public class ConsumerExample {
    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);
    }
}
