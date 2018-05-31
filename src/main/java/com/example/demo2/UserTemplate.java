package com.example.demo2;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserTemplate {

    private final RedisTemplate<String,User> userRedisTemplate;

    public UserTemplate(RedisTemplate<String, User> userRedisTemplate) {
        this.userRedisTemplate = userRedisTemplate;
    }

    public void deleteAll() {
        userRedisTemplate.delete("Users");
        System.out.println("delete All Call!!");
    }

    public void save(User user) {
        userRedisTemplate.opsForList().leftPush("Users",user);
        System.out.println("save Call!!");

    }

    public List<User> findAll() {
        return userRedisTemplate.opsForList().range("Users",0,-1);
    }
}
