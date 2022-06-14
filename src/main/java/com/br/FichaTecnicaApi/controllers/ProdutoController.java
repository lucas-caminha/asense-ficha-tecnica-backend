package com.br.FichaTecnicaApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.FichaTecnicaApi.dto.ProdutoDTO;
import com.br.FichaTecnicaApi.exception.BusinessException;
import com.br.FichaTecnicaApi.models.Produto;
import com.br.FichaTecnicaApi.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/todos")
	public List<Produto> getProdutos(){
		return produtoService.getProdutos();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public Produto salvaInsumo(@RequestBody ProdutoDTO dto) throws BusinessException {
		return produtoService.salvaProduto(dto);
	}

}
