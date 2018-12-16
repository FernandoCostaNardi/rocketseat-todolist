package com.sysconard.Glojas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sysconard.Glojas.model.ItensEntrada;
import com.sysconard.Glojas.repository.helper.itensEntrada.ItensEntradarepQueries;

public interface ItensEntradarep extends JpaRepository<ItensEntrada, Long>, ItensEntradarepQueries{

}
