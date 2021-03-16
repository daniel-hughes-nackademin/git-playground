package com.example.gitplayground.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;

@Configuration
public class RedisConfig {

    @Bean
    public RedisAtomicInteger personCounter(RedisConnectionFactory redisConnectionFactory){
        return new RedisAtomicInteger("PERSON_COUNTER", redisConnectionFactory);
    }
}
