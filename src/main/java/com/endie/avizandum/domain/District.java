package com.endie.avizandum.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class District {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="terrain_id", insertable = false, updatable = false)
	private Terrain terrain;
	
	@Column(name="terrain_id")
	private long terrainId;
	
	private String name;
	
	@Transient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="domain_id", insertable = false, updatable = false)
	private Domain domain; 

	@Column(name="domain_id")
	private long domainId; 
	
	public long getTerrainId() {
		return terrainId;
	}

	public void setTerrainId(long terrainId) {
		this.terrainId = terrainId;
	}
	
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

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public District(long id, Terrain terrain, String name, Domain domain) {
		super();
		this.id = id;
		this.terrain = terrain;
		this.name = name;
		this.domain = domain;
	}
}
