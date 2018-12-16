package com.sysconard.Glojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.model.Marca;
import com.sysconard.Glojas.repository.filter.MarcaFilter;
import com.sysconard.Glojas.service.MarcaService;

@Controller
@RequestMapping("/marcas/{tenantid}/marcas")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;

	// ************ Pesquisa Marca **************
	@GetMapping
	public ModelAndView pesquisar(@ModelAttribute("marcaFiltro") MarcaFilter marcaFiltro,
			@PathVariable String tenantid) {
		List<Marca> todasMarcas = marcaService.filtrar(marcaFiltro);

		ModelAndView mv = new ModelAndView("marca/PesquisaMarca");
		mv.addObject("marcas", todasMarcas);
		mv.addObject("tenant", tenantid);
		return mv;
	}
}
