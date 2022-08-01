package com.Projeto.Final.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tpClienteSalaFilme")
public class ClienteSalaFilme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Para informar que é PK e AI
	private int id;
	
	@Column(name="idSala")
	private int idSala;
	
	@Column(name="idFilme")
	private int idFilme;
	
	@Column(name="idCliente")
	private int idCliente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
}
