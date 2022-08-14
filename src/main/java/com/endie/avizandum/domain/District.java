package com.endie.avizandum.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "district")
public class District {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="terrain_id")
	private Long terrainId;
	
	private String name;
	
	public long getTerrainId() {
		return terrainId;
	}

	public void setTerrainId(Long terrainId) {
		this.terrainId = terrainId;
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

	public District(Long id, long terrainId, String name) {
		super();
		this.id = id;
		this.terrainId = terrainId;
		this.name = name;
	}
	
    public District(long terrainId, String name) {
        this.terrainId = terrainId;
        this.name = name;
    }
	
    public District() {

    }
}
