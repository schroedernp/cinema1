package com.Projeto.Final.Repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Projeto.Final.Entities.ClienteSalaFilme;

@Repository
public interface ClienteSalaFilmeRepository extends JpaRepository<ClienteSalaFilme, Integer> {


	@Query(value= "SELECT * FROM tpClienteSalaFilme  WHERE idCliente  = ?1 ", nativeQuery=true) 
	List<ClienteSalaFilme> buscarCliente(int id);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO tpClienteSalaFilme (idSala, idFilme, idCliente) VALUES (?1, ?2, ?3)", nativeQuery = true)
	void validaCliente(int idSala, int idFilme, int idCliente);
}
