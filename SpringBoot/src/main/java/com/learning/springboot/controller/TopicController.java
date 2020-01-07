package com.learning.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.service.TopicService;
import com.learning.springboot.service.TopicServiceDefault;
import com.learning.springboot.vo.Topic;

@RestController
public class TopicController {
	@Autowired
	private TopicServiceDefault topicServiceDefault;
	
	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		//return topicServiceDefault.getAllTopics();
		return topicService.getAllTopics();
	}

	@RequestMapping("/topics/{topicId}")
	public Topic getTopic(@PathVariable int topicId) {
		//return topicServiceDefault.getTopic(topicId);
		return topicService.getTopic(topicId);
	}

	@RequestMapping(value = "/topics", method = RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		//topicServiceDefault.addTopic(topic);
		topicService.addTopic(topic);
	}

	@RequestMapping(value = "/topics", method = RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic topic) {
		//topicServiceDefault.updateTopic(topic);
		topicService.updateTopic(topic);
	}

	@RequestMapping(value = "/topics/{topicId}", method = RequestMethod.DELETE)
	public void deleteTopic(@PathVariable int topicId) {
		//topicServiceDefault.deleteTopic(topicId);
		topicService.deleteTopic(topicId);
	}
}
