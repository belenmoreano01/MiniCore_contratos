package com.ingweb.model;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="contract")

public class contract {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contract_id;
	
	@JoinColumn(name = "client_fk", referencedColumnName = "idClient",insertable=false,updatable=false)
    @ManyToOne
    private client client;
	
	
	@Column(name = "client_fk")
	private Integer idClient;
	
	
	@Column(name = "amount")
	private Float amount;
	
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "fecha")
	private Date fecha;


	public Integer getContract_id() {
		return contract_id;
	}


	public void setContract_id(Integer contract_id) {
		this.contract_id = contract_id;
	}


	public client getClient() {
		return client;
	}


	public void setClient(client client) {
		this.client = client;
	}


	public Integer getIdClient() {
		return idClient;
	}


	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}


	public Float getAmount() {
		return amount;
	}


	public void setAmount(Float amount) {
		this.amount = amount;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public contract(Integer contract_id, com.ingweb.model.client client, Integer idClient, Float amount, Date fecha) {
		super();
		this.contract_id = contract_id;
		this.client = client;
		this.idClient = idClient;
		this.amount = amount;
		this.fecha = fecha;
	}


	public contract() {
		super();
	}
	
	
	

}
