package com.book.web;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * Created by yuzongtao on 2018/2/12.
 */
public class RedisTest {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("101.132.182.81", 63790);
        System.out.println("Connection to server sucessfully");
        //查看服务是否运行
        System.out.println("Server is running: "+jedis.ping());

        //设置 redis 字符串数据
        jedis.set("andy", "nice && handsome");
        // 获取存储的数据并输出
        System.out.println("Stored string in redis:: "+ jedis.get("andy"));

        //存储数据到列表中
        jedis.lpush("tutorial-list", "Redis");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("C", 0 ,5);
        for(int i=0; i<list.size(); i++) {
            System.out.println("Stored string in redis:: "+list.get(i));
        }

        // 获取数据并输出
        Set<String> set = jedis.keys("*");
        for(int i=0; i<set.size(); i++) {
            System.out.println("List of stored keys:: "+ set.toString());
        }
    }
}
