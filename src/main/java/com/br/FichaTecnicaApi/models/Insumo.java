package com.br.FichaTecnicaApi.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Insumo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer quantidade;
	private BigDecimal vlCompra;
	private BigDecimal custoPorMedida;
	private Medida medida;
	private LocalDate criadoEm;
	
	 @OneToMany(mappedBy = "insumo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<InsumoProduto> produtos = new ArrayList<>();
	
	public Insumo(String nome, Integer quantidade, BigDecimal vlCompra, Medida medida) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.vlCompra = vlCompra;
		this.medida = medida;
	}
	public Insumo(Long id, Integer quantidade) {
		super();
		this.id = id;
		this.quantidade = quantidade;
	}
	
	public Insumo() {}
	
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
	public BigDecimal getCustoPorMedida() {
		return custoPorMedida;
	}
	public void setCustoPorMedida(BigDecimal custoPorMedida) {
		this.custoPorMedida = custoPorMedida;
	}	
	public List<InsumoProduto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<InsumoProduto> produtos) {
		this.produtos = produtos;
	}
	public LocalDate getCriadoEm() {
		return criadoEm;
	}
	public void setCriadoEm(LocalDate criadoEm) {
		this.criadoEm = criadoEm;
	}

	@Override
	public String toString() {
		return "Insumo [id=" + id + ", nome=" + nome + ", quantidade=" + quantidade + ", vlCompra=" + vlCompra
				+ ", custoPorMedida=" + custoPorMedida + ", medida=" + medida + "]";
	}

}
