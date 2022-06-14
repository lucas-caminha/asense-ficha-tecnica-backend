package com.br.FichaTecnicaApi.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal vlVenda;
	@ManyToMany
	private List<Insumo> insumos;
	
	public Produto(String nome, BigDecimal vlVenda, List<Insumo> insumos) {
		this.nome = nome;
		this.vlVenda = vlVenda;
		this.insumos = insumos;
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
	public BigDecimal getVlVenda() {
		return vlVenda;
	}
	public void setVlVenda(BigDecimal vlVenda) {
		this.vlVenda = vlVenda;
	}
	public List<Insumo> getInsumos() {
		return insumos;
	}
	public void setInsumos(List<Insumo> insumos) {
		this.insumos = insumos;
	}
	
}
