package com.bestprice.api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestprice.api.entities.Secao;
import com.bestprice.api.error.ResourceNotFoundException;
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
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getSecaoById(@PathVariable("id") Long id) {
		verifyIsSecaoExists(id);
		return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/findByNome/{name}")
	public ResponseEntity<?> findByNome(@PathVariable("nome") String nome) {
		return new ResponseEntity<>(repository.findByNome(nome), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Secao secao) {
		return new ResponseEntity<>(repository.save(secao), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIsSecaoExists(id);
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Secao secao) {
		verifyIsSecaoExists(secao.getId());
		repository.save(secao);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void verifyIsSecaoExists(Long id) {
		if(!repository.findById(id).isPresent()) {
			throw new ResourceNotFoundException("Não foi encontrada Seção com o id: "+ id);
		}
	}
}
