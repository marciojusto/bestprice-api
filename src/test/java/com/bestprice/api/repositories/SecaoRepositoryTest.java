package com.bestprice.api.repositories;

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
	
}
