package com.practice.banking.customer.service.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer {

	private Integer id;

	private boolean isBuseness;

	private String name;

	private String city;

	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isBuseness() {
		return isBuseness;
	}

	public void setBuseness(boolean isBuseness) {
		this.isBuseness = isBuseness;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
