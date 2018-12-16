package com.sysconard.Glojas.controller.trocas.jab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.repository.Documentos;
import com.sysconard.Glojas.repository.ItensEntradarep;

@Controller
@RequestMapping("/trocas/{tenantid}/trocasDetalhadasDoDia_{tenantid}")
public class TrocasDetalhadasDoDia_jabController {

	@Autowired
	private ItensEntradarep itensEntradarep;
	
	@Autowired
	private Documentos documentos;
	
	@GetMapping
	public ModelAndView pesquisar(@PathVariable String tenantid) {

		ModelAndView mv = new ModelAndView("/trocas" + "/" + tenantid + "/trocasDetalhadasDoDia_"  + tenantid);
		mv.addObject("trocasDetalhadasPorDia", itensEntradarep.trocasDetalhadasDoDia_jab());
		mv.addObject("somaTrocaDoDia", documentos.SomatotalDeVendasDiaPorLoja_jab());
		mv.addObject("tenant", tenantid);
		return mv;
	}
	
	
}
