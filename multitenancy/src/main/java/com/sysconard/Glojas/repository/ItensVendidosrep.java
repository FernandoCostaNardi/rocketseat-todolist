package com.sysconard.Glojas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sysconard.Glojas.model.ItensVendidos;
import com.sysconard.Glojas.repository.helper.ItensVendidos.ItensVendidosrepQueries;

public interface ItensVendidosrep extends JpaRepository<ItensVendidos, Long>, ItensVendidosrepQueries  {

}
