package com.bestprice.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bestprice.api.entities.Secao;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SecaoRepositoryTest {

	@Autowired
	private SecaoRepository repository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void listAllShouldPresentAllData() {
		List<Secao> findAll = (List<Secao>) repository.findAll();
		Assertions.assertThat(findAll).isNotEmpty();
	}
	
	@Test
	public void createShouldPersistData() {
		Secao secao = new Secao("Congelados");
		repository.save(secao);
		assertThat(secao.getId()).isNotNull();
		assertThat(secao.getNome()).isEqualTo("Congelados");
	}
	
	@Test
	public void deleteShouldRemoveData() {
		Secao secao = new Secao("Congelados");
		repository.save(secao);
		repository.delete(secao);
		assertThat(repository.findByNome(secao.getNome())).isEmpty();
	}
	
	@Test
	public void updateShouldChangeAndPersistData() {
		Secao secao = new Secao("Congelados");
		repository.save(secao);
		secao.setNome("Mercearia");
		repository.save(secao);
		assertThat(secao.getId()).isNotNull();
		assertThat(secao.getNome()).isEqualTo("Mercearia");
	}
}
