package com.Projeto.Final.RestControllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Projeto.Final.Entities.Cliente;
import com.Projeto.Final.Entities.ClienteSalaFilme;
import com.Projeto.Final.Entities.Sala;
import com.Projeto.Final.Repositories.ClienteRepository;
import com.Projeto.Final.Repositories.ClienteSalaFilmeRepository;




@RestController
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepo;
	@Autowired
	ClienteSalaFilmeRepository clienteSalaFilmeRepo;
	
	@RequestMapping(value = "/addCliente", method = RequestMethod.POST )
	public String addSala(String nome, String numCliente) {
		Cliente c = new Cliente(); 
		c.setNome(nome);
		c.setNumCliente(numCliente);
		List <Cliente> lstCliente = clienteRepo.buscarCliente(numCliente);
		
		if(lstCliente.size() == 0) {
			
			clienteRepo.save(c);
		}else {
			return "Registro não pode ser realizado";
		}
		
		return "Registo Realizado";

	}
	
	@RequestMapping(value = "/removeCliente", method = RequestMethod.POST )
	public String removeSala(String numCliente) {
		
		int id = clienteRepo.buscaId(numCliente);
		List <ClienteSalaFilme> lstCliente = clienteSalaFilmeRepo.buscarCliente(id); //Ve se o cliente ja viu filmes
		
		if(lstCliente.size() == 0) {
			
			clienteRepo.deleteById(id);
			return "Registo Apagado com Sucesso!";
		}else {
			return "Não foi possível apagar o registo!";
		}
		
		


	}
}
