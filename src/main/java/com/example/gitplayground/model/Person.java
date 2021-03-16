package com.example.gitplayground.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@RedisHash("Person")
public class Person {

    @Id
    @Indexed
    private int id;
    private String name;

}