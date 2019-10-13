package com.bestprice.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bestprice.api.entities.Mercado;

public interface MercadoRepository extends JpaRepository<Mercado, Long> {

}
