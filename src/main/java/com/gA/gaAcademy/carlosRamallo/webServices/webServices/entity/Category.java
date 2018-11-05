package com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="category_seq_gen")	
	private int id;
	@Column
	private String name;
	
	public Category(){}
	
	public Category( String name) {
		super();		
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

}
