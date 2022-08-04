package com.endie.avizandum.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class District {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private long terrainId;
	
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="domain")
	private Domain domain; 

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTerrainId() {
		return terrainId;
	}

	public void setTerrainId(long terrainId) {
		this.terrainId = terrainId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public District(long id, long terrainId, String name, Domain domain) {
		super();
		this.id = id;
		this.terrainId = terrainId;
		this.name = name;
		this.domain = domain;
	}
}
