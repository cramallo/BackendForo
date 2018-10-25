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
	
	public Topic getTopic(int id) {		
		return topicRepository.findById(id).get();		
	}	
	
	public List<Topic> getTopics(){
		return topicRepository.findAll();		
	}
	
	public Topic updateTopic(int id,Topic topic) {		
		Topic t=topicRepository.findById(id).get();
		if(topic.getAuthor()>0) {
			t.setAuthor(topic.getAuthor());
		}
		
		if(topic.getTitle()!=null) {
			t.setTitle(topic.getTitle());	
		}
			
		if(topic.getDescription()!=null) {
			t.setDescription(topic.getDescription());	
		}
		
		return topicRepository.save(t);		
	}
	
	/*public List<Reply> getReplies(int id){
		return replyRepository.findAllById(id);
	}*/
}
