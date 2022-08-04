package com.endie.avizandum.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Domain {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String domainName;
	
	private long ownerId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public Domain(long id, String domainName, long ownerId) {
		super();
		this.id = id;
		this.domainName = domainName;
		this.ownerId = ownerId;
	}
}
