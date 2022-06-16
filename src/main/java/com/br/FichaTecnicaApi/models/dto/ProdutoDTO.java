package com.br.FichaTecnicaApi.models.dto;

import java.math.BigDecimal;

import com.br.FichaTecnicaApi.models.Produto;

public class ProdutoDTO {
	
	private String nome;
	private BigDecimal vlVenda;
	
	public ProdutoDTO(String nome, BigDecimal vlVenda) {
		this.nome = nome;
		this.vlVenda = vlVenda;
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


	public Produto toEntity() {	
		return new Produto(nome, vlVenda);
	}

}
