package com.sysconard.Glojas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.repository.Comissoes;

@Controller
@RequestMapping("/{tenantid}/vendasTotaisDoMesPorLoja")
public class VendasTotaisDoMesPorLojaController {

	@Autowired
	private Comissoes comissoes;

	@GetMapping
	public ModelAndView pesquisar(@PathVariable String tenantid) {
		ModelAndView mv = new ModelAndView("/vendas/vendasTotaisDoMesPorLoja");
		mv.addObject("vendasDoMesPorLoja", comissoes.totalDeVendasDoMesPorLoja());
		mv.addObject("vendasDoMesAtual", comissoes.valorTotalVendasDoMesAtual());
		mv.addObject("tenant", tenantid);
		return mv;
	}
}
