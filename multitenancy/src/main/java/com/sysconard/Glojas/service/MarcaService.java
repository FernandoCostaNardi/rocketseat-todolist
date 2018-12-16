package com.sysconard.Glojas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysconard.Glojas.model.Marca;
import com.sysconard.Glojas.repository.Marcas;
import com.sysconard.Glojas.repository.filter.MarcaFilter;

@Service
public class MarcaService {

	// ************ Injeta Repositorio de Marcas **************
	@Autowired
	private Marcas marcas;

	// ************ Pesquisa Marca pela Descrição no bando de dados
	// **************
	public List<Marca> filtrar(MarcaFilter marcaFilter) {
		String descricao = marcaFilter.getDescricao() == null ? "%" : marcaFilter.getDescricao();
		return marcas.findByDescricaoContaining(descricao);
	}
}
