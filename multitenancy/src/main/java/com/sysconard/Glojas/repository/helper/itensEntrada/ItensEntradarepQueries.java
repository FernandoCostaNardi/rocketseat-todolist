package com.sysconard.Glojas.repository.helper.itensEntrada;

import java.util.List;

import com.sysconard.Glojas.DTO.TrocasDetalhadasDTO;

public interface ItensEntradarepQueries {

	List<TrocasDetalhadasDTO> trocasDetalhadasDoDia_jab();
	
	List<TrocasDetalhadasDTO> trocasDetalhadasPorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal);
}
