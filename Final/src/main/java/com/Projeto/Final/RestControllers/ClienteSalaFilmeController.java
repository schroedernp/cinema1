package com.Projeto.Final.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Projeto.Final.Entities.Filme;
import com.Projeto.Final.Repositories.ClienteRepository;
import com.Projeto.Final.Repositories.ClienteSalaFilmeRepository;
import com.Projeto.Final.Repositories.FilmeRepository;
import com.Projeto.Final.Repositories.SalaRepository;

@RestController
public class ClienteSalaFilmeController {
	@Autowired
	ClienteRepository clienteRepo;
	@Autowired
	ClienteSalaFilmeRepository clienteSalaFilmeRepo;
	@Autowired
	FilmeRepository filmeRepo;
	@Autowired
	SalaRepository salaRepo;


	
	@RequestMapping(value = "/validaEntrada", method = RequestMethod.POST )
	public String validaEntrada(String nomeFilme, String numCliente, int horaChegada, int minutoChegada) {
		
		List <Filme> lstFilme = filmeRepo.buscarFilmebyNome(nomeFilme);
		
		if (lstFilme.size() == 0) {
			return "O filme não está em cartaz!";
		} 
				Integer idSala = filmeRepo.buscarIdSala(nomeFilme);
				if(idSala == null) {
					return "Este filme não tem sala";
				}
				int lotMax = salaRepo.buscaLotacaoMax(idSala);
				int lotAtual = salaRepo.buscaLotacaoAtual(idSala);
				if(lotMax ==lotAtual) {
					return "A sala está lotada! Sinto muito!";
				}
				int horaChegadaConvert = (horaChegada * 60) + minutoChegada;
				for(Filme f : lstFilme) {
					int horaFilmeConvert = (f.getHoraFilme()* 60) + (f.getMinutoFilme());
					if (horaChegadaConvert >= horaFilmeConvert -30 && horaChegadaConvert <= horaFilmeConvert +15) {
						int novaLot = lotAtual +1;
						salaRepo.atualizaLotAtual(novaLot, idSala);
						Integer idFilme = filmeRepo.buscarIdFilme(nomeFilme);
						int idCliente = clienteRepo.buscaId(numCliente);
						clienteSalaFilmeRepo.validaCliente(idSala, idFilme, idCliente);
						return "Cliente pode Entrar";
					}else {
						if (horaChegadaConvert < horaFilmeConvert -30) {
							return "Cliente não pode entrar. Deve esperar";
						}else {
							return "Cliente não pode entrar. Já passou 15 minutos do Inicio";
							
						}
					}
				}
					
			
				return "O filme não existe em cartaz!";
								
			
	}
}

	



