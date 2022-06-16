package br.com.ftservice.model.dto;

import java.math.BigDecimal;

import br.com.ftservice.model.Insumo;
import br.com.ftservice.model.Medida;

public class InsumoDTO {
	
	private Long id;
	private String nome;
	private Integer quantidade;
	private BigDecimal vlCompra;
	private Medida medida;
	
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
