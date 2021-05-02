package com.zsl.redis.queue.queuedemo.controller;

import com.zsl.redis.queue.queuedemo.util.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 描述：消费者(消息接收方)
 * @author yys
 * @date 2019.03.15
 */
@RestController
@RequestMapping("/consumer")
public class RedisConsumerController {

    @Autowired
    RedisClient redisClient;

    /** 公共配置 */
    private final static String MESSAGE = "testmq";

    /**
     * 接收消息API
     * @return
     */
    @RequestMapping("/receiveMessage")
    public String sendMessage() {
        return (String) redisClient.brpop(MESSAGE, 0, TimeUnit.SECONDS);
    }

}