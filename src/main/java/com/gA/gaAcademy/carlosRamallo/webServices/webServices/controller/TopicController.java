package com.gA.gaAcademy.carlosRamallo.webServices.webServices.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity.Reply;
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
	
	@GetMapping("/topic/{id}")
	public Topic getTopic(@PathVariable int id) {
		return topicService.getTopic(id);		
	}	
	
	@GetMapping("/topic")
	public List<Topic> getTopics(){		
		return topicService.getTopics();
	}	
	
	@PutMapping("/topic/{id}")
	public Topic setTopic(@PathVariable int id,@RequestBody Topic topic){			
		return topicService.updateTopic(id, topic);		
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
	
	
	@PostMapping("/topic/{idTopic}/reply")
	public Reply createReply(@PathVariable int idTopic,@RequestBody Reply reply) {			
		return topicService.createReply(idTopic,reply);
	}
	
			
}
