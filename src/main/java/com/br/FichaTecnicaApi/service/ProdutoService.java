package com.br.FichaTecnicaApi.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.FichaTecnicaApi.exception.BusinessException;
import com.br.FichaTecnicaApi.models.Insumo;
import com.br.FichaTecnicaApi.models.InsumoProduto;
import com.br.FichaTecnicaApi.models.Produto;
import com.br.FichaTecnicaApi.models.dto.InsumoDTO;
import com.br.FichaTecnicaApi.models.dto.ProdutoDTO;
import com.br.FichaTecnicaApi.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto salvaProduto(ProdutoDTO dto) {
		Produto produto = dto.toEntity();
		produto.setInsumos(setInsumoProduto(produto, dto.getInsumos()));
		
		
		
		//BigDecimal somaCusto = somaCusto(dto.getInsumos());
		//produto.setCustoProduto(somaCusto);
		
		Produto salvo = produtoRepository.save(produto);
		if (salvo != null) {
			return salvo;
		}
		throw new BusinessException("Houve um erro ao salvar novo produto.");
	}
	
	public List<Produto> getProdutos(){
		return produtoRepository.findAll();
	}
	
	public List<Produto> buscaProdutoPorCustoMenorQue(BigDecimal custo){
		return produtoRepository.findByCustoProdutoLessThan(custo);
	}
	
	public List<Produto> buscaProdutoPorCustoMaiorQue(BigDecimal custo){
		return produtoRepository.findByCustoProdutoGreaterThan(custo);
	}
	
	public List<Produto> buscaProdutoPorLucroMenorQue(BigDecimal lucro){
		return produtoRepository.findByCustoProdutoLessThan(lucro);
	}
	
	public List<Produto> buscaProdutoPorLucroMaiorQue(BigDecimal lucro){
		return produtoRepository.findByCustoProdutoGreaterThan(lucro);
	}
	
	private BigDecimal somaCusto(List<Insumo> insumos) {
		BigDecimal somaCusto = new BigDecimal("0.0");
		for(Insumo i : insumos) {
			somaCusto.add(i.getVlCompra());
		}
		return somaCusto;
	}
	
	@SuppressWarnings("unused")
	private BigDecimal somaLucro(List<Insumo> insumos) {
		return null;
	}
	
	private List<InsumoProduto> setInsumoProduto(Produto produto, List<InsumoDTO> insumos) {
		List<InsumoProduto> insumoProdutoList = new ArrayList<InsumoProduto>();
		for(InsumoDTO dto : insumos) {
			insumoProdutoList.add(new InsumoProduto(new Insumo(dto.getId(), dto.getQuantidade()), produto, dto.getQuantidade()));
		}	
		return insumoProdutoList;
	}
	
}
