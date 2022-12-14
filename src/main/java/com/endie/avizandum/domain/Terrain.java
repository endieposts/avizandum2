package com.endie.avizandum.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Entity
public class Terrain {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Terrain(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Terrain () {
		
	}

	public Terrain(String name) {
		this.name = name;
	}
}
