package br.com.odonto.app.controller.contratante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.odonto.domain.model.Contratante;
import br.com.odonto.domain.service.contratante.ContratanteRules;

@RestController
public class ContratanteControllerRest {
	
	@Autowired
	private ContratanteRules contratanteRules;
	
	//LISTAGEM BÁSICA COM RETORNO NO PARÃO DE API
	@RequestMapping(path="/contratantelistdata", method=RequestMethod.GET)
	public List<Contratante> getAllContratantes(){		
		return contratanteRules.getAllContratantes();
	}

}
