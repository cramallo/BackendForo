package com.gA.gaAcademy.carlosRamallo.webServices.webServices.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity.Reply;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity.Topic;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.request.TopicRequest;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.response.TopicResponse;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.response.ReplyResponse;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.service.TopicService;


@CrossOrigin
@RestController
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
	
	@PostMapping("/topic")
	public ResponseEntity<?>createTopic(@RequestBody TopicRequest inputTopic) {		
		Topic topic = topicService.createTopic(inputTopic);	
		return new ResponseEntity<TopicResponse>(new TopicResponse(topic),HttpStatus.ACCEPTED);
	}
	
	@CrossOrigin
	@GetMapping("/topic/{id}")
	public Topic getTopic(@PathVariable int id) {
		return topicService.getTopic(id);		
	}	
	
	@GetMapping("/topic")
	public List<Topic> getTopics(){		
		return topicService.getTopics();
	}	
	
	@PutMapping("/topic/{id}")
	public ResponseEntity<?> setTopic(@PathVariable int id,@RequestBody TopicRequest topic){	
		return new ResponseEntity<TopicResponse>(new TopicResponse(topicService.updateTopic(id, topic)),HttpStatus.ACCEPTED);		
	}
	
	@DeleteMapping("/topic/{id}")
	public ResponseEntity<?> deleteTopic(@PathVariable int id){		
		int idBorrado=topicService.deleteTopic(id);		
		String m="El topic: "+idBorrado+" fue borrado";		
		return new ResponseEntity<String>(m,HttpStatus.OK);
	}
	
	@DeleteMapping("/topic/logic/{id}")
	public ResponseEntity<?> logicDeleteTopic(@PathVariable int id){		
		String msg;
		
		int borrado=topicService.logicDeleteTopic(id);		
		if(borrado>0) {
			msg="El topic fue borrado";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}else {
			msg="No se pudo borrar";
			return new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
		}		
	}	
	
	
	//Replies
	
	@GetMapping("topic/reply/{id}")
	public ReplyResponse getReply(@PathVariable int id) {
		return topicService.getReply(id);
	}
	
	@GetMapping("/topic/{idTopic}/reply")
	public List<Reply> getReplies(@PathVariable int idTopic){
		return topicService.getReplies(idTopic);
	}
	
	@PostMapping("/topic/{idTopic}/reply")
	public ResponseEntity<ReplyResponse> createReply(@PathVariable int idTopic,@RequestBody Reply reply) {	
		Topic t= topicService.getTopic(idTopic);
		reply.setTopic(t);
		topicService.createReply(reply);
		return new ResponseEntity<ReplyResponse>(new ReplyResponse(reply),HttpStatus.ACCEPTED);
	}	
	
	/*@PostMapping("/topic/{idTopic}/reply")
	public Reply createReply(@PathVariable int idTopic,@RequestBody Reply reply) 
		return topicService.createReply(reply);
	}	*/
	
	@DeleteMapping("/topic/reply/{idReply}")		
	public ResponseEntity<?> deleteReplay(@PathVariable int idReply){
		int borrado=topicService.deleteReply(idReply);
		String m="El reply: "+idReply+" fue borrado";
		return new ResponseEntity<String>(m,HttpStatus.OK);
	}	
	
	@DeleteMapping("/topic/{idTopic}/reply")
	public void deleteReplies(@PathVariable int idTopic){
		topicService.deleteAllReplies(idTopic);
	}
	
	
			
}
