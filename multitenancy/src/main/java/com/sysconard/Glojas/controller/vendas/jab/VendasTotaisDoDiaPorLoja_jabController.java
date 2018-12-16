package com.sysconard.Glojas.controller.vendas.jab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.repository.Documentos;

@Controller
@RequestMapping("/vendas/{tenantid}/vendasTotaisDoDiaPorLoja_{tenantid}")
public class VendasTotaisDoDiaPorLoja_jabController {

	@Autowired
	private Documentos documentos;

	@GetMapping
	public ModelAndView pesquisar(@PathVariable String tenantid) {
		ModelAndView mv = new ModelAndView("/vendas" + "/" + tenantid + "/vendasTotaisDoDiaPorLoja_"  + tenantid);
		mv.addObject("vendasDoDiaporLoja", documentos.totalDeVendasDiaPorLoja_jab());
		mv.addObject("somaVendasDoDiaporLoja", documentos.SomatotalDeVendasDiaPorLoja_jab());
		mv.addObject("tenant", tenantid);
		return mv;
	}
}
