package br.com.ftservice.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ftservice.exception.BusinessException;
import br.com.ftservice.model.Insumo;
import br.com.ftservice.model.dto.InsumoDTO;
import br.com.ftservice.repository.InsumoRepository;

@Service
public class InsumoService {

	@Autowired
	private InsumoRepository insumoRepository;
	
	public Insumo salvaInsumo(InsumoDTO dto) throws BusinessException {
		Insumo entity = dto.toEntity();
		entity.setCriadoEm(LocalDate.now());
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
	
	public Optional<Insumo> findInsumoById(Long id) {
		return insumoRepository.findById(id);
	}
	
	public Insumo deletaInsumo(Long id) {
		Optional<Insumo> finded = findInsumoById(id);
		if (finded.isPresent()) {
			insumoRepository.deleteById(id);
			return finded.get();
		}
		return null;
	}
	
	public Insumo atualizaInsumo(InsumoDTO dto) {
		Optional<Insumo> finded = findInsumoById(dto.getId());
		if (finded.isPresent()) {
			Insumo insumo = finded.get();
			insumo.setNome(dto.getNome());
			insumo.setQuantidade(dto.getQuantidade());
			insumo.setVlCompra(dto.getVlCompra());
			insumo.setMedida(dto.getMedida());
			insumoRepository.save(insumo);
			return insumo;
		}	
		return null;
	}
	
	private BigDecimal custoPorMedida(InsumoDTO dto) {
		BigDecimal vlCompra = dto.getVlCompra();	
		return vlCompra.divide(new BigDecimal(dto.getQuantidade()));
	}


	
}
