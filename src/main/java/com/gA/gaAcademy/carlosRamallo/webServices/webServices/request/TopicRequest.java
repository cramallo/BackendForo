package com.gA.gaAcademy.carlosRamallo.webServices.webServices.request;

import java.util.Date;
import java.util.List;

import com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity.Reply;

public class TopicRequest {
	
	private String title;
	private int author;
	private String description;
	private Date datepost;
	private List<Reply> replies;
	
	public TopicRequest(String title, int author, String description, Date datepost, List<Reply> replies) {
		super();
		this.title = title;
		this.author = author;
		this.description = description;
		this.datepost = datepost;
		this.replies = replies;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatepost() {
		return datepost;
	}

	public void setDatepost(Date datepost) {
		this.datepost = datepost;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}	
	
}
