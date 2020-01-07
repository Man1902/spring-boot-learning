package com.learning.redis.repository;


import com.learning.redis.model.User;

public interface UserRepository extends RedisBaseRepository<Long, User> {
}
