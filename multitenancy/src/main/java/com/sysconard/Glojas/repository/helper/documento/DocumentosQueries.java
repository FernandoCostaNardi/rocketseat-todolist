package com.sysconard.Glojas.repository.helper.documento;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import com.sysconard.Glojas.DTO.VendaContribucaoMarca;
import com.sysconard.Glojas.DTO.VendasTotaisDTO;

public interface DocumentosQueries {

	List<VendasTotaisDTO> totalDeVendasDiaPorLoja_jab();

	List<VendasTotaisDTO> totalDeVendasDoMesPorLoja_jab();

	List<VendasTotaisDTO> totalDeVendasDoAnoPorLoja_jab();
	
	List<VendasTotaisDTO> totalDeVendasPorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal);

	List<VendasTotaisDTO> SomatotalDeVendasDiaPorLoja_jab();
	
	List<VendasTotaisDTO> SomatotalDeVendasDoMesPorLoja_jab();
	
	List<VendasTotaisDTO> SomatotalDeVendasDoAnoPorLoja_jab();
	
	List<VendasTotaisDTO> SomatotalDeVendasPorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal);
	
	List<VendaContribucaoMarca> SomaContribuicaoMarcaDia_jab();
	
	List<VendaContribucaoMarca> TotalContribuicaoMarcaDia_jab();
	
	BigDecimal ValorTotalContribuicaoMarcaDia_jab();
	
	List<VendaContribucaoMarca> SomaContribuicaoMarcaMesAtual_jab();
	
	BigDecimal ValorTotalContribuicaoMarcaMesAtual_jab();
	
	List<VendaContribucaoMarca> SomaContribuicaoMarcaPorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal);
	
	BigDecimal ValorTotalContribuicaoMarcaPorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal);
	
	List<VendaContribucaoMarca> SomaContribuicaoGrupoPorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal);
	
	List<VendaContribucaoMarca> SomaContribuicaoSubGrupoPorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal);



}
