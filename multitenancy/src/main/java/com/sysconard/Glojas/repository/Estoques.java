package com.sysconard.Glojas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sysconard.Glojas.model.Estoque;
import com.sysconard.Glojas.repository.helper.estoque.EstoquesQueries;

public interface Estoques extends JpaRepository<Estoque, Long>, EstoquesQueries {

}
