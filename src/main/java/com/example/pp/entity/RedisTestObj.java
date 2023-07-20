package com.example.pp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@RedisHash("RedisTestObj")
@AllArgsConstructor
@Builder
public class RedisTestObj {
    @Id
    private String id;

    @Indexed
    private String username;

    @TimeToLive
    private long expiration;


}
