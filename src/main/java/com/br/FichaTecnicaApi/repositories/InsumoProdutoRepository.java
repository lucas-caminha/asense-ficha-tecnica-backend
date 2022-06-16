package com.br.FichaTecnicaApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.FichaTecnicaApi.models.InsumoProduto;
import com.br.FichaTecnicaApi.models.InsumoProdutoID;

@Repository
public interface InsumoProdutoRepository extends JpaRepository<InsumoProduto, InsumoProdutoID>{

}
