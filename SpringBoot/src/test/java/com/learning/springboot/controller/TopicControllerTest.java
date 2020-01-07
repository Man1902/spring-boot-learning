package com.learning.springboot.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.learning.springboot.SpringBootDemoApp;
import com.learning.springboot.service.TopicService;
import com.learning.springboot.vo.Topic;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemoApp.class)
@AutoConfigureMockMvc
public class TopicControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TopicService topicService;

	Topic mockTopic = new Topic(1, "Topic1", "Topic1 Desc");

	String topicJSonStr = "{\"id\":1,\"name\":\"Topic1\",\"description\":\"Topic1 Desc\"}";

	@Test
	public void getTopicTest() throws Exception {
		Mockito.when(topicService.getTopic(Mockito.anyInt())).thenReturn(mockTopic);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/topics/1").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(mvcResult.getResponse());

		JSONAssert.assertEquals(topicJSonStr, mvcResult.getResponse().getContentAsString(), false);
		assertEquals(200, mvcResult.getResponse().getStatus());

	}

}
