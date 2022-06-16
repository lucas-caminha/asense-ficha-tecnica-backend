package br.com.ftservice.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ftservice.exception.BusinessException;
import br.com.ftservice.model.Produto;
import br.com.ftservice.model.dto.ProdutoDTO;
import br.com.ftservice.service.ProdutoService;

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
	
	@RequestMapping(method = RequestMethod.POST, value = "/custo/menor")
	public List<Produto> custoMenor(@RequestBody BigDecimal custo) throws BusinessException {
		return produtoService.buscaProdutoPorCustoMenorQue(custo);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/custo/maior")
	public List<Produto> custoMaior(@RequestBody BigDecimal custo) throws BusinessException {
		return produtoService.buscaProdutoPorCustoMaiorQue(custo);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/lucro/menor")
	public List<Produto> lucroMenor(@RequestBody BigDecimal lucro) throws BusinessException {
		return produtoService.buscaProdutoPorCustoMenorQue(lucro);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/lucro/maior")
	public List<Produto> lucroMaior(@RequestBody BigDecimal lucro) throws BusinessException {
		return produtoService.buscaProdutoPorCustoMaiorQue(lucro);
	}

	
}
