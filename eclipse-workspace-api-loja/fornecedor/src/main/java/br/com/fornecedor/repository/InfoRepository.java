package br.com.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;


import br.com.fornecedor.model.InfoFornecedor;


public interface InfoRepository extends CrudRepository<InfoFornecedor, Long> {
    
	InfoFornecedor findByEstado(String estado);
}
