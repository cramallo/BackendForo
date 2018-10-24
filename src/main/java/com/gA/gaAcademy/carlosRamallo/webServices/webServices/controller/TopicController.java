package com.gA.gaAcademy.carlosRamallo.webServices.webServices.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity.Topic;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
	@PostMapping("/topic")
	public Topic createTopic(@RequestBody Topic inputTopic) {		
		Topic returnTopic = topicService.createTopic(inputTopic);
		return returnTopic;
	}
	
	@GetMapping("/topic")
	public Topic getTopic(@RequestParam int id) {
		Topic topic=topicService.getTopic(id);
		return topic;
	}
	
}
