package com.learning.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.learning.springboot.vo.Topic;

public interface TopicRepository extends CrudRepository<Topic, Integer>{

}
