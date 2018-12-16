package com.sysconard.Glojas.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.controller.page.PageWrapper;
import com.sysconard.Glojas.model.Funcionario;
import com.sysconard.Glojas.repository.Cargos;
import com.sysconard.Glojas.repository.Funcionarios;
import com.sysconard.Glojas.repository.Lojas;
import com.sysconard.Glojas.repository.filter.FuncionarioFilter;

@Controller
@RequestMapping("/funcionarios/{tenantid}/funcionarios")
public class FuncionarioController {

	@Autowired
	private Funcionarios funcionarios;
	@Autowired
	private Cargos cargos;
	@Autowired
	private Lojas lojas;

	@GetMapping
	public ModelAndView pesquisar(FuncionarioFilter filtro, @PageableDefault(size = 15) Pageable pageable,
			HttpServletRequest httpServletRequest, @PathVariable String tenantid) {
		ModelAndView mv = new ModelAndView("funcionario/PesquisaFuncionario");
		mv.addObject("cargos", cargos.findAll());
		mv.addObject("lojas", lojas.findAll());
		mv.addObject("tenant", tenantid);

		PageWrapper<Funcionario> paginaWrapper = new PageWrapper<>(funcionarios.filtrar(filtro, pageable),
				httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		return mv;
	}
}
