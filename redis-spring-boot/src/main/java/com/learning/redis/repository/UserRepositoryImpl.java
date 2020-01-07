package com.learning.redis.repository;


import com.learning.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private RedisTemplate<String, User> redisTemplate;
    private HashOperations hashOperations;
    @Autowired
    public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
        hashOperations.put("user", user.getId(), user);
    }

    @Override
    public User findById(Long id) {
        return (User) hashOperations.get("user", id);
    }

    @Override
    public Map<Long, User> findAll() {
        return hashOperations.entries("user");
    }

    @Override
    public void update(User user) {
        this.save(user);
    }

    @Override
    public void delete(Long id) {
        hashOperations.delete("user", id);
    }
}
