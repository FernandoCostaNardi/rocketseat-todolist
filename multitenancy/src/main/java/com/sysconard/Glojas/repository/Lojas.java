package com.sysconard.Glojas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sysconard.Glojas.model.Loja;

@Repository
public interface Lojas extends JpaRepository<Loja, Long> {

	List<Loja> findByNomeContaining(String nome);
}
