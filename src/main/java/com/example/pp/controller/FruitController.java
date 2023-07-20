package com.example.pp.controller;

import com.example.pp.dto.FruitDto;
import com.example.pp.entity.Apple;
import com.example.pp.entity.RedisTestObj;
import com.example.pp.mapper.DtoMapper;
import com.example.pp.repository.redis.RedisTestObjRepository;
import com.example.pp.service.FruitService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/fruit")
@RequiredArgsConstructor
@Slf4j
public class FruitController {
    private final FruitService fruitService;
    private final RedisTestObjRepository redisTestObjRepository;

    private final StringRedisTemplate stringRedisTemplate;

    private HashOperations<String, String, String> hashOperations;

    @GetMapping("/get")
    public FruitDto get() {
//        return fruitService.getFruit();
        Apple apple = new Apple("apple", "1000");
        FruitDto fruitDto = DtoMapper.INSTANCE.toDto(apple);
        log.debug("Test => " + fruitDto.toString());
//        int a = 1/0;
//        throw new NoSuchElementException();
        this.hashOperations = stringRedisTemplate.opsForHash();

        final Long currentCount = stringRedisTemplate
                .opsForValue().increment("CHN:LIMIT:RATE:LOAN_LIMIT", 1);

        System.out.println(currentCount);

        hashOperations.put("CHN:LIMIT:INFO", "LOAN_LIMIT", "10");
        hashOperations.put("CHN:LIMIT:INFO", "LOAN_INTERVAL", "1");
        hashOperations.put("CHN:LIMIT:INFO", "LOAN_MSG", "Hello Redis!");

//        RedisTestObj redisTestObj = new RedisTestObj("1", "teady", 3000l);
//        redisTestObjRepository.save(redisTestObj);
//        System.out.println(redisTestObjRepository.findById("1").get().getUsername());
        return fruitDto;
    }
}
