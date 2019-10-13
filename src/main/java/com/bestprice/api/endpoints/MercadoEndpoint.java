package com.bestprice.api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestprice.api.entities.Mercado;
import com.bestprice.api.repositories.MercadoRepository;

@RestController
@RequestMapping("mercados")
public class MercadoEndpoint {

	@Autowired
	private MercadoRepository repository;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Mercado mercado) {
		return new ResponseEntity<>(repository.save(mercado), HttpStatus.CREATED);
	}
}
