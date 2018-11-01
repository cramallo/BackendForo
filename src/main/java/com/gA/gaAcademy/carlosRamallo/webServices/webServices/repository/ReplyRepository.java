package com.gA.gaAcademy.carlosRamallo.webServices.webServices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity.Reply;
import com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity.Topic;

@Repository
public interface ReplyRepository extends JpaRepository<Reply,Integer>{	
	
	Reply findByAuthor(int author);

	Optional<Topic> findByTopic(Topic topic);
	
}
