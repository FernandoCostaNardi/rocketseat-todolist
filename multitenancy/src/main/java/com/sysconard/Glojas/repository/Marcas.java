package com.sysconard.Glojas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sysconard.Glojas.model.Marca;

@Repository
public interface Marcas extends JpaRepository<Marca, Long> {

	List<Marca> findByDescricaoContaining(String descricao);

	List<Marca> findAllByOrderByDescricaoAsc();
}
