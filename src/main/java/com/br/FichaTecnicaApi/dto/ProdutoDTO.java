package com.br.FichaTecnicaApi.dto;

import java.math.BigDecimal;
import java.util.List;

import com.br.FichaTecnicaApi.models.Insumo;
import com.br.FichaTecnicaApi.models.Produto;

public class ProdutoDTO {
	
	private String nome;
	private BigDecimal vlVenda;
	private List<Insumo> insumos;
	
	public ProdutoDTO(String nome, BigDecimal vlVenda, List<Insumo> insumos) {
		this.nome = nome;
		this.vlVenda = vlVenda;
		this.insumos = insumos;
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

	public Produto toEntity() {	
		return new Produto(nome, vlVenda, insumos);
	}

}
