package com.sysconard.Glojas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sysconard.Glojas.model.Comissao;
import com.sysconard.Glojas.repository.helper.comissao.ComissoesQueries;

public interface Comissoes extends JpaRepository<Comissao, Long>, ComissoesQueries {

}
