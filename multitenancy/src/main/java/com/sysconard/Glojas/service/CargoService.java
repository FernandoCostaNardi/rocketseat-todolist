package com.sysconard.Glojas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysconard.Glojas.model.Cargo;
import com.sysconard.Glojas.repository.Cargos;
import com.sysconard.Glojas.repository.filter.CargoFilter;

@Service
public class CargoService {

	// ************ Injeta Repositorio de Cargos **************
	@Autowired
	private Cargos cargos;

	// ************ Pesquisa Banco pelo nome no bando de dados **************
	public List<Cargo> filtrar(CargoFilter cargoFilter) {
		String descricao = cargoFilter.getDescricao() == null ? "%" : cargoFilter.getDescricao();
		return cargos.findByDescricaoContaining(descricao);
	}
}
