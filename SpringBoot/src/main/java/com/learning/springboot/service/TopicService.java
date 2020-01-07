package com.learning.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springboot.dao.TopicRepository;
import com.learning.springboot.vo.Topic;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(int topicId) {
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
