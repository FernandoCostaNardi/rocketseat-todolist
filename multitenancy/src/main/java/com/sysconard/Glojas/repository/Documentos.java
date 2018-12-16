package com.sysconard.Glojas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sysconard.Glojas.DTO.VendasTotaisDTO;
import com.sysconard.Glojas.model.Documento;
import com.sysconard.Glojas.repository.helper.documento.DocumentosQueries;

public interface Documentos extends JpaRepository<Documento, Long>, DocumentosQueries{

}
