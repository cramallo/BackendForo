package com.gA.gaAcademy.carlosRamallo.webServices.webServices.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity.Reply;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity.Topic;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.expceptions.ResourceNotFoundException;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.repository.ReplyRepository;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.repository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	ReplyRepository replyRepository;	
	
	//Topic

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
	
	public int deleteTopic(int id) {		
		topicRepository.deleteById(id);		
		return id;		
	}
	

	public int logicDeleteTopic(int id) {
		// TODO Auto-generated method stub}
		Topic t=topicRepository.findById(id).get();
		if(!t.isDeleted()) {
			t.delete();
			topicRepository.save(t);
			return t.getId();
		}else {
			return 0;
		}		
	}
	
	
	//Reply

	public Reply createReply(int idTopic, Reply reply) {
		return topicRepository.findById(idTopic).map(topic->{
			reply.setTopic(topic);
			return replyRepository.save(reply);
		}).orElseThrow(()->new ResourceNotFoundException("No se encontro el topic"));				
	}

	
	public Reply getReply(int id) {
		return replyRepository.findById(id).get();
	}
	

	public int deleteReply(int idReply) {		
		replyRepository.deleteById(idReply);
		return idReply;
	}	
	
}
