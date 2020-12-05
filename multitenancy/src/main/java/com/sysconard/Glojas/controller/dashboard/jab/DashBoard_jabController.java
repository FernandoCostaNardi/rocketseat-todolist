package com.sysconard.Glojas.controller.dashboard.jab;

import com.sysconard.Glojas.DTO.dashboard.TotaisDashboardDTO;
import com.sysconard.Glojas.repository.Documentos;
import com.sysconard.Glojas.service.dashboard.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard/{tenantid}/dashboard")
public class DashBoard_jabController {

	@Autowired
	private VendaTotaLDoDiaDashboardService vendaTotaLDoDiaDashboardService;

	@Autowired
	private VendaTotalDoMesDashboardService vendaTotaLDoMesDashboardService;

	@Autowired
	private VendaTotalDoAnoDashboardService vendaTotalDoAnoDashboardService;

	@Autowired
	private VendaFuncionarioDiaService vendaFuncionarioDiaService;

	@Autowired
	private VendaFuncionarioMesService vendaFuncionarioMesService;

	@Autowired
	private VendaFuncionarioAnoService vendaFuncionarioAnoService;

	@Autowired
	private VendaQuantidadeFuncionarioService vendaQuantidadeFuncionarioService;

	@Autowired
	private VendaTrocaFuncionarioService vendaTrocaFuncionarioService;

	@Autowired
	private VendaProdutoDashboardService vendaProdutoDashboardService;

	@GetMapping
	public ModelAndView dashBoard(@PathVariable String tenantid) {
		ModelAndView mv = new ModelAndView("/dashboard" + "/" + tenantid + "/dashboard_"  + tenantid);

		mv.addObject("vendaDiaTotalDia", vendaTotaLDoDiaDashboardService.vendasTotaisDoDia());
		mv.addObject("vendaDiaTotalMes", vendaTotaLDoMesDashboardService.vendasTotaisDoMes());
		mv.addObject("vendaDiaTotalAno", vendaTotalDoAnoDashboardService.vendasTotaisDoAno());
		mv.addObject("funcionarioValorDia", vendaFuncionarioDiaService.vendasTotaisDoDia());
		mv.addObject("funcionarioValorMes", vendaFuncionarioMesService.vendasTotaisDoMes());
		mv.addObject("funcionarioValorAno", vendaFuncionarioAnoService.vendasTotaisDoAno());
		mv.addObject("funcionarioQuantidadeDia", vendaQuantidadeFuncionarioService.vendasQuantidadeTotaisDoDia());
		mv.addObject("funcionarioQuantidadeMes", vendaQuantidadeFuncionarioService.vendasQuantidadeTotaisDoMes());
		mv.addObject("funcionarioQuantidadeAno", vendaQuantidadeFuncionarioService.vendasQuantidadeTotaisDoAno());
		mv.addObject("funcionarioTrocaDia", vendaTrocaFuncionarioService.trocasTotaisDoDia());
		mv.addObject("funcionarioTrocaMes", vendaTrocaFuncionarioService.trocasTotaisDoMes());
		mv.addObject("funcionarioTrocaAno", vendaTrocaFuncionarioService.trocasTotaisDoAno());
		mv.addObject("produtoQuantidadeDia", vendaProdutoDashboardService.produtoMaisVendidoDoDia());
		mv.addObject("produtoQuantidadeMes", vendaProdutoDashboardService.produtoMaisVendidoDoMes());
		mv.addObject("produtoQuantidadeAno", vendaProdutoDashboardService.produtoMaisVendidoDoAno());
		mv.addObject("produtoMaiorValorDia", vendaProdutoDashboardService.produtoComMaiorValorAgregadoVendidoNodia());
		mv.addObject("produtoMaiorValorMes", vendaProdutoDashboardService.produtoComMaiorValorAgregadoVendidoNoMes());
		mv.addObject("produtoMaiorValorAno", vendaProdutoDashboardService.produtoComMaiorValorAgregadoVendidoNoAno());
		mv.addObject("tenant", tenantid);
		return mv;
	}
}
