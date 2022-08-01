package com.Projeto.Final.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Projeto.Final.Entities.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


	@Query(value= "SELECT * FROM  tpCliente WHERE numCliente = ?1 ", nativeQuery=true) 
	List<Cliente> buscarCliente(String numCliente);
	

	@Query(value= "SELECT id FROM  tpCliente WHERE numCliente = ?1 ", nativeQuery=true) 
	int buscaId(String numCliente);
}
