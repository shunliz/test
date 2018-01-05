#!/usr/bin/env python
#-*- coding:utf-8 -*-
import redis

class RedisHelper(object):
    def __init__(self):
        self.__conn = redis.Redis(host='10.127.3.1',port=31379,db=0,password='redis')#连接Redis
        self.channel = 'monitor' #定义名称

    def publish(self,msg):#定义发布方法
        self.__conn.publish(self.channel,msg)
        return True

    def subscribe(self):#定义订阅方法
        pub = self.__conn.pubsub()
        pub.subscribe(self.channel)
        pub.parse_response()
        return pub
