package com.sysconard.Glojas.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.DTO.VendasTotaisDetalhadasDTO;
import com.sysconard.Glojas.repository.Comissoes;

@Controller
@RequestMapping("/{tenantid}/vendasDetalhadasPorPeriodo")
public class VendasDetalhadasPorPeriodoController {

	@Autowired
	private Comissoes comissoes;

	@GetMapping
	public ModelAndView pesquisar(@PathVariable String tenantid) {

		ModelAndView mv = new ModelAndView("/vendas/vendasDetalhadasPorLoja");
		mv.addObject("tenant", tenantid);
		return mv;
	}

	@GetMapping("/pesquisa")
	public ModelAndView pesquisar(@PathVariable String tenantid,
			@RequestParam("dataEmissaoInicial") String dataEmissaoInicial,
			@RequestParam("dataEmissaoFinal") String dataEmissaoFinal) throws ParseException {

		List<VendasTotaisDetalhadasDTO> vendasDetalhadasPorPeriodo = comissoes
				.vendasDetalhadasPorPeriodo(dataEmissaoInicial, dataEmissaoFinal);

		ModelAndView mv = new ModelAndView("/vendas/vendasDetalhadasPorLoja");
		mv.addObject("vendasDetalhadasPorPeriodo", vendasDetalhadasPorPeriodo);
		mv.addObject("totalVendasPorPeriodol",
				comissoes.valorTotalVendasPorPeriodo(dataEmissaoInicial, dataEmissaoFinal));
		mv.addObject("tenant", tenantid);
		return mv;
	}
}
