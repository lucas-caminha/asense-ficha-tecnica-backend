package com.br.FichaTecnicaApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.FichaTecnicaApi.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
