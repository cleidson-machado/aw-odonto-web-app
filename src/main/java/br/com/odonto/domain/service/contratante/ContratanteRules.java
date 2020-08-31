package br.com.odonto.domain.service.contratante;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.odonto.domain.model.Contratante;

@Service
public class ContratanteRules implements ContratanteInterFace {

	@Autowired
	private ContratanteBasicService contratanteBasicService;

	@Override
	public List<Contratante> getAllContratantes() {
		// CRUD BASIC.... LISTAGEM
		return contratanteBasicService.getAllContratantes();
	}

	@Override
	public void saveContratante(Contratante contratante) {
		// CRUD BASIC
		this.contratanteBasicService.saveContratante(contratante);
	}

	@Override
	public void updateContratante(Contratante contratante) {
		// CRUD BASIC
		this.contratanteBasicService.updateContratante(contratante);
	}

	@Override
	public void deleteContratanteById(long codigo) {
		// CRUD BASIC
		this.contratanteBasicService.deleteContratanteById(codigo);
	}

	@Override
	public Contratante getContratanteById(long codigo) {
		// CRUD BASIC
		return contratanteBasicService.getContratanteById(codigo);
	}
	
	@Override
	public Optional<Contratante> getOne(long codigo) {
		return contratanteBasicService.getOne(codigo);
	}

}
