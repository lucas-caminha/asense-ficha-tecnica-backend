package br.com.ftservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InsumoProdutoID implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "insumo_id")
	private Long insumoId;
	@Column(name = "produto_id")
	private Long produtoId;
	
	public InsumoProdutoID() {}

	public InsumoProdutoID(Long insumoId, Long produtoId) {
		this.insumoId = insumoId;
		this.produtoId = produtoId;
	}

	public Long getInsumoId() {
		return insumoId;
	}
	public void setInsumoId(Long insumoId) {
		this.insumoId = insumoId;
	}
	public Long getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}
	
}
