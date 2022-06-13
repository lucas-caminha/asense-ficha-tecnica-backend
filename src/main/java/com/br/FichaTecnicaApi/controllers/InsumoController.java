package com.br.FichaTecnicaApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.FichaTecnicaApi.exception.BusinessException;
import com.br.FichaTecnicaApi.models.Insumo;
import com.br.FichaTecnicaApi.models.dto.InsumoDTO;
import com.br.FichaTecnicaApi.service.InsumoService;

@RestController
@RequestMapping("/insumo")
public class InsumoController {

	@Autowired
	private InsumoService insumoService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/todos")
	public List<Insumo> getInsumos(){
		return insumoService.getInsumos();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public Insumo salvaInsumo(@RequestBody InsumoDTO dto) throws BusinessException {
		return insumoService.salvaInsumo(dto);
	}
	
}
