package br.com.ftservice.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ftservice.exception.BusinessException;
import br.com.ftservice.model.Insumo;
import br.com.ftservice.model.Produto;
import br.com.ftservice.model.dto.InsumoDTO;
import br.com.ftservice.model.dto.ProdutoDTO;
import br.com.ftservice.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private InsumoProdutoService insumoProdutoService;
	@Autowired
	private InsumoService insumoService;
	
	public List<Produto> getProdutos(){
		return produtoRepository.findAll();
	}
	
	public Optional<Produto> findProdutoById(Long id) {
		return produtoRepository.findById(id);
	}
	
	public Produto salvaProduto(ProdutoDTO dto) {
		Produto produto = dto.toEntity();	
		produto.setCustoProduto(somaCusto(dto.getInsumos()));
		produto.setLucroProduto(somaLucro(produto.getCustoProduto(), produto.getVlVenda()));
		Produto salvo = produtoRepository.save(produto);
		insumoProdutoService.saveInsumoProduto(salvo, dto.getInsumos());
		if (salvo != null) {
			return salvo;
		}
		throw new BusinessException("Houve um erro ao salvar novo produto.");
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
	
	private BigDecimal somaCusto(List<InsumoDTO> list) {
		BigDecimal somaCusto = new BigDecimal("0.0");
		for(InsumoDTO dto : list) {
			Optional<Insumo> find = insumoService.findInsumoById(dto.getId());
			if (find.isPresent()) {
				somaCusto = somaCusto.add(find.get().getVlCompra());
			}	
		}
		return somaCusto;
	}
	
	private BigDecimal somaLucro(BigDecimal custo, BigDecimal vlVenda) {
		return vlVenda.subtract(custo);
	}

	public Produto deletaProduto(Long id) {
		Optional<Produto> finded = findProdutoById(id);
		if (finded.isPresent()) {
			produtoRepository.deleteById(id);
			return finded.get();
		}
		return null;
	}

	public Produto atualizaProduto(ProdutoDTO dto) {
		Optional<Produto> finded = findProdutoById(dto.getId());
		if (finded.isPresent()) {
			Produto produto = finded.get();
			produto.setNome(dto.getNome());
			produto.setVlVenda(dto.getVlVenda());
			return produto;
		}	
		return null;
	}
	

	
}
