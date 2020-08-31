package br.com.odonto.domain.service.contratante;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.odonto.domain.dao.repository.ContratanteDaoRepository;
import br.com.odonto.domain.model.Contratante;

@Service
public class ContratanteBasicService implements ContratanteInterFace {
	

	@Autowired
	private ContratanteDaoRepository contratanteDaoRepository;

	
	@Override
	public List<Contratante> getAllContratantes() {
		return contratanteDaoRepository.findAll();
	}

	
	@Override
	public void saveContratante(Contratante contratante) {
		this.contratanteDaoRepository.save(contratante);
	}

	
	@Override
	public void updateContratante(Contratante contratante) {
		this.contratanteDaoRepository.save(contratante);		
	}

	
	@Override
	public void deleteContratanteById(long codigo) {
		this.contratanteDaoRepository.deleteById(codigo);
	}

	
	@Override
	public Contratante getContratanteById(long codigo) {
		
		Optional<Contratante> optional = contratanteDaoRepository.findById(codigo);
		Contratante contratante = null;
		
		if(optional.isPresent()) {
			contratante = optional.get();
		}else {
			throw new RuntimeException("Cliente não encontrado para o Id :: " + codigo);
		}
		
		return contratante;
	}
	
	
	@Override
	public Optional<Contratante> getOne(long codigo) {
		return contratanteDaoRepository.findById(codigo);
	}
	
	
	//METODO CRIADO SOMENTE AQUI... NAO ESTA NA INTERFACE!
	public Page<Contratante> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection, String keyword) {
		Sort sort = sortDirection.equalsIgnoreCase(
				  Sort.Direction.ASC.name()) ? 
				  Sort.by(sortField).ascending() :
				  Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo -1, pageSize, sort);
		
		if (keyword != null) {
			return this.contratanteDaoRepository.findAll(keyword, pageable);			
		}
		
		return this.contratanteDaoRepository.findAll(pageable);
	}
	
	
	
	
	
	
	
	
	
	
	
	


}
