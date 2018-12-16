package com.sysconard.Glojas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sysconard.Glojas.model.Loja;
import com.sysconard.Glojas.model.Preco;
import com.sysconard.Glojas.repository.helper.preco.PrecosQueries;

@Repository
public interface Precos extends JpaRepository<Preco, Long>, PrecosQueries{

	String findByRefpluAndLoja(String refplu, Loja loja);
}
