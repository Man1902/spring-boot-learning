package com.learning.springboot.service;

import com.learning.springboot.dao.TopicRepository;
import com.learning.springboot.vo.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    @Cacheable(value = "topicsCache", key = "#topicId")
    public Topic getTopic(int topicId) {
        System.out.println("Retrieving Topic from database with topicId : " + topicId);
        Optional<Topic> topic = topicRepository.findById(topicId);
        return topic.isPresent() ? topic.get() : null;
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(int topicId) {
        topicRepository.deleteById(topicId);
    }

}
