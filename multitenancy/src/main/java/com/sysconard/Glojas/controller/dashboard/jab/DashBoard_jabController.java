package com.sysconard.Glojas.controller.dashboard.jab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.DTO.dashboard.InfoProdutoDashboard;
import com.sysconard.Glojas.DTO.dashboard.InfoVendedoresDashboardDTO;
import com.sysconard.Glojas.DTO.dashboard.TotaisDashboardDTO;
import com.sysconard.Glojas.repository.DashboardPreProcessorRepository;
import com.sysconard.Glojas.service.dashboard.VendaFuncionarioAnoService;
import com.sysconard.Glojas.service.dashboard.VendaFuncionarioDiaService;
import com.sysconard.Glojas.service.dashboard.VendaFuncionarioMesService;
import com.sysconard.Glojas.service.dashboard.VendaProdutoDashboardService;
import com.sysconard.Glojas.service.dashboard.VendaQuantidadeFuncionarioService;
import com.sysconard.Glojas.service.dashboard.VendaTotaLDoDiaDashboardService;
import com.sysconard.Glojas.service.dashboard.VendaTotalDoAnoDashboardService;
import com.sysconard.Glojas.service.dashboard.VendaTotalDoMesDashboardService;
import com.sysconard.Glojas.service.dashboard.VendaTrocaFuncionarioService;

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

	@Autowired
	private DashboardPreProcessorRepository dashboardPreProcessorRepository;


	TotaisDashboardDTO VendasDodia = new TotaisDashboardDTO();
	TotaisDashboardDTO vendasDoMes = new TotaisDashboardDTO();
	TotaisDashboardDTO vendasDoAno = new TotaisDashboardDTO();
	InfoVendedoresDashboardDTO VendasColaboradorDia = new InfoVendedoresDashboardDTO();
	InfoVendedoresDashboardDTO VendasColaboradorMes = new InfoVendedoresDashboardDTO();
	InfoVendedoresDashboardDTO VendasColaboradorAno = new InfoVendedoresDashboardDTO();
	InfoVendedoresDashboardDTO vendasColaboadorQtdDia = new InfoVendedoresDashboardDTO();
	InfoVendedoresDashboardDTO vendasColaboadorQtdMes = new InfoVendedoresDashboardDTO();
	InfoVendedoresDashboardDTO vendasColaboadorQtdAno = new InfoVendedoresDashboardDTO();
	InfoVendedoresDashboardDTO trocasColaboradorDia = new InfoVendedoresDashboardDTO();
	InfoVendedoresDashboardDTO trocasColaboradorMes = new InfoVendedoresDashboardDTO();
	InfoVendedoresDashboardDTO trocasColaboradorAno = new InfoVendedoresDashboardDTO();
	InfoProdutoDashboard produtoQtdDia = new InfoProdutoDashboard();
	InfoProdutoDashboard produtoQtdMes = new InfoProdutoDashboard();
	InfoProdutoDashboard produtoQtdAno = new InfoProdutoDashboard();
	InfoProdutoDashboard produtoVlrQtdDia = new InfoProdutoDashboard();
	InfoProdutoDashboard produtoVlrQtdMes = new InfoProdutoDashboard();
	InfoProdutoDashboard produtoVlrQtdAno = new InfoProdutoDashboard();


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

	public void buscarDados() {
        VendasDodia = vendaTotaLDoDiaDashboardService.vendasTotaisDoDia();
        vendasDoMes = vendaTotaLDoMesDashboardService.vendasTotaisDoMes();
        vendasDoAno = vendaTotalDoAnoDashboardService.vendasTotaisDoAno();
		VendasColaboradorDia = vendaFuncionarioDiaService.vendasTotaisDoDia();
		VendasColaboradorMes = vendaFuncionarioMesService.vendasTotaisDoMes();
		VendasColaboradorAno = vendaFuncionarioAnoService.vendasTotaisDoAno();
		vendasColaboadorQtdDia = vendaQuantidadeFuncionarioService.vendasQuantidadeTotaisDoDia();
		vendasColaboadorQtdMes = vendaQuantidadeFuncionarioService.vendasQuantidadeTotaisDoMes();
		vendasColaboadorQtdAno = vendaQuantidadeFuncionarioService.vendasQuantidadeTotaisDoAno();
		trocasColaboradorDia = vendaTrocaFuncionarioService.trocasTotaisDoDia();
		trocasColaboradorMes = vendaTrocaFuncionarioService.trocasTotaisDoMes();
		trocasColaboradorAno = vendaTrocaFuncionarioService.trocasTotaisDoAno();
	 	produtoQtdDia = vendaProdutoDashboardService.produtoMaisVendidoDoDia();
	 	produtoQtdMes = vendaProdutoDashboardService.produtoMaisVendidoDoMes();
	 	produtoQtdAno = vendaProdutoDashboardService.produtoMaisVendidoDoAno();
	 	produtoVlrQtdDia = vendaProdutoDashboardService.produtoComMaiorValorAgregadoVendidoNodia();
	 	produtoVlrQtdMes = vendaProdutoDashboardService.produtoComMaiorValorAgregadoVendidoNoMes();
	 	produtoVlrQtdAno = vendaProdutoDashboardService.produtoComMaiorValorAgregadoVendidoNoAno();
	}

