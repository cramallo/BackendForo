package com.gA.gaAcademy.carlosRamallo.webServices.webServices.response;
import java.util.Date;

import com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity.Reply;

public class ReplyResponse {		
	
	private String description;
	private Date datePost;		
	
	public ReplyResponse(String description, Date datePost) {
		super();				
		this.description = description;
		this.datePost = datePost;
	}

	public ReplyResponse(Reply reply) {		
		this.description = reply.getdescription();
		this.datePost = reply.getDatePost();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatepost() {
		return datePost;
	}

	public void setDatepost(Date datepost) {
		this.datePost = datepost;
	}

}
