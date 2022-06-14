package com.br.FichaTecnicaApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.FichaTecnicaApi.dto.ProdutoDTO;
import com.br.FichaTecnicaApi.exception.BusinessException;
import com.br.FichaTecnicaApi.models.Produto;
import com.br.FichaTecnicaApi.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto salvaProduto(ProdutoDTO dto) {
		Produto salvo = produtoRepository.save(dto.toEntity());
		if (salvo != null) {
			return salvo;
		}
		throw new BusinessException("Houve um erro ao salvar novo produto.");
	}
	
	public List<Produto> getProdutos(){
		return produtoRepository.findAll();
	}
}
