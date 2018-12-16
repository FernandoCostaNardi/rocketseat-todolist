package com.sysconard.Glojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.DTO.EstoqueDTO;
import com.sysconard.Glojas.repository.Estoques;

@Controller
@RequestMapping("/estoque/{tenantid}/estoque")
public class EstoqueController {

	@Autowired
	private Estoques estoques;

	// ************ Pesquisa Estoque **************
	@GetMapping
	public ModelAndView pesquisar(@PathVariable String tenantid) {

		List<EstoqueDTO> todoEstoque = estoques.buscaEstoque();

		ModelAndView mv = new ModelAndView("estoque/PesquisaEstoque_" + tenantid);
		mv.addObject("estoques", todoEstoque);
		mv.addObject("tenant", tenantid);
		return mv;
	}

}
