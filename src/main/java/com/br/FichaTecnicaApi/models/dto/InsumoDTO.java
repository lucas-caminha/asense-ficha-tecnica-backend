package com.br.FichaTecnicaApi.models.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import com.br.FichaTecnicaApi.models.Insumo;
import com.br.FichaTecnicaApi.models.Medida;

public class InsumoDTO {
	
	@NotBlank
	private String nome;
	@NotBlank
	private Integer quantidade;
	private BigDecimal vlCompra;
	private Medida medida;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getVlCompra() {
		return vlCompra;
	}
	public void setVlCompra(BigDecimal vlCompra) {
		this.vlCompra = vlCompra;
	}
	public Medida getMedida() {
		return medida;
	}
	public void setMedida(Medida medida) {
		this.medida = medida;
	}
	
	public Insumo toEntity() {
		return new Insumo(this.nome, this.quantidade, this.vlCompra, this.medida);
	}
}
