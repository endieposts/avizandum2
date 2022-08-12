package com.endie.avizandum.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Terrain {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String Name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Terrain(long id, String name) {
		super();
		this.id = id;
		Name = name;
	}
	
	public Terrain () {
		
	}
}
