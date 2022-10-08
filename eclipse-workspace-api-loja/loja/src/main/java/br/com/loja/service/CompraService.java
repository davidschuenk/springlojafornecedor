package br.com.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.loja.controller.dto.CompraDTO;
import br.com.loja.dto.InfoFornecedorDTO;

@Service
public class CompraService {
	@Autowired
	private RestTemplate client;
	
	public void realizaCompra(CompraDTO compra) {
		
		//esse metodo server para ver o endereco do fornecedor de acordo com o estado da compra
		
		ResponseEntity<InfoFornecedorDTO> exchange = client.exchange( 
				
     //endereco de pesquisa do fornecedor + compraDTO.getendereco.getEstado
				"http://fornecedor/info/" + compra.getEndereco().getEstado(),
				
			//este httpmetod da o get no fornecedor
				HttpMethod.GET, null,InfoFornecedorDTO.class);
		
			//imprimimos o endereco do fornecedor
		System.out.println(exchange.getBody().getEndereco()); 
	}
}
