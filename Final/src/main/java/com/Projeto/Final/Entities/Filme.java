package com.Projeto.Final.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tpFilme")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Para informar que é PK e AI
	private int id;
	
	@Column(name="nomeFilme")
	private String nomeFilme;
	
	@Column(name="horaFilme")
	private int horaFilme;
	
	@Column(name="minutoFilme")
	private int minutoFilme;
	
	@Column(name="idSala")
	private int idSala;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public int getHoraFilme() {
		return horaFilme;
	}

	public void setHoraFilme(int horaFilme) {
		this.horaFilme = horaFilme;
	}

	public int getMinutoFilme() {
		return minutoFilme;
	}

	public void setMinutoFilme(int minutoFilme) {
		this.minutoFilme = minutoFilme;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	
}