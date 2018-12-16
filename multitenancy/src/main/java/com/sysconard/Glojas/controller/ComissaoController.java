package com.sysconard.Glojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sysconard.Glojas.DTO.GraficoVendasMes;
import com.sysconard.Glojas.repository.Comissoes;

@Controller
@RequestMapping("/{tenantid}/comissoes")
public class ComissaoController {

	@Autowired
	private Comissoes comissoes;

	@GetMapping("/totalPorMes")
	public @ResponseBody List<GraficoVendasMes> listarTotalVendasPorMes() {
		return comissoes.totalPorMes();
	}
}
