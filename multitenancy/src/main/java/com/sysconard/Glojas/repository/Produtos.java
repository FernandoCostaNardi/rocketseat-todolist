package com.sysconard.Glojas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sysconard.Glojas.model.Produto;
import com.sysconard.Glojas.repository.helper.produto.ProdutosQueries;

@EnableJpaRepositories
public interface Produtos extends JpaRepository<Produto, Long>, ProdutosQueries {

	List<Produto> findByDescricaoContaining(String descricao);
	
}
