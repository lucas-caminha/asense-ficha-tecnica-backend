package br.com.ftservice.model.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.ftservice.model.Produto;

public class ProdutoDTO {
	
	private String nome;
	private BigDecimal vlVenda;
	private List<InsumoDTO> insumos;
	
	public ProdutoDTO(String nome, BigDecimal vlVenda, List<InsumoDTO> insumos) {
		this.nome = nome;
		this.vlVenda = vlVenda;
		this.insumos = insumos;
	}
	
	public ProdutoDTO() {}

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
	public List<InsumoDTO> getInsumos() {
		return insumos;
	}
	public void setInsumos(List<InsumoDTO> insumos) {
		this.insumos = insumos;
	}

	public Produto toEntity() {	
		return new Produto(nome, vlVenda);
	}

}
