package com.sysconard.Glojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.DTO.CompraGeralDTO;
import com.sysconard.Glojas.repository.ItensVendidosrep;
import com.sysconard.Glojas.util.DatasUtil;

@Controller
@RequestMapping("/compras/{tenantid}/compras")
public class ComprasController {

	@Autowired
	private ItensVendidosrep itensVendidosrep;
	
	DatasUtil datasUtil = new DatasUtil();

	// ************ Pesquisa Estoque **************
	@GetMapping
	public ModelAndView pesquisar(@PathVariable String tenantid) {
		
		List<CompraGeralDTO> todaVenda = itensVendidosrep.buscaComprasGeral();

		ModelAndView mv = new ModelAndView("compra/PesquisaCompraGeral_" + tenantid);
		mv.addObject("vendasGeral", todaVenda);
		mv.addObject("tenant", tenantid);
		return mv;
	}

	@GetMapping("/oex")
	public ModelAndView pesquisarOex(@PathVariable String tenantid) {

		List<CompraGeralDTO> todaVendaOex = itensVendidosrep.buscaComprasGeralOex();

		ModelAndView mv = new ModelAndView("compra/PesquisaCompraGeralOex_" + tenantid);
		mv.addObject("vendasGeral", todaVendaOex);
		mv.addObject("tenant", tenantid);
		return mv;
	}
}
