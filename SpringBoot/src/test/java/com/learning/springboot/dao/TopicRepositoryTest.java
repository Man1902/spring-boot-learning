package com.learning.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.springboot.vo.Topic;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TopicRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private TopicRepository topicRepository;

	@Test
	public void testFindByName() {
		entityManager.persist(new Topic("Topic1", "Topic1Desc"));
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		Assert.assertEquals(1, topics.size());
	}
}
