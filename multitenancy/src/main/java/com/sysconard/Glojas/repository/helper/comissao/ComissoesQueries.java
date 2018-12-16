package com.sysconard.Glojas.repository.helper.comissao;

import java.math.BigDecimal;
import java.util.List;

import com.sysconard.Glojas.DTO.ComissaoTotalDTO;
import com.sysconard.Glojas.DTO.GraficoVendasMes;
import com.sysconard.Glojas.DTO.VendasTotaisDTO;
import com.sysconard.Glojas.DTO.VendasTotaisDetalhadasDTO;

public interface ComissoesQueries {

	public BigDecimal valorTotalVendasDoDia();
	
	public BigDecimal valorTotalVendasDoDia_jab();
	
	public BigDecimal valorTotalTrocasDoDia_jab();
	
	public BigDecimal valorTotalPDVVendasDoDia_jab();
	
	public BigDecimal valorTotalDanfeVendasDoDia_jab();

	public BigDecimal valorTotalVendasDoMesAtual();
	
	public BigDecimal valorTotalVendasDoMesAtual_jab();
	
	public BigDecimal valorTotalTrocasDoMes_jab();
	
	public BigDecimal valorTotalPDVVendasDoMesAtual_jab();
	
	public BigDecimal valorTotalDanfeVendasDoMesAtual_jab();

	public BigDecimal valorTotalVendasDoAnoAtual();
	
	public BigDecimal valorTotalVendasDoAnoAtual_jab();
	
	public BigDecimal valorTotalPDVVendasDoAnoAtual_jab();

	public BigDecimal valorTotalDanfeVendasDoAnoAtual_jab();
	
	public List<GraficoVendasMes> totalPorMes();

	public List<VendasTotaisDTO> totalDeVendasDiaPorLoja();
	
	public List<VendasTotaisDTO> totalDeVendasDiaPorLoja_jab();
	
	public List<VendasTotaisDTO> totalDeVendasPDVDiaPorLoja_jab();
	
	public List<VendasTotaisDTO> totalDeVendasDanfeDiaPorLoja_jab();

	public List<VendasTotaisDTO> totalDeVendasDoMesPorLoja();
	
	public List<VendasTotaisDTO> totalDeVendasDoMesPorLoja_jab();
	
	public List<VendasTotaisDTO> totalDeVendasPDVDoMesPorLoja_jab();
	
	public List<VendasTotaisDTO> totalDeVendasDanfeDoMesPorLoja_jab();

	public List<VendasTotaisDTO> totalDeVendasDoAnoPorLoja();
	
	public List<VendasTotaisDTO> totalDeVendasDoAnoPorLoja_jab();
	
	public List<VendasTotaisDTO> totalDeVendasPDVDoAnoPorLoja_jab();
	
	public List<VendasTotaisDTO> totalDeVendasDanfeDoAnoPorLoja_jab();

	public BigDecimal valorTotalVendasPorPeriodo(String dataEmissaoInicial, String dataEmissaoFinal);
	
	public BigDecimal valorTotalVendasPorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal);
	
	public BigDecimal valorTotalVendasPDVPorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal);
	
	public BigDecimal valorTotalVendasDanfePorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal);

	public List<VendasTotaisDTO> totalDeVendasPorPeriodoPorLoja(String dataEmissaoInicial, String dataEmissaoFinal);
	
	public List<VendasTotaisDTO> totalDeVendasPorPeriodoPorLoja_jab(String dataEmissaoInicial, String dataEmissaoFinal);
	
	public List<VendasTotaisDTO> totalDeVendasPDVPorPeriodoPorLoja_jab(String dataEmissaoInicial, String dataEmissaoFinal);
	
	public List<VendasTotaisDTO> totalDeVendasDanfePorPeriodoPorLoja_jab(String dataEmissaoInicial, String dataEmissaoFinal);

	public List<VendasTotaisDetalhadasDTO> vendasDetalhadasPorPeriodo(String dataEmissaoInicial,
			String dataEmissaoFinal);
	
	public List<VendasTotaisDetalhadasDTO> vendasDetalhadasPorPeriodo_jab(String dataEmissaoInicial,
			String dataEmissaoFinal);

	public List<ComissaoTotalDTO> comissoesTotaisPorPeriodo(String dataEmissaoInicial, String dataEmissaoFinal);

	public BigDecimal valorTotalcomissoesPorPeriodo(String dataEmissaoInicial, String dataEmissaoFinal);

	public BigDecimal valorTotalDescontoPorPeriodo(String dataEmissaoInicial, String dataEmissaoFinal);
}
