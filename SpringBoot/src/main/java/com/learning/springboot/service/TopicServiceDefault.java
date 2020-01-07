package com.learning.springboot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.learning.springboot.vo.Topic;

@Service
public class TopicServiceDefault {
	private Map<Integer, Topic> map = new HashMap<>();

	public TopicServiceDefault() {
		map.put(1, new Topic(1, "Spring Boot", "Spring Boot topic"));
		map.put(2, new Topic(2, "Hibernate", "Hibernate"));

	}

	public List<Topic> getAllTopics() {
		return new ArrayList<>(map.values());
	}

	public Topic getTopic(int topicId) {
		// return map.get(topicId);
		return map.entrySet().stream().filter(entry -> entry.getKey().equals(topicId)).map(entry -> entry.getValue())
				.findFirst().get();
	}
	
	public void addTopic(Topic topic){
		map.put(topic.getId(), topic);
	}
	
	public void updateTopic(Topic topic){
		map.put(topic.getId(), topic);
	}
	
	public void deleteTopic(int topicId) {
		map.remove(topicId);
	}

}
