package br.com.odonto.domain.dao.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.odonto.domain.model.Contratante;

@Repository
public interface ContratanteDaoRepository extends JpaRepository<Contratante, Long> {
	
	@Query("SELECT c FROM Contratante c WHERE "
			+ "CONCAT(c.nome, ' ', c.sobreNome, ' ',  c.cpf, ' ', c.email1)"
			+ " LIKE %?1%")
	public Page<Contratante> findAll(String keyword, Pageable pageable);

}
