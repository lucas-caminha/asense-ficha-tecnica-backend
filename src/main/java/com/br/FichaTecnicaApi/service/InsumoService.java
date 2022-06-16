package com.br.FichaTecnicaApi.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.FichaTecnicaApi.exception.BusinessException;
import com.br.FichaTecnicaApi.models.Insumo;
import com.br.FichaTecnicaApi.models.dto.InsumoDTO;
import com.br.FichaTecnicaApi.repositories.InsumoRepository;

@Service
public class InsumoService {

	@Autowired
	private InsumoRepository insumoRepository;
	
	public Insumo salvaInsumo(InsumoDTO dto) throws BusinessException {
		Insumo entity = dto.toEntity();
		entity.setCustoPorMedida(custoPorMedida(dto));	
		Insumo salvo = insumoRepository.save(entity);
		if (salvo != null) {
			return salvo;
		}
		throw new BusinessException("Houve um erro ao salvar novo insumo.");
	}
	
	public List<Insumo> getInsumos(){
		return insumoRepository.findAll();		
	}
	
	private BigDecimal  custoPorMedida(InsumoDTO dto) {
		//return new BigDecimal(dto.getVlCompra()).divide(dto.getQuantidade());
		return null;
	}
	
}
