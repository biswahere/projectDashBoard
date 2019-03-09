package com.techprimers.stock.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="quotes" ,catalog="stock")
public class Quote {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="quote")
	private String quote;
	


	public Quote() {
	 
	}
	
	

	public Quote(Long id,String userName, String quote) {
		super();
		this.id=id;
		this.userName = userName;
		this.quote = quote;
	}
	
	public Quote(String userName, String quote) {
		super();
		this.userName = userName;
		this.quote = quote;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	
	
	
}
