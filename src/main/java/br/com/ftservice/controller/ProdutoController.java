package br.com.ftservice.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Produto>> getProdutos(){
		return ResponseEntity.ok(produtoService.getProdutos());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public ResponseEntity<Produto> salvaInsumo(@RequestBody ProdutoDTO dto) throws BusinessException {
		Produto salvo = produtoService.salvaProduto(dto);
		return ResponseEntity.ok(salvo);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/atualiza")
	public ResponseEntity<Produto> atualizaInsumo(@RequestBody ProdutoDTO dto) throws BusinessException {
		Produto atualizado = produtoService.atualizaProduto(dto);
		if (atualizado != null) {
			return ResponseEntity.accepted().body(atualizado);
		}
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/remove")
	public ResponseEntity<Object> removeInsumo(@RequestBody String id) throws BusinessException {
		Long idLong = Long.parseLong(id);
		Produto deletado = produtoService.deletaProduto(idLong);
		if (deletado != null) {
			return ResponseEntity.accepted().build();
		}
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/custo/menor")
	public ResponseEntity<List<Produto>> custoMenor(@RequestBody BigDecimal custo) throws BusinessException {
		return ResponseEntity.ok(produtoService.buscaProdutoPorCustoMenorQue(custo));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/custo/maior")
	public ResponseEntity<List<Produto>> custoMaior(@RequestBody BigDecimal custo) throws BusinessException {
		return ResponseEntity.ok(produtoService.buscaProdutoPorCustoMaiorQue(custo));
	}

	@RequestMapping(method = RequestMethod.POST, value = "/lucro/menor")
	public ResponseEntity<List<Produto>> lucroMenor(@RequestBody BigDecimal lucro) throws BusinessException {
		return ResponseEntity.ok(produtoService.buscaProdutoPorCustoMenorQue(lucro));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/lucro/maior")
	public ResponseEntity<List<Produto>> lucroMaior(@RequestBody BigDecimal lucro) throws BusinessException {
		return ResponseEntity.ok(produtoService.buscaProdutoPorCustoMaiorQue(lucro));
	}

}
