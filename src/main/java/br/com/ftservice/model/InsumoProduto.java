package br.com.ftservice.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "insumo_produto")
public class InsumoProduto {

	@JsonIgnore
	@EmbeddedId
	private InsumoProdutoID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("insumoId")
	private Insumo insumo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("produtoId")
	private Produto produto;
	
	private Integer quantidade;
	
	public InsumoProduto(Insumo insumo, Produto produto, Integer quantidade) {
		this.insumo = insumo;
		this.produto = produto;
		this.quantidade = quantidade;
		this.id = new InsumoProdutoID(insumo.getId(), produto.getId());
	}
	
	public InsumoProduto() {}
	
	public InsumoProdutoID getId() {
		return id;
	}
	public void setId(InsumoProdutoID id) {
		this.id = id;
	}
	public Long getInsumo() {
		return id.getInsumoId();
	}
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	@JsonIgnore
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
