package com.sysconard.Glojas.controller.vendas.jab;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.repository.Documentos;

@Controller
@RequestMapping("/vendas/{tenantid}/margemContribuicaoGrupoPorPeriodo_{tenantid}")
public class VendasMargemContribuicaoGrupo_jabController {

	@Autowired
	private Documentos documentos;
	
	@GetMapping
	public ModelAndView pesquisar(@PathVariable String tenantid) {

		ModelAndView mv = new ModelAndView("/vendas" + "/" + tenantid + "/margemContribuicaoGrupoPorPeriodo_"  + tenantid);
		mv.addObject("tenant", tenantid);
		return mv;
	}

	@GetMapping("/pesquisa_{tenantid}")
	public ModelAndView pesquisarEntreDatas(@PathVariable String tenantid,
			@RequestParam("dataEmissaoInicial") String dataEmissaoInicial,
			@RequestParam("dataEmissaoFinal") String dataEmissaoFinal) throws ParseException {

		ModelAndView mv = new ModelAndView("/vendas" + "/" + tenantid + "/margemContribuicaoGrupoPorPeriodo_"  + tenantid);
		mv.addObject("margemContribucaoGrupoPorPeriodo", documentos.SomaContribuicaoGrupoPorPeriodo_jab(dataEmissaoInicial, dataEmissaoFinal));
		mv.addObject("totalPorPeriodo", documentos.ValorTotalContribuicaoMarcaPorPeriodo_jab(dataEmissaoInicial, dataEmissaoFinal));
		mv.addObject("tenant", tenantid);
		return mv;
	}
}
