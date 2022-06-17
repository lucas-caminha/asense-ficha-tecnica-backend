package br.com.ftservice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import br.com.ftservice.model.Medida;
import br.com.ftservice.model.dto.InsumoDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class InsumoControllerTest {

	@Autowired
	private MockMvc mockMvc;	
	@Autowired
	private Gson gson;
	
	@Test
	@Rollback(value = true)
	void deveRetornar201createdAoCadastrarInsumo() throws JsonProcessingException, Exception {		
		InsumoDTO insumoDTO = new InsumoDTO();
		insumoDTO.setNome("Uva");
		insumoDTO.setQuantidade(500);
		insumoDTO.setVlCompra(new BigDecimal("10.52"));
		insumoDTO.setMedida(Medida.GRAMA);
		
		String json = gson.toJson(insumoDTO);
		
		mockMvc.perform(post("/insumo/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(status().isCreated());			
	} 
	
}
