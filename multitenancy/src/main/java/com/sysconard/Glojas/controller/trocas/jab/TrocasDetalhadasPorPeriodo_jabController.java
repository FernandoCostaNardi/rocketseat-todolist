package com.sysconard.Glojas.controller.trocas.jab;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.repository.Documentos;
import com.sysconard.Glojas.repository.ItensEntradarep;

@Controller
@RequestMapping("/trocas/{tenantid}/trocasDetalhadasPorPeriodo_{tenantid}")
public class TrocasDetalhadasPorPeriodo_jabController {

	@Autowired
	private ItensEntradarep itensEntradarep;
	
	@Autowired
	private Documentos documentos;
	
	@GetMapping
	public ModelAndView pesquisar(@PathVariable String tenantid) {

		ModelAndView mv = new ModelAndView("/trocas" + "/" + tenantid + "/trocasDetalhadasPorPeriodo_"  + tenantid);
		mv.addObject("tenant", tenantid);
		return mv;
	}
	
	@GetMapping("/pesquisaDetalhada_{tenantid}")
	public ModelAndView pesquisarEntreDatas(@PathVariable String tenantid,
			@RequestParam("dataEmissaoInicial") String dataEmissaoInicial,
			@RequestParam("dataEmissaoFinal") String dataEmissaoFinal) throws ParseException {
		
		ModelAndView mv = new ModelAndView("/trocas" + "/" + tenantid + "/trocasDetalhadasPorPeriodo_"  + tenantid);
		mv.addObject("trocasDetalhadasPorPeriodo", itensEntradarep.trocasDetalhadasPorPeriodo_jab(dataEmissaoInicial, dataEmissaoFinal));
		mv.addObject("somaTrocaPorPeriodo", documentos.SomatotalDeVendasPorPeriodo_jab(dataEmissaoInicial, dataEmissaoFinal));
		mv.addObject("tenant", tenantid);
		return mv;
	}
}
