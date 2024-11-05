package com.sysconard.Glojas.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.DTO.VendasTotaisDTO;
import com.sysconard.Glojas.repository.Comissoes;

@Controller
@RequestMapping("/{tenantid}/vendasTotaisPorPeriodoPorLoja")
public class VendasTotaisPorPeriodoPorLojaController {

	@Autowired
	private Comissoes comissoes;

	@GetMapping
	public ModelAndView pesquisar(@PathVariable String tenantid) {

		ModelAndView mv = new ModelAndView("/vendas/vendasTotaisPorPeriodoPorLoja");
		mv.addObject("tenant", tenantid);
		return mv;
	}

	@GetMapping("/pesquisa")
	public ModelAndView pesquisarEntreDatas(@PathVariable String tenantid,
			@RequestParam("dataEmissaoInicial") String dataEmissaoInicial,
			@RequestParam("dataEmissaoFinal") String dataEmissaoFinal) throws ParseException {

		List<VendasTotaisDTO> vendasPorPeriodoporLoja = comissoes.totalDeVendasPorPeriodoPorLoja(dataEmissaoInicial,
				dataEmissaoFinal);

		ModelAndView mv = new ModelAndView("/vendas/vendasTotaisPorPeriodoPorLoja");
		mv.addObject("vendasPorPeriodoporLoja", vendasPorPeriodoporLoja);
		mv.addObject("totalVendasPorPeriodol", 	comissoes.valorTotalVendasPorPeriodo(dataEmissaoInicial, dataEmissaoFinal));
		mv.addObject("tenant", tenantid);
		return mv;
	}
}