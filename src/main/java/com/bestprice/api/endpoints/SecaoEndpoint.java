package com.bestprice.api.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestprice.api.entities.Secao;
import com.bestprice.api.repositories.SecaoRepository;

@RestController
@RequestMapping("secoes")
public class SecaoEndpoint {

	@Autowired
	private SecaoRepository repository;
	
	@GetMapping
	public List<Secao> listAll() {
		return (List<Secao>) repository.findAll();
	}
}
