package com.gA.gaAcademy.carlosRamallo.webServices.webServices.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity.Reply;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity.Topic;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.repository.ReplyRepository;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.repository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	ReplyRepository replyRepository;

	public Topic createTopic(Topic inputTopic) {
		
		Topic t=topicRepository.save(inputTopic);		
		return t;
	}
	
	public Optional<Topic> getTopic(int id) {		
		return topicRepository.findById(id);		
	}	
	
	public List<Topic> getTopics(){
		return topicRepository.findAll();		
	}
	
	/*public List<Reply> getReplies(int id){
		return replyRepository.findAllById(id);
	}*/
}
