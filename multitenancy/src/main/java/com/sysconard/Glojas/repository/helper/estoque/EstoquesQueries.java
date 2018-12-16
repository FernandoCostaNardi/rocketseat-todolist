package com.sysconard.Glojas.repository.helper.estoque;

import java.math.BigDecimal;
import java.util.List;

import com.sysconard.Glojas.DTO.EstoqueDTO;

public interface EstoquesQueries {

	public List<Object[]> buscaEstoqueDasLojas();

	public List<EstoqueDTO> buscaEstoque();
	
	public BigDecimal estoqueDoProdutoPelaRefplu(String refplu);

}
