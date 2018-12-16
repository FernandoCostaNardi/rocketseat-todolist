package com.sysconard.Glojas.controller.vendas.jab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.repository.Documentos;

@Controller
@RequestMapping("/vendas/{tenantid}/vendasTotaisDoMesPorLoja_{tenantid}")
public class VendasTotaisDoMesPorLoja_jabController {
	
	@Autowired
	private Documentos documentos;

	@GetMapping
	public ModelAndView pesquisar(@PathVariable String tenantid) {
		ModelAndView mv = new ModelAndView("/vendas" + "/" + tenantid + "/vendasTotaisDoMesPorLoja_"  + tenantid);
		mv.addObject("vendasDoMesPorLoja", documentos.totalDeVendasDoMesPorLoja_jab());
		mv.addObject("somaVendasDoMesPorLoja", documentos.SomatotalDeVendasDoMesPorLoja_jab());
		mv.addObject("tenant", tenantid);
		return mv;
	}
}
