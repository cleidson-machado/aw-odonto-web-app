package br.com.odonto.domain.service.contratante;

import java.util.List;
import java.util.Optional;

import br.com.odonto.domain.model.Contratante;

public interface ContratanteInterFace {
	
	//LISTA_TODOS
	public List<Contratante> getAllContratantes();
	
	//SALVA
	public void saveContratante(Contratante contratante);
	
	//ATUALIZA
	public void updateContratante(Contratante contratante);
	
	//DELETA
	public void deleteContratanteById(long codigo);
	
	//SELECIONA_PELO_ID
	public Contratante getContratanteById(long codigo);
	
	//SELECIONA_PELO_ID QUE SELECIONA UMA CONTRATANTE USANDO O OPTIONAL DO JAVA UTIL
	public Optional<Contratante> getOne(long codigo);

}
