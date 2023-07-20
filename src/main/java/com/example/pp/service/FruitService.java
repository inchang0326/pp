package com.example.pp.service;

import com.example.pp.dto.FruitDto;
import com.example.pp.entity.Apple;
import com.example.pp.mapper.DtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FruitService {
    public String getFruit() {
        Apple apple = new Apple("apple", "1000");
        FruitDto fruitDto = DtoMapper.INSTANCE.toDto(apple);
        log.debug("Test => " + fruitDto.toString());
        return fruitDto.toString();
    }
}
