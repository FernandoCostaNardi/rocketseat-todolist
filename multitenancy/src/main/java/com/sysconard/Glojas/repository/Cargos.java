package com.sysconard.Glojas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sysconard.Glojas.model.Cargo;

public interface Cargos extends JpaRepository<Cargo, Long> {

	List<Cargo> findByDescricaoContaining(String descricao);

}
