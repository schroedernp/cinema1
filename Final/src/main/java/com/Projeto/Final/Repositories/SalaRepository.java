package com.Projeto.Final.Repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Projeto.Final.Entities.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {


	
	@Query(value= "SELECT * FROM tpSala WHERE nomeSala = ?1 ", nativeQuery=true) 
	List <Sala> buscarSala(String nomeSala);
	
	@Query(value= "SELECT lotacaoAtual FROM tpSala WHERE id = ?1 ", nativeQuery=true) 
	int buscaLotacaoAtual(int idSala);
	
	@Query(value= "SELECT lotacaoMaxima FROM tpSala WHERE id = ?1 ", nativeQuery=true) 
	int buscaLotacaoMax(int idSala);
	
	@Modifying //Este comando indica que esta query poderá mexer na base de dados...
	@Transactional
	@Query(value= "UPDATE tpSala SET lotacaoAtual = ?1 WHERE id = ?2 ", nativeQuery=true) 
	void atualizaLotAtual(int novaLot, int idSala);
	
	
	@Modifying //Este comando indica que esta query poderá mexer na base de dados...
	@Transactional
	@Query(value= "UPDATE tpSala SET lotacaoMaxima = ?1 WHERE id = ?2 ", nativeQuery=true) 
	void atualizaLotMaxima(int lotacaoMaxima, int idSala);
	
}
