package br.com.ftservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ftservice.model.Insumo;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Long> {
	

}
