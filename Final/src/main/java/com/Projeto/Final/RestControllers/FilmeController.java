package com.Projeto.Final.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Projeto.Final.Entities.Filme;
import com.Projeto.Final.Repositories.FilmeRepository;

@RestController
public class FilmeController {
	@Autowired
	FilmeRepository filmeRepo;
	
	@RequestMapping(value = "/addFilme", method = RequestMethod.POST )
	public String addSala(String nomeFilme, int horaFilme, int minutoFilme, int idSala) {
		
		List <Filme> lstFilmebyNome = filmeRepo.buscarFilmebyNome(nomeFilme);
		List <Filme> lstFilmebySalabyHora = filmeRepo.buscarFilmebySalabyHora(idSala, horaFilme);
		
	
		if(lstFilmebyNome.size() == 0 && lstFilmebySalabyHora.size() == 0 ) {
			
			filmeRepo.inserirFilme(nomeFilme, horaFilme, minutoFilme, idSala);
			return "Filme adicionado na BD com sucesso.";
		}else {
			return "Registro não pode ser realizado. Filme já cadastrado ou sala ocupado no horário";
		}
	}
}
