package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserComponent implements ApplicationRunner {

    // 템플릿 사용 방법
    @Autowired
    private UserTemplate userTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userTemplate.deleteAll();

        User user1 = new User();
        user1.setRegDate(new Date());
        user1.setPassword("1111");
        user1.setNickName("sabbang");
        user1.setEmail("oh@gmail.com");

        userTemplate.save(user1);

        User user2 = new User();
        user1.setRegDate(new Date());
        user1.setPassword("1111");
        user1.setNickName("nanana");
        user1.setEmail("nam@gmail.com");

        userTemplate.save(user1);

        User user3 = new User();
        user3.setRegDate(new Date());
        user3.setPassword("1111");
        user3.setNickName("oneone");
        user3.setEmail("one@gmail.com");

        userTemplate.save(user3);

        userTemplate.findAll().forEach(u->{
            System.out.println(u.getEmail());
        });
    }


    // 리파지토리로 하는 방법

//    @Autowired
//    UserRepository userRepository;
//
//    List<User> userList = new ArrayList<>();
//
//    int count = 0;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//
//        User user = new User();
//        user.setEmail("aa@gmail.com");
//        user.setNickName("aa");
//        user.setPassword("1111");
//        user.setRegDate(new Date());
//
//        User user1 = new User();
//        user1.setEmail("bb@gmail.com");
//        user1.setNickName("bb");
//        user1.setPassword("1111");
//        user1.setRegDate(new Date());
//
//        User user2 = new User();
//        user2.setEmail("cc@gmail.com");
//        user2.setNickName("cc");
//        user2.setPassword("1111");
//        user2.setRegDate(new Date());
//
//        userList.add(user);
//        userList.add(user1);
//        userList.add(user2);
//
//        userRepository.saveAll(userList);
//
//        userRepository.findAll().forEach(u->{
//            System.out.println("===============");
//            System.out.println(u.getEmail());
//            System.out.println("===============");
//        });
//
//        System.out.println("==========delete===============");
//        System.out.println();
//        userRepository.delete(user);
//
//
//        userRepository.findAll().forEach(u->{
//            System.out.println("===============");
//            System.out.println(u.getEmail());
//            System.out.println("===============");
//        });
//
//        count = userList.size();
//        System.out.println("접속 인원 : " + count);  // 객체 아직 안뺀 인원임.
//    }
//
}
