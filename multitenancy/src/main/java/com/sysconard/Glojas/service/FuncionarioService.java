package com.sysconard.Glojas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysconard.Glojas.repository.Funcionarios;

@Service
public class FuncionarioService {

	// ************ Injeta Repositorio de Cargos **************
	@Autowired
	private Funcionarios funcionarios;

	// ************ Pesquisa Marca pela Descrição no bando de dados
	// **************
}
