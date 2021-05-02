package com.zsl.redis.queue.queuedemo.controller;

import com.zsl.redis.queue.queuedemo.util.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 描述：生产者(消息发送方)
 * @author yys
 * @date 2019.03.15
 */
@RestController
@RequestMapping("/producer")
public class RedisProducerController {

    @Autowired
    RedisClient redisClient;

    /** 公共配置 */
    private final static String SUCCESS = "success";
    private final static String MESSAGE = "testmq";
    private static final List<String> list;

    static {
        list = Arrays.asList(new String[]{"猿医生", "CD", "yys"});
    }

    /**
     * 消息发送API
     * @return
     */
    @RequestMapping("/sendMessage")
    public String sendMessage() {
        for (String message : list) {
            redisClient.lpush(MESSAGE, message);
        }
        return SUCCESS;
    }

}