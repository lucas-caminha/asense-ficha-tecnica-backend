package br.com.ftservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ftservice.model.Insumo;
import br.com.ftservice.model.InsumoProduto;
import br.com.ftservice.model.Produto;
import br.com.ftservice.model.dto.InsumoDTO;
import br.com.ftservice.repository.InsumoProdutoRepository;

@Service
public class InsumoProdutoService {
	
	@Autowired
	private InsumoProdutoRepository insumoProdutoRepository;
	
	public List<InsumoProduto> saveInsumoProduto(Produto produto, List<InsumoDTO> insumos) {
		List<InsumoProduto> insumoProdutoList = new ArrayList<InsumoProduto>();
		for(InsumoDTO dto : insumos) {
			InsumoProduto saved = insumoProdutoRepository.save(new InsumoProduto(new Insumo(dto.getId(), dto.getQuantidade()), produto, dto.getQuantidade()));
			insumoProdutoList.add(saved);
		}	
		return insumoProdutoList;
	}

}
