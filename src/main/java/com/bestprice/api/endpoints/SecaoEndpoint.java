package com.bestprice.api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
