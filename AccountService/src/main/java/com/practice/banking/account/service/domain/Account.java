package com.practice.banking.account.service.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account")
public class Account {
	
	private Integer id;

	private Integer customerID;

	private String type;

	private Integer balance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerID;
	}

	public void setCustomerId(Integer customerID) {
		this.customerID = customerID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}
}