//	public void DashboardPreProcessor() {
//		buscarDados();
//		DashboardPreProcessor dashboardPreProcessor = DashboardPreProcessor
//				.builder()
//				.vendaDia(VendasDodia.getVendas())
//				.trocaDia(VendasDodia.getTrocas())
//				.totalVendaDia(VendasDodia.getTotal())
//				.vendaMes(vendasDoMes.getVendas())
//				.trocaMês(vendasDoMes.getTrocas())
//				.totalVendaMês(vendasDoMes.getTotal())
//				.vendaAno(vendasDoAno.getVendas())
//				.trocaAno(vendasDoAno.getTrocas())
//				.totalVendaAno(vendasDoAno.getTotal())
//				.nmFuncionarioVendaDia(VendasColaboradorDia.getNmFuncionario())
//				.vlTotalVendaDia(VendasColaboradorDia.getVlTotal())
//				.nmFuncionarioVendaMes(VendasColaboradorMes.getNmFuncionario())
//				.vlTotalVendaMes(VendasColaboradorMes.getVlTotal())
//				.nmFuncionarioVendaAno(VendasColaboradorAno.getNmFuncionario())
//				.vlTotalVendaAno(VendasColaboradorAno.getVlTotal())
//				.nmFuncionarioVendaQuantidadeDia(vendasColaboadorQtdDia.getNmFuncionario())
//				.qtProdutoVendaQuantidadeDia(vendasColaboadorQtdDia.getQtProduto())
//				.nmFuncionarioVendaQuantidadeMes(vendasColaboadorQtdMes.getNmFuncionario())
//				.qtProdutoVendaQuantidadeMes(vendasColaboadorQtdMes.getQtProduto())
//				.nmFuncionarioVendaQuantidadeAno(vendasColaboadorQtdAno.getNmFuncionario())
//				.qtProdutoVendaQuantidadeAno(vendasColaboadorQtdAno.getQtProduto())
//				.nmFuncionarioTrocaDia(trocasColaboradorDia.getNmFuncionario())
//				.vlTotalTrocaDia(trocasColaboradorDia.getVlTotal())
//				.nmFuncionarioTrocaMes(trocasColaboradorMes.getNmFuncionario())
//				.vlTotalTrocaMes(trocasColaboradorMes.getVlTotal())
//				.nmFuncionarioTrocaAno(trocasColaboradorAno.getNmFuncionario())
//				.vlTotalTrocaAno(trocasColaboradorAno.getVlTotal())
//				.nmProdutoVendidoDia(produtoQtdDia.getNmProduto())
//				.qtProdutoVendidoDia(produtoQtdDia.getQtProduto())
//				.nmProdutoVendidoMes(produtoQtdMes.getNmProduto())
//				.qtProdutoVendidoMes(produtoQtdMes.getQtProduto())
//				.nmProdutoVendidoAno(produtoQtdAno.getNmProduto())
//				.qtProdutoVendidoAno(produtoQtdAno.getQtProduto())
//				.nmProdutoValorAgregadoVendidoDia(produtoVlrQtdDia.getNmProduto())
//				.vlProdutoValorAgregadoVendidoDia(produtoVlrQtdDia.getVlProduto())
//				.nmProdutoValorAgregadoVendidoMes(produtoVlrQtdMes.getNmProduto())
//				.vlProdutoValorAgregadoVendidoMes(produtoVlrQtdMes.getVlProduto())
//				.nmProdutoValorAgregadoVendidoAno(produtoVlrQtdAno.getNmProduto())
//				.vlProdutoValorAgregadoVendidoAno(produtoVlrQtdAno.getVlProduto())
//				.id(1L)
//				.build();
//
//		dashboardPreProcessorRepository.save(dashboardPreProcessor);
//		System.out.println("DashBoardSalvo");
//	}

	@GetMapping("/welcome")
	public ModelAndView dashBoard_welcome(@PathVariable String tenantid) {
		ModelAndView mv = new ModelAndView("/dashboard" + "/" + tenantid + "/dashboard_"  + tenantid + "_welcome");
		mv.addObject("tenant", tenantid);
		return mv;
	}
}
