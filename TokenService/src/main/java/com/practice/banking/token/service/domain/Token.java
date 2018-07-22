package com.practice.banking.token.service.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection= "token")
public class Token {
	
	@JsonProperty("token")
	private String id;
	
	@JsonIgnore
	private Date issuedAt;
	
	@JsonIgnore
	private Date expiresAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(Date issuedAt) {
		this.issuedAt = issuedAt;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	@Override
	public String toString() {
		return "Token [id=" + id + ", issuedAt=" + issuedAt + ", expiresAt=" + expiresAt + "]";
	}
	
	
}
