package com.br.FichaTecnicaApi.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal vlVenda;
	private BigDecimal custoProduto;
	private BigDecimal lucroProduto;
	
	 @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<InsumoProduto> insumos = new ArrayList<>();
	
	public Produto(String nome, BigDecimal vlVenda) {
		this.nome = nome;
		this.vlVenda = vlVenda;
	}
	
	public Produto() {}
	
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
	public List<InsumoProduto> getInsumos() {
		return insumos;
	}
	public void setInsumos(List<InsumoProduto> insumos) {
		this.insumos = insumos;
	}
	public BigDecimal getCustoProduto() {
		return custoProduto;
	}
	public void setCustoProduto(BigDecimal custoProduto) {
		this.custoProduto = custoProduto;
	}
	public BigDecimal getLucroProduto() {
		return lucroProduto;
	}
	public void setLucroProduto(BigDecimal lucroProduto) {
		this.lucroProduto = lucroProduto;
	}

}
