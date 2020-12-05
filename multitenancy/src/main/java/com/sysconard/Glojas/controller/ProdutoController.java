package com.sysconard.Glojas.controller;

import java.util.List;

import com.sysconard.Glojas.service.vendas.produtos.ProdutosVendidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.sysconard.Glojas.DTO.CompraPesquisaRapidaDTO;
import com.sysconard.Glojas.repository.Produtos;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/produtos/{tenantid}/produtos")
public class ProdutoController {

	@Autowired
	private Produtos produtos;

	@Autowired
	private ProdutosVendidosService produtosVendidosService;

	@GetMapping
	public ModelAndView pesquisar(@PathVariable String tenantid) {
		ModelAndView mv = new ModelAndView("produto/PesquisaProduto");
		mv.addObject("totalProdutos", produtos.totalDeProdutosCadastrados());
		mv.addObject("tenant", tenantid);
		return mv;
	}

	@GetMapping("/vendas")
	public ModelAndView vendaProduto(@PathVariable String tenantid) {
		ModelAndView mv = new ModelAndView("produto/VendaProduto");
		mv.addObject("produtosVendidosHoje", produtosVendidosService.totalQuantidadeProdutoVendaDia());
		mv.addObject("produtosVendidosMes", produtosVendidosService.totalQuantidadeProdutoVendaMes());
		mv.addObject("produtosVendidosAno", produtosVendidosService.totalQuantidadeProdutoVendaAno());
		return mv;
	}
	
//	@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
//	public @ResponseBody List<CompraPesquisaRapidaDTO> pesquisa(String descricao) {
//		validarTamanhoNome(descricao);
//		return produtos.buscarDescricaoERefplu(descricao);
//	}

	private void validarTamanhoNome(String descricao) {
		if (StringUtils.isEmpty(descricao) || descricao.length() <3) {
			throw new IllegalArgumentException();
		}
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Void> tratarIllegalArgumentException(IllegalArgumentException e) {
		return ResponseEntity.badRequest().build();
	}
}
