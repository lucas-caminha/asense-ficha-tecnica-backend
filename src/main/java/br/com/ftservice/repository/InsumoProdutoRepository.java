package br.com.ftservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ftservice.model.InsumoProduto;
import br.com.ftservice.model.InsumoProdutoID;

@Repository
public interface InsumoProdutoRepository extends JpaRepository<InsumoProduto, InsumoProdutoID>{

}
