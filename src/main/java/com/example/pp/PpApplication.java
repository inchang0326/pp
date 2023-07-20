package com.example.pp;

import com.example.pp.dto.FruitDto;
import com.example.pp.entity.Apple;
import com.example.pp.mapper.DtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class PpApplication {

    public static void main(String[] args) {
        SpringApplication.run(PpApplication.class, args);
    }

}
