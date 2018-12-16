package com.sysconard.Glojas.controller.dashboard.jab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.repository.Documentos;

@Controller
@RequestMapping("/dashboard/{tenantid}/dashboard")
public class DashBoard_jabController {
	
	@Autowired
	private Documentos documentos;

	@GetMapping
	public ModelAndView dashBoard(@PathVariable String tenantid) {
		ModelAndView mv = new ModelAndView("/dashboard" + "/" + tenantid + "/dashboard_"  + tenantid);
		
		mv.addObject("somaVendasDoDiaporLoja", documentos.SomatotalDeVendasDiaPorLoja_jab());
		mv.addObject("somaVendasDoMesPorLoja", documentos.SomatotalDeVendasDoMesPorLoja_jab());
		mv.addObject("somaVendasDoAnoporLoja", documentos.SomatotalDeVendasDoAnoPorLoja_jab());
		mv.addObject("tenant", tenantid);
		return mv;
	}
}
