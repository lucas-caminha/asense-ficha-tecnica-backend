package br.com.ftservice.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<List<Insumo>> getInsumos(){
		return ResponseEntity.ok(insumoService.getInsumos());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public ResponseEntity<Insumo> salvaInsumo(@RequestBody InsumoDTO dto) throws BusinessException {
		Insumo salvo = insumoService.salvaInsumo(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/atualiza")
	public ResponseEntity<Insumo> atualizaInsumo(@RequestBody InsumoDTO dto) {
		Insumo atualizado = insumoService.atualizaInsumo(dto);
		if (atualizado != null) {
			return ResponseEntity.accepted().body(atualizado);
		}
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/remove/{id}")
	public ResponseEntity<Insumo> deletaInsumo(@PathVariable String id) {
		Long idLong = Long.parseLong(id);
		Insumo deletado = insumoService.deletaInsumo(idLong);
		if (deletado != null) {
			return ResponseEntity.accepted().build();
		}
		return ResponseEntity.noContent().build();
	}
	
}
