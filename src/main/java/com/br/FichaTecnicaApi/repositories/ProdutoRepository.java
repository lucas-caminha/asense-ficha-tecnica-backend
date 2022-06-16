package com.br.FichaTecnicaApi.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.FichaTecnicaApi.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List<Produto> findByNome(String nome); 
	
	public Optional<Produto> findById(Long id);
	
	public List<Produto> findByCustoProdutoLessThan(BigDecimal custoProduto);
	
	public List<Produto> findByCustoProdutoGreaterThan(BigDecimal custoProduto);
	
	public List<Produto> findByLucroProdutoLessThan(BigDecimal lucroProduto);
	
	public List<Produto> findByLucroProdutoGreaterThan(BigDecimal lucroProduto);

}
