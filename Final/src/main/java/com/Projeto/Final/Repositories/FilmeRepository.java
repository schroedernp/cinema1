package com.Projeto.Final.Repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Projeto.Final.Entities.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {


	@Query(value= "SELECT * FROM tpFilme WHERE nomeFilme = ?1", nativeQuery=true) 
	List<Filme> buscarFilmebyNome(String nomeFilme);
	
	@Query(value= "SELECT * FROM tpFilme WHERE idSala = ?1 AND horaFilme= ?2", nativeQuery=true) 
	List<Filme> buscarFilmebySalabyHora(int idSala, int horaFilme);
	
	@Query(value= "SELECT id FROM tpFilme WHERE nomeFilme = ?1", nativeQuery=true) 
	Integer buscarIdFilme(String nomeFilme);
	
	@Query(value= "SELECT idSala FROM tpFilme WHERE nomeFilme = ?1", nativeQuery=true) 
	Integer buscarIdSala(String nomeFilme);
	

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO tpFilme (nomeFilme, horaFilme, minutoFilme, idSala) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
	void inserirFilme(String nomeFilme, int horaFilme, int minutoFilme, int idSala);
}
