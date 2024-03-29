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
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Mercado implements Serializable {

	private static final long serialVersionUID = -4946821622586116516L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MERCADO")
	private Long id;

	@NotBlank
	@Size(min = 4, max = 30)
	private String nome;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
				name = "MERCADO_SECAO", 
				joinColumns = @JoinColumn(name = "ID_MERCADO", referencedColumnName = "ID_MERCADO"), 
				inverseJoinColumns = @JoinColumn(name = "ID_SECAO", referencedColumnName = "ID_SECAO")
			  )
	private Collection<Secao> secoes;

	public Mercado() {
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mercado other = (Mercado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
