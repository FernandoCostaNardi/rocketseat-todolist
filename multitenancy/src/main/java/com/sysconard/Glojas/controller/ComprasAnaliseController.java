package com.sysconard.Glojas.controller;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sysconard.Glojas.repository.Estoques;
import com.sysconard.Glojas.repository.Precos;
import com.sysconard.Glojas.repository.Produtos;

@Controller
@RequestMapping("/compras/{tenantid}/analiseDeCompras")
public class ComprasAnaliseController {

	@Autowired
	private Precos precos;
	
	@Autowired
	private Produtos produtos;
	
	@Autowired
	private Estoques estoques;
	
	@GetMapping
	public ModelAndView pesquisar(@PathVariable String tenantid) {

		ModelAndView mv = new ModelAndView("compra/AnaliseDeCompras_" + tenantid);
		mv.addObject("tenant", tenantid);
		return mv;
	}
	
	@GetMapping("/dados")
	public ModelAndView obterDados(@PathVariable String tenantid, @RequestParam("refplu") String refplu) throws ParseException {
		
		ModelAndView mv = new ModelAndView("compra/AnaliseDeCompras_" + tenantid);
		mv.addObject("precoDeVendaAtual", precos.encontrarPrecoPeloRefplu(refplu));
		mv.addObject("infoProduto", produtos.encontrarProdutoPeloRefplu(refplu));
		mv.addObject("totalEstoque", estoques.estoqueDoProdutoPelaRefplu(refplu));
		mv.addObject("tenant", tenantid);
		return mv;
	}
}
