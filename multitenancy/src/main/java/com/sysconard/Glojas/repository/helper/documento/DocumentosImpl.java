package com.sysconard.Glojas.repository.helper.documento;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sysconard.Glojas.DTO.VendaContribucaoMarca;
import com.sysconard.Glojas.DTO.VendasTotaisDTO;
import com.sysconard.Glojas.DTO.vendas.UnicoValorDTO;
import com.sysconard.Glojas.model.Documento;
import com.sysconard.Glojas.repository.Documentos;
import com.sysconard.Glojas.util.DatasUtil;
import com.sysconard.Glojas.util.LojasClientesUtil;
import com.sysconard.Glojas.util.OperacaoUtil;
import com.sysconard.Glojas.util.TipoUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class DocumentosImpl implements DocumentosQueries{

	@Autowired
	private Documentos documentoRepository;

	DatasUtil datasUtil = new DatasUtil();
	OperacaoUtil operacaoUtil = new OperacaoUtil();
	TipoUtil tipoUtil = new TipoUtil();
	LojasClientesUtil lojasClientesUtil = new LojasClientesUtil();
	
	@PersistenceContext
	private EntityManager manager;
	
	List<String> tipoDanfe = tipoUtil.tipoDanfe();
	List<String> tipoPDV = tipoUtil.tipoPDV();
	List<String> tipoTroca = tipoUtil.tipoTroca();
	List<String> tipoPDVEDanfe = tipoUtil.tipoPDVEDanfe();
	
	List<String> operacaoVenda = operacaoUtil.operacaoVenda();
	List<String> operacaoTroca = operacaoUtil.operacaoTroca();
	
	List<Long> lojasJab = lojasClientesUtil.lojasJab();

	LocalDate now = LocalDate.now();
	Timestamp hoje = Timestamp.valueOf(now.atStartOfDay());
	Timestamp primeiroDiaDoMesAtual = datasUtil.SysDataPrimeiroDiaDoMesAtual();
	Timestamp ultimoDiaDoMesAtual = datasUtil.SysDataUltimoDiaDoMesAtual();
	Timestamp primeiroDiaDoAnoAtual = datasUtil.SysDataPrimeiroDiaDoAnoAtual();
	Timestamp ultimoDiaDoAnoAtual = datasUtil.SysDataUltimoDiaDoAnoAtual();
		
	@Override
	public List<VendasTotaisDTO> totalDeVendasDiaPorLoja_jab() {
		
		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome,  "
									+ "(select sum(d1.valorDocumento) "
									+ "from Documento d1 "
									+ "where d1.statusDocumento = 'E' and "
									+ "       d1.tipo IN (:tipoPDV) and " 
									+ "       d1.codigoOperacao IN (:operacaoVenda) and "
									+ "       d1.dataEmissao = :dataEmissao and " 
									+ "       d1.loja.codigo = l.codigo and "
									+ "       d1.loja.codigo IN (:loja) "
									+ "group by d1.loja.codigo) as troca2, "
											+ "(select sum(d1.valorDocumento) "
											+ "from Documento d1 "
											+ "where d1.statusDocumento = 'E' and "
											+ "       d1.tipo IN (:tipoDanfe) and " 
											+ "       d1.codigoOperacao IN (:operacaoVenda) and "
											+ "       d1.dataEmissao = :dataEmissao and " 
											+ "       d1.loja.codigo = l.codigo and "
											+ "       d1.loja.codigo IN (:loja) "
											+ "group by d1.loja.codigo) as troca, "
													+ "(select sum(d1.valorDocumento) "
													+ "from Documento d1 "
													+ "where "
													+ "       d1.tipo IN (:tipoTroca) and " 
													+ "       d1.codigoOperacao IN(:operacaoTroca) and "
													+ "       d1.statusDocumento = 'E' and "
													+ "       d1.statusDanfe = 'A' and "
													+ "       d1.dataEmissao = :dataEmissao and " 
													+ "       d1.loja.codigo = l.codigo and "
													+ "       d1.loja.codigo IN (:loja) "
													+ "group by d1.loja.codigo) as troca ) "
						+ "from Loja l  "
						+ "where l.codigo IN (:loja) ";

		List<VendasTotaisDTO> vendasDia = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("operacaoVenda", operacaoVenda)
				.setParameter("operacaoTroca", operacaoTroca)
				.setParameter("tipoDanfe", tipoDanfe)
				.setParameter("tipoPDV", tipoPDV)
				.setParameter("tipoTroca", tipoTroca)
				.setParameter("dataEmissao", hoje)
				.setParameter("loja", lojasJab)
				.getResultList();

		
		return vendasDia;
	}

	//Busca de valor funcionando Dashboard
	public UnicoValorDTO valorTotal(List<String> tipo, List<String> operacao, Timestamp dataInicial, Timestamp dataFinal){
		return manager.createNamedQuery("totalVendas.recuperarTotal", UnicoValorDTO.class)
				.setParameter("tipo", tipo)
				.setParameter("operacao", operacao)
				.setParameter("dataInicial", dataInicial)
				.setParameter("dataFinal", dataFinal)
				.getSingleResult();
	}

	//Busca de valor funcionando Dashboard
	public UnicoValorDTO valorTotalTroca(List<String> tipo, List<String> operacao, Timestamp dataInicial, Timestamp dataFinal){
		return manager.createNamedQuery("totalVendas.recuperarTotalTroca", UnicoValorDTO.class)
				.setParameter("tipo", tipo)
				.setParameter("operacao", operacao)
				.setParameter("dataInicial", dataInicial)
				.setParameter("dataFinal", dataFinal)
				.getSingleResult();
	}

	@Override
	public List<VendasTotaisDTO> totalDeVendasDoMesPorLoja_jab() {
		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome,  "
				+ "(select sum(d1.valorDocumento) "
				+ "from Documento d1 "
				+ "where d1.statusDocumento = 'E' and "
				+ "       d1.tipo IN (:tipoPDV) and " 
				+ "       d1.codigoOperacao IN (:operacaoVenda) and "
				+ "       d1.dataEmissao between :primeiroDiaDoMesAtual and :ultimoDiaDoMesAtual  and " 
				+ "       d1.loja.codigo = l.codigo and "
				+ "       d1.loja.codigo IN (:loja) "
				+ "group by d1.loja.codigo) as troca2, "
						+ "(select sum(d1.valorDocumento) "
						+ "from Documento d1 "
						+ "where d1.statusDocumento = 'E' and "
						+ "       d1.tipo IN (:tipoDanfe) and " 
						+ "       d1.codigoOperacao IN (:operacaoVenda) and "
						+ "       d1.dataEmissao between :primeiroDiaDoMesAtual and :ultimoDiaDoMesAtual  and " 
						+ "       d1.loja.codigo = l.codigo and "
						+ "       d1.loja.codigo IN (:loja) "
						+ "group by d1.loja.codigo) as troca, "
								+ "(select sum(d1.valorDocumento) "
								+ "from Documento d1 "
								+ "where  "
								+ "       d1.tipo IN (:tipoTroca) and " 
								+ "       d1.statusDocumento = 'E' and "
								+ "       d1.codigoOperacao IN(:operacaoTroca) and "
								+ "       d1.statusDanfe = 'A' and "
								+ "       d1.dataEmissao between :primeiroDiaDoMesAtual and :ultimoDiaDoMesAtual  and " 
								+ "       d1.loja.codigo = l.codigo and "
								+ "       d1.loja.codigo IN (:loja) "
								+ "group by d1.loja.codigo) as troca ) "
		+ "from Loja l  "
		+ "where l.codigo IN (:loja) ";

			List<VendasTotaisDTO> vendasMes = manager.createQuery(jpql, VendasTotaisDTO.class)
			.setParameter("operacaoVenda", operacaoVenda)
			.setParameter("operacaoTroca", operacaoTroca)
			.setParameter("tipoDanfe", tipoDanfe)
			.setParameter("tipoPDV", tipoPDV)
			.setParameter("tipoTroca", tipoTroca)
			.setParameter("primeiroDiaDoMesAtual", primeiroDiaDoMesAtual)
			.setParameter("ultimoDiaDoMesAtual", ultimoDiaDoMesAtual)
			.setParameter("loja", lojasJab)
			.getResultList();
		
		return vendasMes;
	}

	@Override
	public List<VendasTotaisDTO> totalDeVendasDoAnoPorLoja_jab() {
		
		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome,  "
				+ "(select sum(d1.valorDocumento) "
				+ "from Documento d1 "
				+ "where d1.statusDocumento = 'E' and "
				+ "       d1.tipo IN (:tipoPDV) and " 
				+ "       d1.codigoOperacao IN (:operacaoVenda) and "
				+ "       d1.dataEmissao between :primeiroDiaDoAnoAtual and :ultimoDiaDoAnoAtual  and " 
				+ "       d1.loja.codigo = l.codigo and "
				+ "       d1.loja.codigo IN (:loja) "
				+ "group by d1.loja.codigo) as troca2, "
						+ "(select sum(d1.valorDocumento) "
						+ "from Documento d1 "
						+ "where d1.statusDocumento = 'E' and "
						+ "       d1.tipo IN (:tipoDanfe) and " 
						+ "       d1.codigoOperacao IN (:operacaoVenda) and "
						+ "       d1.dataEmissao between :primeiroDiaDoAnoAtual and :ultimoDiaDoAnoAtual  and " 
						+ "       d1.loja.codigo = l.codigo and "
						+ "       d1.loja.codigo IN (:loja) "
						+ "group by d1.loja.codigo) as troca, "
								+ "(select sum(d1.valorDocumento) "
								+ "from Documento d1 "
								+ "where "
								+ "       d1.tipo IN (:tipoTroca) and " 
								+ "       d1.codigoOperacao IN(:operacaoTroca) and "
								+ "       d1.statusDocumento = 'E' and "
								+ "       d1.statusDanfe = 'A' and "
								+ "       d1.dataEmissao between :primeiroDiaDoAnoAtual and :ultimoDiaDoAnoAtual  and " 
								+ "       d1.loja.codigo = l.codigo and "
								+ "       d1.loja.codigo IN (:loja) "
								+ "group by d1.loja.codigo) as troca ) "
		+ "from Loja l  "
		+ "where l.codigo IN (:loja) ";

			List<VendasTotaisDTO> vendasAno = manager.createQuery(jpql, VendasTotaisDTO.class)
			.setParameter("operacaoVenda", operacaoVenda)
			.setParameter("operacaoTroca", operacaoTroca)
			.setParameter("tipoDanfe", tipoDanfe)
			.setParameter("tipoPDV", tipoPDV)
			.setParameter("tipoTroca", tipoTroca)
			.setParameter("primeiroDiaDoAnoAtual", primeiroDiaDoAnoAtual)
			.setParameter("ultimoDiaDoAnoAtual", ultimoDiaDoAnoAtual)
			.setParameter("loja", lojasJab)
			.getResultList();
			
		return vendasAno;
	}
	
	@Override
	public List<VendasTotaisDTO> SomatotalDeVendasDiaPorLoja_jab() {
		
		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO("
									+ "sum(d1.valorDocumento), "
											+ "(select sum(d1.valorDocumento) "
											+ "from Documento d1 "
											+ "where d1.statusDocumento = 'E' and "
											+ "       d1.tipo IN (:tipoDanfe) and " 
											+ "       d1.codigoOperacao IN (:operacaoVenda) and "
											+ "       d1.dataEmissao = :dataEmissao  " 
											+ ") as troca, "
													+ "(select sum(d1.valorDocumento) "
													+ "from Documento d1 "
													+ "where  "
													+ "       d1.tipo IN (:tipoTroca) and " 
													+ "       d1.statusDanfe = 'A' and "
													+ "       d1.statusDocumento = 'E' and "
													+ "       d1.codigoOperacao IN(:operacaoTroca) and "
													+ "       d1.dataEmissao = :dataEmissao " 
													+ ") as troca ) "
								+ "from Documento d1 "
								+ "where d1.statusDocumento = 'E' and "
								+ "       d1.tipo IN (:tipoPDV) and " 
								+ "       d1.codigoOperacao IN (:operacaoVenda) and "
								+ "       d1.dataEmissao = :dataEmissao ";

		List<VendasTotaisDTO> somaVendasDia = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("operacaoVenda", operacaoVenda)
				.setParameter("operacaoTroca", operacaoTroca)
				.setParameter("tipoDanfe", tipoDanfe)
				.setParameter("tipoPDV", tipoPDV)
				.setParameter("tipoTroca", tipoTroca)
				.setParameter("dataEmissao", hoje)
				.getResultList();

		return somaVendasDia;
	
	}

	@Override
	public List<VendasTotaisDTO> SomatotalDeVendasDoMesPorLoja_jab() {
					String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO("
						+ "sum(d1.valorDocumento), "
								+ "(select sum(d1.valorDocumento) "
								+ "from Documento d1 "
								+ "where d1.statusDocumento = 'E' and "
								+ "       d1.tipo IN (:tipoDanfe) and " 
								+ "       d1.codigoOperacao IN (:operacaoVenda) and "
								+ "       d1.dataEmissao between :primeiroDiaDoMesAtual and :ultimoDiaDoMesAtual  " 
								+ ") as troca, "
										+ "(select sum(d1.valorDocumento) "
										+ "from Documento d1 "
										+ "where  "
										+ "       d1.tipo IN (:tipoTroca) and " 
										+ "       d1.statusDanfe = 'A' and "
										+ "       d1.statusDocumento = 'E' and "
										+ "       d1.codigoOperacao IN(:operacaoTroca) and "
										+ "       d1.dataEmissao between :primeiroDiaDoMesAtual and :ultimoDiaDoMesAtual   " 
										+ ") as troca ) "
							+ "from Documento d1 "
							+ "where d1.statusDocumento = 'E' and "
							+ "       d1.tipo IN (:tipoPDV) and " 
							+ "       d1.codigoOperacao IN (:operacaoVenda) and "
							+ "       d1.dataEmissao between :primeiroDiaDoMesAtual and :ultimoDiaDoMesAtual "; 
				
				List<VendasTotaisDTO> somaVendaMes = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("operacaoVenda", operacaoVenda)
				.setParameter("operacaoTroca", operacaoTroca)
				.setParameter("tipoDanfe", tipoDanfe)
				.setParameter("tipoPDV", tipoPDV)
				.setParameter("tipoTroca", tipoTroca)
				.setParameter("primeiroDiaDoMesAtual", primeiroDiaDoMesAtual)
				.setParameter("ultimoDiaDoMesAtual", ultimoDiaDoMesAtual)
				.getResultList();
		
		return somaVendaMes;
	}

	@Override
	public List<VendasTotaisDTO> SomatotalDeVendasDoAnoPorLoja_jab() {
		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO("
				+ "sum(d1.valorDocumento), "
						+ "(select sum(d1.valorDocumento) "
						+ "from Documento d1 "
						+ "where d1.statusDocumento = 'E' and "
						+ "       d1.tipo IN (:tipoDanfe) and " 
						+ "       d1.codigoOperacao IN (:operacaoVenda) and "
						+ "       d1.dataEmissao between :primeiroDiaDoAnoAtual and :ultimoDiaDoAnoAtual  " 
						+ ") as troca, "
								+ "(select sum(d1.valorDocumento) "
								+ "from Documento d1 "
								+ "where "
								+ "       d1.tipo IN (:tipoTroca) and " 
								+ "       d1.statusDanfe = 'A' and "
								+ "       d1.statusDocumento = 'E' and "
								+ "       d1.codigoOperacao IN(:operacaoTroca) and "
								+ "       d1.dataEmissao between :primeiroDiaDoAnoAtual and :ultimoDiaDoAnoAtual   " 
								+ ") as troca ) "
					+ "from Documento d1 "
					+ "where d1.statusDocumento = 'E' and "
					+ "       d1.tipo IN (:tipoPDV) and " 
					+ "       d1.codigoOperacao IN (:operacaoVenda) and "
					+ "       d1.dataEmissao between :primeiroDiaDoAnoAtual and :ultimoDiaDoAnoAtual "; 
		
		List<VendasTotaisDTO> somaVendasAno = manager.createQuery(jpql, VendasTotaisDTO.class)
		.setParameter("operacaoVenda", operacaoVenda)
		.setParameter("operacaoTroca", operacaoTroca)
		.setParameter("tipoDanfe", tipoDanfe)
		.setParameter("tipoPDV", tipoPDV)
		.setParameter("tipoTroca", tipoTroca)
		.setParameter("primeiroDiaDoAnoAtual", primeiroDiaDoAnoAtual)
		.setParameter("ultimoDiaDoAnoAtual", ultimoDiaDoAnoAtual)
		.getResultList();
		
		return somaVendasAno;
	}

	@Override
	public List<VendasTotaisDTO> totalDeVendasPorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal) {
		Timestamp dataInicial = datasUtil.SysData(dataEmissaoInicial);
		Timestamp dataFinal= datasUtil.SysData(dataEmissaoFinal);
		
		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome,  "
				+ "(select sum(d1.valorDocumento) "
				+ "from Documento d1 "
				+ "where d1.statusDocumento = 'E' and "
				+ "       d1.tipo IN (:tipoPDV) and " 
				+ "       d1.codigoOperacao IN (:operacaoVenda) and "
				+ "       d1.dataEmissao between :dataInicial and :dataFinal  and " 
				+ "       d1.loja.codigo = l.codigo and "
				+ "       d1.loja.codigo IN (:loja) "
				+ "group by d1.loja.codigo) as troca2, "
						+ "(select sum(d1.valorDocumento) "
						+ "from Documento d1 "
						+ "where d1.statusDocumento = 'E' and "
						+ "       d1.tipo IN (:tipoDanfe) and " 
						+ "       d1.codigoOperacao IN (:operacaoVenda) and "
						+ "       d1.dataEmissao between :dataInicial and :dataFinal  and " 
						+ "       d1.loja.codigo = l.codigo and "
						+ "       d1.loja.codigo IN (:loja) "
						+ "group by d1.loja.codigo) as troca, "
								+ "(select sum(d1.valorDocumento) "
								+ "from Documento d1 "
								+ "where  "
								+ "       d1.tipo IN (:tipoTroca) and " 
								+ "       d1.statusDanfe = 'A' and "
								+ "       d1.codigoOperacao IN(:operacaoTroca) and "
								+ "       d1.dataEmissao between :dataInicial and :dataFinal  and " 
								+ "       d1.loja.codigo = l.codigo and "
								+ "       d1.loja.codigo IN (:loja) "
								+ "group by d1.loja.codigo) as troca ) "
		+ "from Loja l  "
		+ "where l.codigo IN (:loja) ";
		
			List<VendasTotaisDTO> vendasPorPeriodo = manager.createQuery(jpql, VendasTotaisDTO.class)
			.setParameter("operacaoVenda", operacaoVenda)
			.setParameter("operacaoTroca", operacaoTroca)
			.setParameter("tipoDanfe", tipoDanfe)
			.setParameter("tipoPDV", tipoPDV)
			.setParameter("tipoTroca", tipoTroca)
			.setParameter("dataInicial", dataInicial)
			.setParameter("dataFinal", dataFinal)
			.setParameter("loja", lojasJab)
			.getResultList();
			
		return vendasPorPeriodo;
	}

	@Override
	public List<VendasTotaisDTO> SomatotalDeVendasPorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal) {
		
		Timestamp dataInicial = datasUtil.SysData(dataEmissaoInicial);
		Timestamp dataFinal= datasUtil.SysData(dataEmissaoFinal);

		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO("
				+ "sum(d1.valorDocumento), "
						+ "(select sum(d1.valorDocumento) "
						+ "from Documento d1 "
						+ "where d1.statusDocumento = 'E' and "
						+ "       d1.tipo IN (:tipoDanfe) and " 
						+ " 	   d1.statusDocumento = 'E' and "
						+ "       d1.codigoOperacao IN (:operacaoVenda) and "
						+ "       d1.dataEmissao between :dataInicial and :dataFinal  " 
						+ ") as troca, "
								+ "(select sum(d1.valorDocumento) "
								+ "from Documento d1 "
								+ "where "
								+ "       d1.tipo IN (:tipoTroca) and " 
								+ " 	   d1.statusDocumento = 'E' and "
								+ "       d1.statusDanfe = 'A' and "
								+ "       d1.codigoOperacao IN(:operacaoTroca) and "
								+ "       d1.dataEmissao between :dataInicial and :dataFinal   " 
								+ ") as troca ) "
					+ "from Documento d1 "
					+ "where d1.statusDocumento = 'E' and "
					+ "       d1.tipo IN (:tipoPDV) and " 
					+ " 	   d1.statusDocumento = 'E' and "
					+ "       d1.codigoOperacao IN (:operacaoVenda) and "
					+ "       d1.dataEmissao between :dataInicial and :dataFinal "; 
		
		List<VendasTotaisDTO> somaVendasPorPeriodo = manager.createQuery(jpql, VendasTotaisDTO.class)
		.setParameter("operacaoVenda", operacaoVenda)
		.setParameter("operacaoTroca", operacaoTroca)
		.setParameter("tipoDanfe", tipoDanfe)
		.setParameter("tipoPDV", tipoPDV)
		.setParameter("tipoTroca", tipoTroca)
		.setParameter("dataInicial", dataInicial)
		.setParameter("dataFinal", dataFinal)
		.getResultList();
		
		return somaVendasPorPeriodo;
	}
	
	@Override
	public List<VendaContribucaoMarca> SomaContribuicaoMarcaDia_jab() {
		String jpql = "select new com.sysconard.Glojas.DTO.VendaContribucaoMarca("
						+ "m.descricao, sum(its.valorLiquido) as Total) "
						+ "from Documento d join "
							+ "d.itensVendidos its join "
							+ "its.referencia r join "
							+ "r.produto p join "
							+ "p.marca m "
						+ "where d.statusDocumento = 'E' and "
							+ "d.tipo IN (:tipoPDVEDanfe) and "
							+ "d.codigoOperacao IN (:operacaoVenda) and "
							+ "d.dataEmissao = :dataEmissao and "
							+ "d.loja = its.loja and "
							+ "d.loja.codigo IN (:loja) "
						+ "group by m.descricao "
						+ "order by Total desc ";			

			List<VendaContribucaoMarca> contribuicaoMarcaDia = manager.createQuery(jpql, VendaContribucaoMarca.class)
						.setParameter("operacaoVenda", operacaoVenda)
						.setParameter("tipoPDVEDanfe", tipoPDVEDanfe)
						.setParameter("dataEmissao", hoje)
						.setParameter("loja", lojasJab)
						.getResultList();
			return contribuicaoMarcaDia;
	}
	
	@Override
	public List<VendaContribucaoMarca> TotalContribuicaoMarcaDia_jab() {
		String jpql = "select new com.sysconard.Glojas.DTO.VendaContribucaoMarca("
				+ "sum(its.valorLiquido), "
						+ "(select sum(its.valorLiquido) "
						+ "	from ItensVendidos its join "
								+ "its.documento d "
						+ "where d.statusDocumento = 'E' and "
								+ "d.tipo IN (:tipoTroca) and "
								+ "d.codigoOperacao IN (:operacaoTroca) and "
								+ "d.dataEmissao = :dataEmissao and "
								+ ") as troca "
				+ "from ItensVendidos its join "
				+ "its.documento d join "
				+ "its.referencia r join "
				+ "r.produto p "
				+ "where d.statusDocumento = 'E' and "
				+ "d.tipo IN (:tipoPDVEDanfe) and "
				+ "d.codigoOperacao IN (:operacaoVenda) and "
				+ "d.dataEmissao = :dataEmissao and "
				+ "d.loja = its.loja and "
				+ "d.loja.codigo IN (:loja) ";

			List<VendaContribucaoMarca> totalContribuicaoMarcaDia = manager.createQuery(jpql, VendaContribucaoMarca.class)
						.setParameter("operacaoVenda", operacaoVenda)
						.setParameter("tipoPDVEDanfe", tipoPDVEDanfe)
						.setParameter("dataEmissao", hoje)
						.setParameter("loja", lojasJab)
						.getResultList();
			return totalContribuicaoMarcaDia;
	}
	
	public BigDecimal ValorTotalContribuicaoMarcaDia_jab() {
		Optional<BigDecimal> optional = Optional.ofNullable(manager.createQuery("select sum(its.valorLiquido) "
					+ "from ItensVendidos its join "
					+ "its.documento d join "
					+ "its.referencia r join "
					+ "r.produto p "
					+ "where d.statusDocumento = 'E' and "
					+ "d.tipo IN (:tipoPDVEDanfe) and "
					+ "d.codigoOperacao IN (:operacaoVenda) and "
					+ "d.dataEmissao = :dataEmissao and "
					+ "d.loja = its.loja and "
					+ "d.loja.codigo IN (:loja) ", BigDecimal.class)
				.setParameter("operacaoVenda", operacaoVenda)
				.setParameter("tipoPDVEDanfe", tipoPDVEDanfe)
				.setParameter("dataEmissao", hoje)
				.setParameter("loja", lojasJab)
				.getSingleResult());
	
			return optional.orElse(BigDecimal.ZERO);
	}
	
	@Override
	public List<VendaContribucaoMarca> SomaContribuicaoMarcaMesAtual_jab() {
		String jpql = "select new com.sysconard.Glojas.DTO.VendaContribucaoMarca("
						+ "m.descricao, sum(its.valorLiquido) as Total) "
						+ "from Documento d join "
							+ "d.itensVendidos its join "
							+ "its.referencia r join "
							+ "r.produto p join "
							+ "p.marca m "
						+ "where d.statusDocumento = 'E' and "
							+ "d.tipo IN (:tipoPDVEDanfe) and "
							+ "d.codigoOperacao IN (:operacaoVenda) and "
							+ "d.dataEmissao between :primeiroDiaDoMesAtual and :ultimoDiaDoMesAtual and "
							+ "d.loja = its.loja and "
							+ "d.loja.codigo IN (:loja) "
						+ "group by m.descricao "
						+ "order by Total desc ";			

			List<VendaContribucaoMarca> contribuicaoMarcaDia = manager.createQuery(jpql, VendaContribucaoMarca.class)
						.setParameter("operacaoVenda", operacaoVenda)
						.setParameter("tipoPDVEDanfe", tipoPDVEDanfe)
						.setParameter("primeiroDiaDoMesAtual", primeiroDiaDoMesAtual)
						.setParameter("ultimoDiaDoMesAtual", ultimoDiaDoMesAtual)
						.setParameter("loja", lojasJab)
						.getResultList();
			return contribuicaoMarcaDia;
	}
	
	public BigDecimal ValorTotalContribuicaoMarcaMesAtual_jab() {
		Optional<BigDecimal> optional = Optional.ofNullable(manager.createQuery("select sum(its.valorLiquido) "
					+ "from ItensVendidos its join "
					+ "its.documento d join "
					+ "its.referencia r join "
					+ "r.produto p "
					+ "where d.statusDocumento = 'E' and "
					+ "d.tipo IN (:tipoPDVEDanfe) and "
					+ "d.codigoOperacao IN (:operacaoVenda) and "
					+ "d.dataEmissao between :primeiroDiaDoMesAtual and :ultimoDiaDoMesAtual and "
					+ "d.loja = its.loja and "
					+ "d.loja.codigo IN (:loja) ", BigDecimal.class)
				.setParameter("operacaoVenda", operacaoVenda)
				.setParameter("tipoPDVEDanfe", tipoPDVEDanfe)
				.setParameter("primeiroDiaDoMesAtual", primeiroDiaDoMesAtual)
				.setParameter("ultimoDiaDoMesAtual", ultimoDiaDoMesAtual)
				.setParameter("loja", lojasJab)
				.getSingleResult());
	
			return optional.orElse(BigDecimal.ZERO);
	}
	
	@Override
	public List<VendaContribucaoMarca> SomaContribuicaoMarcaPorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal) {
		Timestamp dataInicial = datasUtil.SysData(dataEmissaoInicial);
		Timestamp dataFinal= datasUtil.SysData(dataEmissaoFinal);
		String jpql = "select new com.sysconard.Glojas.DTO.VendaContribucaoMarca("
						+ "m.descricao, sum(its.valorLiquido) as Total) "
						+ "from Documento d join "
							+ "d.itensVendidos its join "
							+ "its.referencia r join "
							+ "r.produto p join "
							+ "p.marca m "
						+ "where d.statusDocumento = 'E' and "
							+ "d.tipo IN (:tipoPDVEDanfe) and "
							+ "d.codigoOperacao IN (:operacaoVenda) and "
							+ "d.dataEmissao between :dataInicial and :dataFinal and "
							+ "d.loja = its.loja and "
							+ "d.loja.codigo IN (:loja) "
						+ "group by m.descricao "
						+ "order by Total desc ";			

			List<VendaContribucaoMarca> contribuicaoMarcaDia = manager.createQuery(jpql, VendaContribucaoMarca.class)
						.setParameter("operacaoVenda", operacaoVenda)
						.setParameter("tipoPDVEDanfe", tipoPDVEDanfe)
						.setParameter("dataInicial", dataInicial)
						.setParameter("dataFinal", dataFinal)
						.setParameter("loja", lojasJab)
						.getResultList();
			return contribuicaoMarcaDia;
	}
	
	public BigDecimal ValorTotalContribuicaoMarcaPorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal) {
		Timestamp dataInicial = datasUtil.SysData(dataEmissaoInicial);
		Timestamp dataFinal= datasUtil.SysData(dataEmissaoFinal);
		
		Optional<BigDecimal> optional = Optional.ofNullable(manager.createQuery("select sum(its.valorLiquido) "
					+ "from ItensVendidos its join "
					+ "its.documento d join "
					+ "its.referencia r join "
					+ "r.produto p "
					+ "where d.statusDocumento = 'E' and "
					+ "d.tipo IN (:tipoPDVEDanfe) and "
					+ "d.codigoOperacao IN (:operacaoVenda) and "
					+ "d.dataEmissao between :dataInicial and :dataFinal and "
					+ "d.loja = its.loja and "
					+ "d.loja.codigo IN (:loja) ", BigDecimal.class)
				.setParameter("operacaoVenda", operacaoVenda)
				.setParameter("tipoPDVEDanfe", tipoPDVEDanfe)
				.setParameter("dataInicial", dataInicial)
				.setParameter("dataFinal", dataFinal)
				.setParameter("loja", lojasJab)
				.getSingleResult());
	
			return optional.orElse(BigDecimal.ZERO);
	}
	
	@Override
	public List<VendaContribucaoMarca> SomaContribuicaoGrupoPorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal) {
		Timestamp dataInicial = datasUtil.SysData(dataEmissaoInicial);
		Timestamp dataFinal= datasUtil.SysData(dataEmissaoFinal);
		String jpql = "select new com.sysconard.Glojas.DTO.VendaContribucaoMarca("
						+ "g.descricao, sum(its.valorLiquido) as Total) "
						+ "from Documento d join "
							+ "d.itensVendidos its join "
							+ "its.referencia r join "
							+ "r.produto p join "
							+ "p.grupo g "
						+ "where d.statusDocumento = 'E' and "
							+ "d.tipo IN (:tipoPDVEDanfe) and "
							+ "d.codigoOperacao IN (:operacaoVenda) and "
							+ "d.dataEmissao between :dataInicial and :dataFinal and "
							+ "d.loja = its.loja and "
							+ "p.secao = g.secao and "
							+ "d.loja.codigo IN (:loja) "
						+ "group by g.descricao "
						+ "order by Total desc ";			

			List<VendaContribucaoMarca> contribuicaoMarcaDia = manager.createQuery(jpql, VendaContribucaoMarca.class)
						.setParameter("operacaoVenda", operacaoVenda)
						.setParameter("tipoPDVEDanfe", tipoPDVEDanfe)
						.setParameter("dataInicial", dataInicial)
						.setParameter("dataFinal", dataFinal)
						.setParameter("loja", lojasJab)
						.getResultList();
			return contribuicaoMarcaDia;
	}
	
	@Override
	public List<VendaContribucaoMarca> SomaContribuicaoSubGrupoPorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal) {
		Timestamp dataInicial = datasUtil.SysData(dataEmissaoInicial);
		Timestamp dataFinal= datasUtil.SysData(dataEmissaoFinal);
		String jpql = "select new com.sysconard.Glojas.DTO.VendaContribucaoMarca("
						+ "sb.descricao, sum(its.valorLiquido) as Total) "
						+ "from Documento d join "
							+ "d.itensVendidos its join "
							+ "its.referencia r join "
							+ "r.produto p join "
							+ "p.grupo g join "
							+ "p.subgrupo sb "
						+ "where d.statusDocumento = 'E' and "
							+ "d.tipo IN (:tipoPDVEDanfe) and "
							+ "d.codigoOperacao IN (:operacaoVenda) and "
							+ "d.dataEmissao between :dataInicial and :dataFinal and "
							+ "d.loja = its.loja and "
							+ "p.secao = g.secao and "
							+ "p.grupo = sb.grupo and "
							+ "p.secao = sb.secao and "
							+ "d.loja.codigo IN (:loja) "
						+ "group by sb.descricao "
						+ "order by Total desc ";			

			List<VendaContribucaoMarca> contribuicaoMarcaDia = manager.createQuery(jpql, VendaContribucaoMarca.class)
						.setParameter("operacaoVenda", operacaoVenda)
						.setParameter("tipoPDVEDanfe", tipoPDVEDanfe)
						.setParameter("dataInicial", dataInicial)
						.setParameter("dataFinal", dataFinal)
						.setParameter("loja", lojasJab)
						.getResultList();
			return contribuicaoMarcaDia;
	}
	
}	
