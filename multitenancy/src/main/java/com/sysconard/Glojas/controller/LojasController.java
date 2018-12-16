package com.sysconard.Glojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.model.Loja;
import com.sysconard.Glojas.repository.filter.LojaFilter;
import com.sysconard.Glojas.service.LojaService;

@Controller
@RequestMapping("/lojas/{tenantid}/lojas")
public class LojasController {

	@Autowired
	private LojaService lojaService;

	// ************ Pesquisa Loja **************
	@GetMapping
	public ModelAndView pesquisar(@ModelAttribute("lojaFiltro") LojaFilter lojaFiltro, @PathVariable String tenantid) {
		List<Loja> todasLojas = lojaService.filtrar(lojaFiltro);

		ModelAndView mv = new ModelAndView("loja/PesquisaLoja");
		mv.addObject("lojas", todasLojas);
		mv.addObject("tenant", tenantid);
		return mv;
	}
}
