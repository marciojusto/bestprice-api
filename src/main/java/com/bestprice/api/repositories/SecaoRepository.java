package com.bestprice.api.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bestprice.api.entities.Secao;

public interface SecaoRepository extends CrudRepository<Secao, Long> {

	List<Secao> findByNome(String nome);
	
	List<Secao> findByNomeIgnoreCaseContaining(String nome);
}
