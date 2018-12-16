package com.sysconard.Glojas.controller.vendas.jab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.repository.Documentos;

@Controller
@RequestMapping("/vendas/{tenantid}/margemContribuicaoMarcaDia_{tenantid}")
public class VendasMargemContribucaoMarcas_jabController {

	@Autowired
	private Documentos documentos;

	@GetMapping
	public ModelAndView pesquisar(@PathVariable String tenantid) {
		ModelAndView mv = new ModelAndView("/vendas" + "/" + tenantid + "/margemContribuicaoMarcaDia_"  + tenantid);
		mv.addObject("margemContribucaoMarcaDia", documentos.SomaContribuicaoMarcaDia_jab());
		mv.addObject("total", documentos.ValorTotalContribuicaoMarcaDia_jab());
		mv.addObject("tenant", tenantid);
		return mv;
	}
}
