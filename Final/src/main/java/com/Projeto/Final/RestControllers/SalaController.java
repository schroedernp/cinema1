package com.Projeto.Final.RestControllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Projeto.Final.Entities.Sala;
import com.Projeto.Final.Repositories.SalaRepository;


@RestController
public class SalaController {
	
	@Autowired
	SalaRepository salaRepo;
	
	
	
	@RequestMapping(value = "/addSala", method = RequestMethod.POST )
	public String addSala(String nomeSala, int lotacaoAtual, int lotacaoMaxima) {
		
		Sala s = new Sala(); 
		s.setNomeSala(nomeSala);
		s.setLotacaoAtual(lotacaoAtual);
		s.setLotacaoMaxima(lotacaoMaxima);
		
		List <Sala> lstSala = salaRepo.buscarSala(nomeSala);
		if(lstSala.size() == 0) {	
			salaRepo.save(s);
			return "Registo Realizado";
		}else {
			return "Registro não pode ser realizado";
		}
	}
	
	@RequestMapping(value = "/atualizaLotAtual", method = RequestMethod.PUT)
	public String atualizaLotAtual(int idSala) {
		
		int lotacaoAtual = salaRepo.buscaLotacaoAtual(idSala);
		int novaLot = lotacaoAtual + 1;
		salaRepo.atualizaLotAtual(novaLot, idSala);
		return "A lotação atual da sala foi atualizada";
	}
	
	
	@RequestMapping(value = "/atualizaLotMaxima", method = RequestMethod.PUT)
	public String atualizaLotMaxima(int idSala, int lotacaoMaxima) {
		salaRepo.atualizaLotMaxima(lotacaoMaxima, idSala); 
		return "A lotação máxima da sala atualizado com sucesso";
	}
	
	
}
