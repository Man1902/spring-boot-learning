package com.learning.redis.repository;


import com.learning.redis.model.User;

import java.util.Map;

public interface RedisBaseRepository<F, V> {
    void save(V value);

    User findById(F field);

    Map<F, V> findAll();

    void update(V value);

    void delete(F field);
}
