package com.br.FichaTecnicaApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.FichaTecnicaApi.models.Insumo;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Long>{
}
