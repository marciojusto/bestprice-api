package com.bestprice.api.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Mercado implements Serializable {

	private static final long serialVersionUID = -4946821622586116516L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_MERCADO")
	private Long id;
	
	@NotBlank
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
				name = "MERCADO_SECAO",
				joinColumns = @JoinColumn(referencedColumnName = "ID_MERCADO"),
				inverseJoinColumns = @JoinColumn(referencedColumnName = "ID_SECAO"))
	private Collection<Secao> secoes;

	public Mercado() {}
	
	public Mercado(@NotBlank String nome, Collection<Secao> secoes) {
		this.nome = nome;
		this.secoes = secoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Secao> getSecoes() {
		return secoes;
	}

	public void setSecoes(Collection<Secao> secoes) {
		this.secoes = secoes;
	}
	
}
