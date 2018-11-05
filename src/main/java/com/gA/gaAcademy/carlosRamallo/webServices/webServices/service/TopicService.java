package com.gA.gaAcademy.carlosRamallo.webServices.webServices.service;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity.Reply;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity.Topic;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.expceptions.ResourceNotFoundException;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.repository.ReplyRepository;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.repository.TopicRepository;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.request.TopicRequest;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.response.ReplyResponse;

@Service
public class TopicService {
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	ReplyRepository replyRepository;	
	
	//Topic

	public Topic createTopic(TopicRequest topic) {
		Topic t=new Topic(topic);
		return topicRepository.save(t);			
	}
	
	public Topic getTopic(int id) {		
		return topicRepository.findById(id).get();		
	}	
	
	public List<Topic> getTopics(){
		return topicRepository.findAll();		
	}
	
	public Topic updateTopic(int id,TopicRequest topic) {		
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
	
	public Reply createReply(Reply reply) {
		reply.setDatePost(new Date());
		return replyRepository.save(reply);
	}
	
	public List<Reply> getReplies(int id){
		return topicRepository.findById(id).get().getReplies();
	}
	
	public ReplyResponse getReply(int id) {
		Reply reply= replyRepository.findById(id).get();
		ReplyResponse replyResponse=new ReplyResponse(reply);
		return replyResponse;
	}
	
	public void deleteAllReplies(int id) {
		Topic t=topicRepository.findById(id).get();
		t.deleteReplies();
		topicRepository.save(t);
	}
	
	public Reply updateReplyByID(int id,Reply reply) throws NoSuchElementException{
		
		Reply toUpdate = replyRepository.findById(id).get();
		
		if(reply.getdescription()!=null){
			toUpdate.setdescription(reply.getdescription());
		}
		replyRepository.save(toUpdate);
		return toUpdate;
	}

	public int deleteReply(int idReply) {		
		replyRepository.deleteById(idReply);
		return idReply;
	}	
	
}
