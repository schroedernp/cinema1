package com.Projeto.Final.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tpSala")
public class Sala {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Para informar que é PK e AI
	private int id;
	
	@Column(name="nomeSala")
	private String nomeSala;
	
	@Column(name="lotacaoAtual")
	private int lotacaoAtual;
	
	@Column(name="lotacaoMaxima")
	private int lotacaoMaxima;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeSala() {
		return nomeSala;
	}

	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}

	public int getLotacaoAtual() {
		return lotacaoAtual;
	}

	public void setLotacaoAtual(int lotacaoAtual) {
		this.lotacaoAtual = lotacaoAtual;
	}

	public int getLotacaoMaxima() {
		return lotacaoMaxima;
	}

	public void setLotacaoMaxima(int lotacaoMaxima) {
		this.lotacaoMaxima = lotacaoMaxima;
	}

}
