package com.sysconard.Glojas.repository.helper.produto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sysconard.Glojas.DTO.CompraPesquisaRapidaDTO;
import com.sysconard.Glojas.DTO.ProdutoCadastradosDTO;
import com.sysconard.Glojas.model.Produto;
import com.sysconard.Glojas.repository.filter.ProdutoFilter;

public interface ProdutosQueries {

	public Page<Produto> filtrar(ProdutoFilter filtro, Pageable pageable);
	
	public List<ProdutoCadastradosDTO> totalDeProdutosCadastrados();
	
	public List<CompraPesquisaRapidaDTO> buscarDescricaoERefplu(String descricao);
	
	public Produto encontrarProdutoPeloRefplu(String refplu);
}
