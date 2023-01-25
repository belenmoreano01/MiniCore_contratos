package com.ingweb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="client")

public class client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private Integer idClient;
	@Column(name = "name")
	private String name;
	
	public client() {
		super();
	}
	public client(Integer idClient, String name) {
		super();
		this.idClient = idClient;
		this.name = name;
	}
	public Integer getIdClient() {
		return idClient;
	}
	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
}