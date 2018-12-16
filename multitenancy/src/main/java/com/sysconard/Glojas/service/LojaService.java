package com.sysconard.Glojas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysconard.Glojas.model.Loja;
import com.sysconard.Glojas.repository.Lojas;
import com.sysconard.Glojas.repository.filter.LojaFilter;

@Service
public class LojaService {

	// ************ Injeta Repositorio de Cargos **************
	@Autowired
	private Lojas lojas;

	// ************ Pesquisa Banco pelo nome no bando de dados **************
	public List<Loja> filtrar(LojaFilter lojaFilter) {
		String nome = lojaFilter.getNome() == null ? "%" : lojaFilter.getNome();
		return lojas.findByNomeContaining(nome);
	}
}
