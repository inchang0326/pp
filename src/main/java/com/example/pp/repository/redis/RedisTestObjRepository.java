package com.example.pp.repository.redis;

import com.example.pp.entity.RedisTestObj;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RedisTestObjRepository extends CrudRepository<RedisTestObj, String> {
    Optional<RedisTestObj> findByUsername(String username);
    Optional<RedisTestObj> findById(String id);
}
