package br.com.ftservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ftservice.exception.BusinessException;
import br.com.ftservice.model.Insumo;
import br.com.ftservice.model.dto.InsumoDTO;
import br.com.ftservice.service.InsumoService;

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
