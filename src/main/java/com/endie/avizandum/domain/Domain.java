package com.endie.avizandum.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Domain {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private long ownerId;
	
	@Transient
	private List<District> districts;

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

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

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public Domain(long id, String name, long ownerId, List<District> districts) {
		super();
		this.id = id;
		this.name = name;
		this.ownerId = ownerId;
		this.districts = districts;
	}

	public Domain( String name, long ownerId, List<District> districts) {
		super();
		this.name = name;
		this.ownerId = ownerId;
		this.districts = districts;
	}
}
