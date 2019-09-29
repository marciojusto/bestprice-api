package com.bestprice.api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}
	
//	@GetMapping(path = "/{id}")
//	public ReponseEntity<?> getSecaoById(@PathVariable("id") Long id) {
//		Secao secao = repository.findById(id).get();
//		return new ResponseEntity<>(secao, HttpStatus.OK);
//	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Secao secao) {
		Secao secaoSalva = repository.save(secao);
		return new ResponseEntity<>(secaoSalva, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestBody Secao secao) {
		repository.delete(secao);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Secao secao) {
		repository.save(secao);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
