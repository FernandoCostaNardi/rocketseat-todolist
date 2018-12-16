package com.sysconard.Glojas.repository.helper.funcionario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sysconard.Glojas.model.Funcionario;
import com.sysconard.Glojas.repository.filter.FuncionarioFilter;

public interface FuncionariosQueries {

	public Page<Funcionario> filtrar(FuncionarioFilter filtro, Pageable pageable);
}
