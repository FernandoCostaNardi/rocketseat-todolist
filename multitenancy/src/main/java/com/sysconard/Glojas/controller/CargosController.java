package com.sysconard.Glojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.model.Cargo;
import com.sysconard.Glojas.repository.filter.CargoFilter;
import com.sysconard.Glojas.service.CargoService;

@Controller
@RequestMapping("/cargos/{tenantid}/cargos")
public class CargosController {

	// ************ Injeta Dependencia do Servico de Cargo **************
	@Autowired
	private CargoService cargoService;

	// ************ Pesquisa Cargo **************
	@GetMapping
	public ModelAndView pesquisar(@ModelAttribute("cargoFiltro") CargoFilter cargoFiltro,
			@PathVariable String tenantid) {
		List<Cargo> todosCargos = cargoService.filtrar(cargoFiltro);

		ModelAndView mv = new ModelAndView("cargo/PesquisaCargo");
		mv.addObject("cargos", todosCargos);
		mv.addObject("tenant", tenantid);
		return mv;
	}
}
