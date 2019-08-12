package com.sysconard.Glojas.repository.helper.comissao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sysconard.Glojas.DTO.ComissaoTotalDTO;
import com.sysconard.Glojas.DTO.GraficoVendasMes;
import com.sysconard.Glojas.DTO.VendasTotaisDTO;
import com.sysconard.Glojas.DTO.VendasTotaisDetalhadasDTO;
import com.sysconard.Glojas.util.DatasUtil;

public class ComissoesImpl implements ComissoesQueries {

	DatasUtil datasUtil = new DatasUtil();
	
	@PersistenceContext
	private EntityManager manager;

	Timestamp hoje = datasUtil.SysDataDeHoje();
	
	//***********************
	// Total de Vendas do Dia 
	//***********************
	@Override
	public BigDecimal valorTotalVendasDoDia() {
		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2016-01-03 00:00:00.0");
		Optional<BigDecimal> optional = Optional.ofNullable(manager
				.createQuery("select sum(c.valorUnitario) " + "from Comissao c join c.documento d "
						+ "where c.loja = d.loja and" + "		   d.tipo = '009' and "
						+ "          d.dataEmissao = :dia", BigDecimal.class)
				.setParameter("dia", timestamp).getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}
	
	@Override
	public BigDecimal valorTotalVendasDoDia_jab() {
//		Timestamp hoje = null;
//		try {
//			hoje = conversordeTimeStamp(datasUtil.diaDeHoje());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		List<String> ids = new ArrayList<String>();
		ids.add("015");
		ids.add("002");
		ids.add("009");
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		Optional<BigDecimal> optional = Optional.ofNullable(manager
				.createQuery("select sum(d.valorDocumento)"
								+ "from Documento d "
								+ "where d.statusDocumento = 'E' and "
								+ "       d.codigoOperacao IN(:operacao) and " 
								+ "		   d.tipo IN (:tipo) and "
								+ "       d.dataEmissao = :dia", BigDecimal.class)
				.setParameter("operacao", operacao)
				.setParameter("tipo", ids)
				.setParameter("dia", hoje)
				.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}
	
	@Override
	public BigDecimal valorTotalTrocasDoDia_jab() {
//		Timestamp hoje = null;
//		try {
//			hoje = conversordeTimeStamp(datasUtil.diaDeHoje());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000015");
		
		List<String> tipoTroca = new ArrayList<String>();
		tipoTroca.add("051");
		
		Optional<BigDecimal> optional = Optional.ofNullable(manager
				.createQuery("select sum(d.valorDocumento)"
								+ "from Documento d "
								+ "where d.statusDocumento = 'E' and "
								+ "       d.codigoOperacao IN(:operacao) and " 
								+ "       d.dataEmissao = :dia", BigDecimal.class)
				.setParameter("operacao", operacao)
				.setParameter("dia", hoje)
				.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}
	
	@Override
	public BigDecimal valorTotalPDVVendasDoDia_jab() {
//		Timestamp hoje = null;
//		try {
//			hoje = conversordeTimeStamp(datasUtil.diaDeHoje());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		Optional<BigDecimal> optional = Optional.ofNullable(manager
				.createQuery("select sum(d.valorDocumento)  "
								+ "from Documento d "
								+ "where d.statusDocumento = 'E' and "
								+ "       d.codigoOperacao IN(:operacao) and " 
								+ "		   d.tipo = '009' and "
								+ "          d.dataEmissao = :dia", BigDecimal.class)
				.setParameter("operacao", operacao)
				.setParameter("dia", hoje)
				.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}

	@Override
	public BigDecimal valorTotalDanfeVendasDoDia_jab() {
//		Timestamp hoje = null;
//		try {
//			hoje = conversordeTimeStamp(datasUtil.diaDeHoje());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		List<String> ids = new ArrayList<String>();
		ids.add("015");
		ids.add("002");
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		Optional<BigDecimal> optional = Optional.ofNullable(manager
				.createQuery("select sum(d.valorDocumento)  "
									+ "from Documento d "
									+ "where d.statusDocumento = 'E' and " 
									+ "       d.codigoOperacao IN(:operacao) and " 
									+ "		   d.tipo IN (:tipo) and "
									+ "       d.dataEmissao = :dia", BigDecimal.class)
				.setParameter("operacao", operacao)
				.setParameter("tipo", ids)
				.setParameter("dia", hoje)
				.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}
	
	//***********************
    // Total de Vendas por Mês
	//***********************

	@Override
	public BigDecimal valorTotalVendasDoMesAtual() {
		java.sql.Timestamp dataInicial = java.sql.Timestamp.valueOf("2016-01-01 00:00:00.0");
		java.sql.Timestamp dataFinal = java.sql.Timestamp.valueOf("2016-01-31 00:00:00.0");
		Optional<BigDecimal> optional = Optional
				.ofNullable(manager
						.createQuery("select sum(c.valorUnitario) " 
											+ "from Comissao c join c.documento d "
											+ "where c.loja = d.loja and" 
											+ "	     	   d.tipo = '009' and "
											+ "          d.dataEmissao between :dataInicial and :dataFinal", BigDecimal.class)
						.setParameter("dataInicial", dataInicial)
						.setParameter("dataFinal", dataFinal)
						.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}
	
	@Override
	public BigDecimal valorTotalVendasDoMesAtual_jab() {
		Timestamp dataInicial = null;
		try {
			dataInicial = conversordeTimeStamp(datasUtil.primeiroDiaDoMesString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataFinal = null;
		try {
			dataFinal = conversordeTimeStamp(datasUtil.UltimoDiaDoMesString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> ids = new ArrayList<String>();
		ids.add("015");
		ids.add("002");
		ids.add("009");
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		Optional<BigDecimal> optional = Optional
				.ofNullable(manager
						.createQuery("select sum(d.valorDocumento) " 
										+ "from Documento d "
										+ "where d.statusDocumento = 'E' and " 
										+ "       d.codigoOperacao IN(:operacao) and " 
										+ "		   d.tipo IN (:tipo) and "
										+ "       d.dataEmissao between :dataInicial and :dataFinal", BigDecimal.class)
						.setParameter("operacao", operacao)
						.setParameter("tipo", ids)
						.setParameter("dataInicial", dataInicial)
						.setParameter("dataFinal", dataFinal)
						.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}
	
	@Override
	public BigDecimal valorTotalTrocasDoMes_jab() {
		Timestamp dataInicial = null;
		try {
			dataInicial = conversordeTimeStamp(datasUtil.primeiroDiaDoMesString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataFinal = null;
		try {
			dataFinal = conversordeTimeStamp(datasUtil.UltimoDiaDoMesString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> operacaoTroca = new ArrayList<String>();
		operacaoTroca.add("000015");
		
		List<String> tipoTroca = new ArrayList<String>();
		tipoTroca.add("051");
		
		Optional<BigDecimal> optional = Optional.ofNullable(manager
				.createQuery("select sum(d.valorDocumento)"
								+ "from Documento d "
								+ "where d.statusDocumento = 'E' and "
								+ "       d.tipo IN (:tipoTroca) and " 
								+ "       d.codigoOperacao IN(:operacaoTroca) and "
								+ "       d.dataEmissao between :dataInicial and :dataFinal ", BigDecimal.class)
				.setParameter("operacaoTroca", operacaoTroca)
				.setParameter("tipoTroca", tipoTroca)
				.setParameter("dataInicial", dataInicial)
				.setParameter("dataFinal", dataFinal)
				.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}
	
	@Override
	public BigDecimal valorTotalPDVVendasDoMesAtual_jab() {
		Timestamp dataInicial = null;
		try {
			dataInicial = conversordeTimeStamp(datasUtil.primeiroDiaDoMesString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataFinal = null;
		try {
			dataFinal = conversordeTimeStamp(datasUtil.UltimoDiaDoMesString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		Optional<BigDecimal> optional = Optional
				.ofNullable(manager
						.createQuery("select sum(d.valorDocumento) " 
											+ "from Documento d "
											+ "where d.statusDocumento = 'E' and " 
											+ "       d.codigoOperacao IN(:operacao) and " 
											+ "		   d.tipo = '009' and "
											+ "       d.dataEmissao between :dataInicial and :dataFinal", BigDecimal.class)
						.setParameter("operacao", operacao)
						.setParameter("dataInicial", dataInicial)
						.setParameter("dataFinal", dataFinal)
						.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}

	@Override
	public BigDecimal valorTotalDanfeVendasDoMesAtual_jab() {
		Timestamp dataInicial = null;
		try {
			dataInicial = conversordeTimeStamp(datasUtil.primeiroDiaDoMesString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataFinal = null;
		try {
			dataFinal = conversordeTimeStamp(datasUtil.UltimoDiaDoMesString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> ids = new ArrayList<String>();
		ids.add("015");
		ids.add("002");
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		Optional<BigDecimal> optional = Optional
				.ofNullable(manager
						.createQuery("select sum(d.valorDocumento) " 
											+ "from Documento d "
											+ "where d.statusDocumento = 'E' and " 
											+ "       d.codigoOperacao IN(:operacao) and " 
											+ "		   d.tipo IN (:tipo) and "
											+ "       d.dataEmissao between :dataInicial and :dataFinal", BigDecimal.class)
						.setParameter("operacao", operacao)
						.setParameter("tipo", ids)
						.setParameter("dataInicial", dataInicial)
						.setParameter("dataFinal", dataFinal)
						.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}

	//***********************
    // Total de Vendas por Ano
	//***********************
	
	@Override
	public BigDecimal valorTotalVendasDoAnoAtual() {
		java.sql.Timestamp dataInicial = java.sql.Timestamp.valueOf("2016-01-01 00:00:00.0");
		java.sql.Timestamp dataFinal = java.sql.Timestamp.valueOf("2016-12-31 00:00:00.0");
		Optional<BigDecimal> optional = Optional.ofNullable(manager.createQuery(
				"select sum(c.valorUnitario) " + "from Comissao c join c.documento d " + "where c.loja = d.loja and"
						+ "	     	   " + "d.tipo = '009' and " + "d.dataEmissao between :dataInicial and :dataFinal",
				BigDecimal.class).setParameter("dataInicial", dataInicial).setParameter("dataFinal", dataFinal)
				.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}
	
	@Override
	public BigDecimal valorTotalVendasDoAnoAtual_jab() {
		Timestamp dataInicial = null;
		try {
			dataInicial = conversordeTimeStamp(datasUtil.primeiroDiaDoAnoString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataFinal = null;
		try {
			dataFinal = conversordeTimeStamp(datasUtil.UltimoDiaDoAnoString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<String> ids = new ArrayList<String>();
		ids.add("015");
		ids.add("002");
		ids.add("009");
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		Optional<BigDecimal> optional = Optional
				.ofNullable(manager
						.createQuery("select sum(d.valorDocumento) " 
										+ "from Documento d "
										+ "where d.statusDocumento = 'E' and " 
										+ "       d.codigoOperacao IN(:operacao) and " 
										+ "		   d.tipo IN (:tipo) and "
										+ "       d.dataEmissao between :dataInicial and :dataFinal", BigDecimal.class)
						.setParameter("operacao", operacao)
						.setParameter("tipo", ids)
						.setParameter("dataInicial", dataInicial)
						.setParameter("dataFinal", dataFinal)
						.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}

	@Override
	public BigDecimal valorTotalPDVVendasDoAnoAtual_jab() {
		Timestamp dataInicial = null;
		try {
			dataInicial = conversordeTimeStamp(datasUtil.primeiroDiaDoAnoString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataFinal = null;
		try {
			dataFinal = conversordeTimeStamp(datasUtil.UltimoDiaDoAnoString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		Optional<BigDecimal> optional = Optional
				.ofNullable(manager
						.createQuery("select sum(d.valorDocumento) " 
											+ "from Documento d "
											+ "where d.statusDocumento = 'E' and " 
											+ "       d.codigoOperacao IN(:operacao) and " 
											+ "		   d.tipo = '009' and "
											+ "       d.dataEmissao between :dataInicial and :dataFinal", BigDecimal.class)
						.setParameter("operacao", operacao)
						.setParameter("dataInicial", dataInicial)
						.setParameter("dataFinal", dataFinal)
						.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}

	@Override
	public BigDecimal valorTotalDanfeVendasDoAnoAtual_jab() {
		Timestamp dataInicial = null;
		try {
			dataInicial = conversordeTimeStamp(datasUtil.primeiroDiaDoAnoString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataFinal = null;
		try {
			dataFinal = conversordeTimeStamp(datasUtil.UltimoDiaDoAnoString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<String> ids = new ArrayList<String>();
		ids.add("015");
		ids.add("002");
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		Optional<BigDecimal> optional = Optional
				.ofNullable(manager
						.createQuery("select sum(d.valorDocumento) " 
											+ "from Documento d "
											+ "where d.statusDocumento = 'E' and " 
											+ "       d.codigoOperacao IN(:operacao) and " 
											+ "		   d.tipo IN (:tipo) and "
											+ "       d.dataEmissao between :dataInicial and :dataFinal", BigDecimal.class)
						.setParameter("operacao", operacao)
						.setParameter("tipo", ids)
						.setParameter("dataInicial", dataInicial)
						.setParameter("dataFinal", dataFinal)
						.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GraficoVendasMes> totalPorMes() {
		return manager.createNamedQuery("Vendas.totalPorMes").getResultList();

	}

	//***********************
    // Lista de Vendas por Dia
	//***********************
	
	@Override
	public List<VendasTotaisDTO> totalDeVendasDiaPorLoja() {
		java.sql.Timestamp dataEmissao = java.sql.Timestamp.valueOf("2016-01-03 00:00:00.0");

		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome, sum(c.valorUnitario)) "
				+ "from Comissao c join c.documento d join c.loja l " + "where c.loja = d.loja and "
				+ "d.tipo = '009' and " + "d.dataEmissao = :dataEmissao " + "group by l.nome, l.codigo "
				+ "order by l.codigo";

		List<VendasTotaisDTO> vendasDia = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("dataEmissao", dataEmissao).getResultList();

		return vendasDia;
	}
	@Override
	public List<VendasTotaisDTO> totalDeVendasDiaPorLoja_jab() {
//		Timestamp hoje = null;
//		try {
//			hoje = conversordeTimeStamp(datasUtil.diaDeHoje());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		List<String> tipoDanfe = new ArrayList<String>();
		tipoDanfe.add("015");
		tipoDanfe.add("002");
		
		List<String> tipoPDV = new ArrayList<String>();
		tipoPDV.add("009");
		
		List<String> tipoTroca = new ArrayList<String>();
		tipoTroca.add("051");
		
		List<String> operacaoVenda = new ArrayList<String>();
		operacaoVenda.add("000999");
		operacaoVenda.add("000007");
		
		List<String> operacaoTroca = new ArrayList<String>();
		operacaoTroca.add("000015");
		
		
		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome,  "
									+ "(select sum(d1.valorDocumento) "
									+ "from Documento d1 "
									+ "where d1.statusDocumento = 'E' and "
									+ "       d1.tipo IN (:tipoPDV) and " 
									+ "       d1.codigoOperacao IN (:operacaoVenda) and "
									+ "       d1.dataEmissao = :dataEmissao and " 
									+ "       d1.loja.codigo = l.codigo "
									+ "group by d1.loja.codigo) as troca2, "
											+ "(select sum(d1.valorDocumento) "
											+ "from Documento d1 "
											+ "where d1.statusDocumento = 'E' and "
											+ "       d1.tipo IN (:tipoDanfe) and " 
											+ "       d1.codigoOperacao IN (:operacaoVenda) and "
											+ "       d1.dataEmissao = :dataEmissao and " 
											+ "       d1.loja.codigo = l.codigo "
											+ "group by d1.loja.codigo) as troca, "
													+ "(select sum(d1.valorDocumento) "
													+ "from Documento d1 "
													+ "where d1.statusDocumento = 'E' and "
													+ "       d1.tipo IN (:tipoTroca) and " 
													+ "       d1.codigoOperacao IN(:operacaoTroca) and "
													+ "       d1.dataEmissao = :dataEmissao and " 
													+ "       d1.loja.codigo = l.codigo "
													+ "group by d1.loja.codigo) as troca ) "
						+ "from Loja l  ";

		List<VendasTotaisDTO> vendasDia = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("operacaoVenda", operacaoVenda)
				.setParameter("operacaoTroca", operacaoTroca)
				.setParameter("tipoDanfe", tipoDanfe)
				.setParameter("tipoPDV", tipoPDV)
				.setParameter("tipoTroca", tipoTroca)
				.setParameter("dataEmissao", hoje)
				.getResultList();

		return vendasDia;
	}

	@Override
	public List<VendasTotaisDTO> totalDeVendasPDVDiaPorLoja_jab() {
//		Timestamp hoje = null;
//		try {
//			hoje = conversordeTimeStamp(datasUtil.diaDeHoje());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		List<String> operacaoTroca = new ArrayList<String>();
		operacaoTroca.add("000015");
		
		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome, sum(d.valorDocumento))  "
				+ "from Documento d "
						+ "join d.loja l " 
				+ "where d.statusDocumento = 'E' and "
						+ "d.codigoOperacao IN(:operacao) and " 
						+ "d.tipo = '009' and " 
						+ "d.dataEmissao = :dataEmissao " 
				+ "group by l.nome, l.codigo "
				+ "order by l.codigo";

		List<VendasTotaisDTO> vendasDia = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("operacao", operacao)
				.setParameter("dataEmissao", hoje)
				.getResultList();

		return vendasDia;
	}

	@Override
	public List<VendasTotaisDTO> totalDeVendasDanfeDiaPorLoja_jab() {
//		Timestamp hoje = null;
//		try {
//			hoje = conversordeTimeStamp(datasUtil.diaDeHoje());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		List<String> ids = new ArrayList<String>();
		ids.add("015");
		ids.add("002");
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		List<String> operacaoTroca = new ArrayList<String>();
		operacaoTroca.add("000015");
		
		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome, sum(d.valorDocumento))  "
						+ "from Documento d "
								+ "join d.loja l " 
						+ "where d.statusDocumento = 'E' and "
								+ "d.tipo In (:tipo) and " 
								+ "d.codigoOperacao IN(:operacao) and " 
								+ "d.dataEmissao = :dataEmissao " 
								+ "group by l.nome, l.codigo "
						+ "order by l.codigo";

		List<VendasTotaisDTO> vendasDia = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("operacao", operacao)
				.setParameter("tipo", ids)
				.setParameter("dataEmissao", hoje)
				.getResultList();

		return vendasDia;
	}
	
	//***********************
    // Lista de Vendas por Mês
	//***********************
	
	@Override
	public List<VendasTotaisDTO> totalDeVendasDoMesPorLoja() {
		java.sql.Timestamp dataInicial = java.sql.Timestamp.valueOf("2016-01-01 00:00:00.0");
		java.sql.Timestamp dataFinal = java.sql.Timestamp.valueOf("2016-01-31 00:00:00.0");

		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome, sum(c.valorUnitario)) "
				+ "from Comissao c join c.documento d join c.loja l " + "where c.loja = d.loja and "
				+ "d.tipo = '009' and " + "d.dataEmissao between :dataInicial and :dataFinal "
				+ "group by l.nome, l.codigo " + "order by l.codigo";

		List<VendasTotaisDTO> vendasMes = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("dataInicial", dataInicial).setParameter("dataFinal", dataFinal).getResultList();

		return vendasMes;
	}

	@Override
	public List<VendasTotaisDTO> totalDeVendasDoMesPorLoja_jab() {
		Timestamp dataInicial = null;
		try {
			dataInicial = conversordeTimeStamp(datasUtil.primeiroDiaDoMesString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataFinal = null;
		try {
			dataFinal = conversordeTimeStamp(datasUtil.UltimoDiaDoMesString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> tipoDanfe = new ArrayList<String>();
		tipoDanfe.add("015");
		tipoDanfe.add("002");
		
		List<String> tipoPDV = new ArrayList<String>();
		tipoPDV.add("009");
		
		List<String> tipoTroca = new ArrayList<String>();
		tipoTroca.add("051");
		
		List<String> operacaoVenda = new ArrayList<String>();
		operacaoVenda.add("000999");
		operacaoVenda.add("000007");
		
		List<String> operacaoTroca = new ArrayList<String>();
		operacaoTroca.add("000015");
		
		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome, sum(d.valorDocumento),  "
										+ "(select sum(d1.valorDocumento) "
										+ "from Documento d1 "
										+ "where d1.statusDocumento = 'E' and "
										+ "       d1.tipo IN (:tipoDanfe) and " 
										+ "       d1.codigoOperacao IN (:operacaoVenda) and "
										+ "       d1.dataEmissao between :dataInicial and :dataFinal and " 
										+ "       d1.loja.codigo = l.codigo "
										+ "group by d1.loja.codigo) as troca, "
												+ "(select sum(d1.valorDocumento) "
												+ "from Documento d1 "
												+ "where d1.statusDocumento = 'E' and "
												+ "       d1.tipo IN (:tipoTroca) and " 
												+ "       d1.codigoOperacao IN(:operacaoTroca) and "
												+ "       d1.dataEmissao between :dataInicial and :dataFinal and " 
												+ "       d1.loja.codigo = l.codigo "
												+ "group by d1.loja.codigo) as troca ) "
						+ "from Documento d "
							+ "join d.loja l " 
						+ "where d.statusDocumento = 'E' and "
							+ "d.tipo In (:tipoPDV) and " 
							+ "d.codigoOperacao IN(:operacaoVenda) and " 
							+ "d.dataEmissao between :dataInicial and :dataFinal " 
							+ "group by l.nome, l.codigo "
						+ "order by l.codigo";

			List<VendasTotaisDTO> vendasMes = manager.createQuery(jpql, VendasTotaisDTO.class)
			.setParameter("operacaoVenda", operacaoVenda)
			.setParameter("operacaoTroca", operacaoTroca)
			.setParameter("tipoDanfe", tipoDanfe)
			.setParameter("tipoPDV", tipoPDV)
			.setParameter("tipoTroca", tipoTroca)
			.setParameter("dataInicial", dataInicial)
			.setParameter("dataFinal", dataFinal)
			.getResultList();
		
		return vendasMes;
	}
	
	@Override
	public List<VendasTotaisDTO> totalDeVendasPDVDoMesPorLoja_jab() {
		Timestamp dataInicial = null;
		try {
			dataInicial = conversordeTimeStamp(datasUtil.primeiroDiaDoMesString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataFinal = null;
		try {
			dataFinal = conversordeTimeStamp(datasUtil.UltimoDiaDoMesString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome, sum(d.valorDocumento)) "
				+ "from Documento d "
						+ " join d.loja l " 
				+ "where d.statusDocumento = 'E' and "
						+ "d.codigoOperacao IN(:operacao) and " 
						+ "d.tipo = '009' and " 
						+ "d.dataEmissao between :dataInicial and :dataFinal " 
				+ "group by l.nome, l.codigo "
				+ "order by l.codigo";

		List<VendasTotaisDTO> vendasMes = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("operacao", operacao)
				.setParameter("dataInicial", dataInicial)
				.setParameter("dataFinal", dataFinal)
				.getResultList();

		return vendasMes;
	}

	@Override
	public List<VendasTotaisDTO> totalDeVendasDanfeDoMesPorLoja_jab() {
		Timestamp dataInicial = null;
		try {
			dataInicial = conversordeTimeStamp(datasUtil.primeiroDiaDoMesString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataFinal = null;
		try {
			dataFinal = conversordeTimeStamp(datasUtil.UltimoDiaDoMesString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> ids = new ArrayList<String>();
		ids.add("015");
		ids.add("002");
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome, sum(d.valorDocumento)) "
							+ "from Documento d "
									+ "join d.loja l " 
							+ "where d.statusDocumento = 'E' and "
									+ "d.codigoOperacao IN(:operacao) and " 
									+ "d.tipo IN (:tipo) and " 
									+ "d.dataEmissao between :dataInicial and :dataFinal " 
							+ "group by l.nome, l.codigo "
							+ "order by l.codigo";

		List<VendasTotaisDTO> vendasMes = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("operacao", operacao)
				.setParameter("tipo", ids)
				.setParameter("dataInicial", dataInicial)
				.setParameter("dataFinal", dataFinal)
				.getResultList();

		return vendasMes;
	}
	
	//***********************
    // Lista de Vendas por Ano
	//***********************

	@Override
	public List<VendasTotaisDTO> totalDeVendasDoAnoPorLoja() {
		java.sql.Timestamp dataInicial = java.sql.Timestamp.valueOf("2016-01-01 00:00:00.0");
		java.sql.Timestamp dataFinal = java.sql.Timestamp.valueOf("2016-12-31 00:00:00.0");

		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome, sum(c.valorUnitario)) "
						+ "from Comissao c join c.documento d join c.loja l " + "where c.loja = d.loja and "
				+ "d.tipo = '009' and " + "d.dataEmissao between :dataInicial and :dataFinal "
				+ "group by l.nome, l.codigo " + "order by l.codigo";

		List<VendasTotaisDTO> vendasAno = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("dataInicial", dataInicial).setParameter("dataFinal", dataFinal).getResultList();

		return vendasAno;
	}
	
	@Override
	public List<VendasTotaisDTO> totalDeVendasDoAnoPorLoja_jab() {
		Timestamp dataInicial = null;
		try {
			dataInicial = conversordeTimeStamp(datasUtil.primeiroDiaDoAnoString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataFinal = null;
		try {
			dataFinal = conversordeTimeStamp(datasUtil.UltimoDiaDoAnoString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> ids = new ArrayList<String>();
		ids.add("015");
		ids.add("002");
		ids.add("009");
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome, sum(d.valorDocumento)) "
						+ "from Documento d "
								+ "join d.loja l " 
						+ "where d.statusDocumento = 'E' and "
								+ "d.codigoOperacao IN(:operacao) and " 
								+ "d.tipo IN (:tipo) and " 
								+ "d.dataEmissao between :dataInicial and :dataFinal " 
						+ "group by l.nome, l.codigo "
						+ "order by l.codigo";

		List<VendasTotaisDTO> vendasAno = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("operacao", operacao)
				.setParameter("tipo", ids)
				.setParameter("dataInicial", dataInicial)
				.setParameter("dataFinal", dataFinal)
				.getResultList();

		return vendasAno;
	}

	@Override
	public List<VendasTotaisDTO> totalDeVendasPDVDoAnoPorLoja_jab() {
		Timestamp dataInicial = null;
		try {
			dataInicial = conversordeTimeStamp(datasUtil.primeiroDiaDoAnoString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataFinal = null;
		try {
			dataFinal = conversordeTimeStamp(datasUtil.UltimoDiaDoAnoString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome, sum(d.valorDocumento)) "
							+ "from Documento d "
									+ "join d.loja l " 
							+ "where d.statusDocumento = 'E' and "
									+ "d.codigoOperacao IN(:operacao) and " 
									+ "d.tipo = '009' and " 
									+ "d.dataEmissao between :dataInicial and :dataFinal " 
							+ "group by l.nome, l.codigo "
							+ "order by l.codigo";

		List<VendasTotaisDTO> vendasAno = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("operacao", operacao)
				.setParameter("dataInicial", dataInicial)
				.setParameter("dataFinal", dataFinal)
				.getResultList();

		return vendasAno;
	}

	@Override
	public List<VendasTotaisDTO> totalDeVendasDanfeDoAnoPorLoja_jab() {
		Timestamp dataInicial = null;
		try {
			dataInicial = conversordeTimeStamp(datasUtil.primeiroDiaDoAnoString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataFinal = null;
		try {
			dataFinal = conversordeTimeStamp(datasUtil.UltimoDiaDoAnoString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> ids = new ArrayList<String>();
		ids.add("015");
		ids.add("002");
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome, sum(d.valorDocumento)) "
						+ "from Documento d "
								+ "join d.loja l " 
						+ "where d.statusDocumento = 'E' and "
								+ "d.codigoOperacao IN(:operacao) and " 
								+ "d.tipo IN (:tipo) and " 
								+ "d.dataEmissao between :dataInicial and :dataFinal " 
						+ "group by l.nome, l.codigo "
						+ "order by l.codigo";

		List<VendasTotaisDTO> vendasAno = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("operacao", operacao)
				.setParameter("tipo", ids)
				.setParameter("dataInicial", dataInicial)
				.setParameter("dataFinal", dataFinal)
				.getResultList();

		return vendasAno;
	}

	//***********************
	// Total de Vendas por Período
	//***********************
	@Override
	public BigDecimal valorTotalVendasPorPeriodo(String dataEmissaoInicial, String dataEmissaoFinal) {
		Timestamp dataEmissaoInicialTime = null;
		try {
			dataEmissaoInicialTime = conversordeTimeStamp(dataEmissaoInicial);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataEmissaoFinalTime = null;
		try {
			dataEmissaoFinalTime = conversordeTimeStamp(dataEmissaoFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<String> ids = new ArrayList<String>();
		ids.add("015");
		ids.add("002");
		ids.add("009");
		
		Optional<BigDecimal> optional = Optional
				.ofNullable(manager
						.createQuery("select sum(c.valorUnitario) " + "from Comissao c join c.documento d "
								+ "where c.loja = d.loja and" + "	    	  d.tipo = 009 and "
								+ "          d.dataEmissao between :dataInicial and :dataFinal ", BigDecimal.class)
						.setParameter("tipo", ids)
						.setParameter("dataInicial", dataEmissaoInicialTime)
						.setParameter("dataFinal", dataEmissaoFinalTime).getSingleResult());

		return optional.orElse(BigDecimal.ZERO);

	}

	@Override
	public BigDecimal valorTotalVendasPorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal) {
		Timestamp dataEmissaoInicialTime = null;
		try {
			dataEmissaoInicialTime = conversordeTimeStamp(dataEmissaoInicial);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataEmissaoFinalTime = null;
		try {
			dataEmissaoFinalTime = conversordeTimeStamp(dataEmissaoFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> ids = new ArrayList<String>();
		ids.add("015");
		ids.add("002");
		ids.add("009");
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		operacao.add("000001");
		
		Optional<BigDecimal> optional = Optional
				.ofNullable(manager
						.createQuery("select sum(d.valorDocumento) " 
											+ "from Documento d "
											+ "where d.statusDocumento = 'E' and " 
											+ "          d.codigoOperacao IN(:operacao) and " 
											+ "	    	  d.tipo IN (:tipo) and " 
											+ "          d.dataEmissao between :dataInicial and :dataFinal ", BigDecimal.class)
						.setParameter("operacao", operacao)
						.setParameter("tipo", ids)
						.setParameter("dataInicial", dataEmissaoInicialTime)
						.setParameter("dataFinal", dataEmissaoFinalTime).getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}
	
	@Override
	public BigDecimal valorTotalVendasPDVPorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal) {
		Timestamp dataEmissaoInicialTime = null;
		try {
			dataEmissaoInicialTime = conversordeTimeStamp(dataEmissaoInicial);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataEmissaoFinalTime = null;
		try {
			dataEmissaoFinalTime = conversordeTimeStamp(dataEmissaoFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");

		Optional<BigDecimal> optional = Optional
				.ofNullable(manager
						.createQuery("select sum(d.valorDocumento) " 
											+ "from Documento d "
											+ "where d.statusDocumento = 'E' and " 
											+ "          d.codigoOperacao IN(:operacao) and " 
											+ "	    	  d.tipo = '009' and " 
											+ "          d.dataEmissao between :dataInicial and :dataFinal ", BigDecimal.class)
						.setParameter("operacao", operacao)
						.setParameter("dataInicial", dataEmissaoInicialTime)
						.setParameter("dataFinal", dataEmissaoFinalTime)
						.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}

	@Override
	public BigDecimal valorTotalVendasDanfePorPeriodo_jab(String dataEmissaoInicial, String dataEmissaoFinal) {
		Timestamp dataEmissaoInicialTime = null;
		try {
			dataEmissaoInicialTime = conversordeTimeStamp(dataEmissaoInicial);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataEmissaoFinalTime = null;
		try {
			dataEmissaoFinalTime = conversordeTimeStamp(dataEmissaoFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> ids = new ArrayList<String>();
		ids.add("015");
		ids.add("002");
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		Optional<BigDecimal> optional = Optional
				.ofNullable(manager
						.createQuery("select sum(d.valorDocumento) " 
											+ "from Documento d "
											+ "where d.statusDocumento = 'E' and " 
											+ "          d.codigoOperacao IN(:operacao) and " 
											+ "	    	  d.tipo IN (:tipo) and " 
											+ "          d.dataEmissao between :dataInicial and :dataFinal ", BigDecimal.class)
						.setParameter("operacao", operacao)
						.setParameter("tipo", ids)
						.setParameter("dataInicial", dataEmissaoInicialTime)
						.setParameter("dataFinal", dataEmissaoFinalTime)
						.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}
	
	//***********************
	// Lista de total de Vendas por Período
	//***********************
	@Override
	public List<VendasTotaisDTO> totalDeVendasPorPeriodoPorLoja(String dataEmissaoInicial, String dataEmissaoFinal) {

		Timestamp dataEmissaoInicialTime = null;
		try {
			dataEmissaoInicialTime = conversordeTimeStamp(dataEmissaoInicial);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataEmissaoFinalTime = null;
		try {
			dataEmissaoFinalTime = conversordeTimeStamp(dataEmissaoFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome, sum(c.valorUnitario)) "
				+ "from Comissao c join c.documento d join c.loja l " + "where c.loja = d.loja and "
				+ "d.tipo = '009' and " + "d.dataEmissao between :dataInicial and :dataFinal "
				+ "group by l.nome, l.codigo " + "order by l.codigo";

		List<VendasTotaisDTO> vendasAno = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("dataInicial", dataEmissaoInicialTime).setParameter("dataFinal", dataEmissaoFinalTime)
				.getResultList();

		return vendasAno;
	}
	
	@Override
	public List<VendasTotaisDTO> totalDeVendasPorPeriodoPorLoja_jab(String dataEmissaoInicial,
		String dataEmissaoFinal) {
		Timestamp dataEmissaoInicialTime = null;
		try {
			dataEmissaoInicialTime = conversordeTimeStamp(dataEmissaoInicial);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataEmissaoFinalTime = null;
		try {
			dataEmissaoFinalTime = conversordeTimeStamp(dataEmissaoFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<String> ids = new ArrayList<String>();
		ids.add("015");
		ids.add("002");
		ids.add("009");
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome, sum(d.valorDocumento)) "
							+ "from Documento d join d.loja l " 
							+ "where d.tipo IN (:tipo) and "
										+ "d.statusDocumento = 'E' and "
										+ "d.codigoOperacao IN(:operacao) and " 
										+ "d.dataEmissao between :dataInicial and :dataFinal "
							+ "group by l.nome, l.codigo " 
							+ "order by l.codigo";

		List<VendasTotaisDTO> vendasAno = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("operacao", operacao)
				.setParameter("tipo", ids)
				.setParameter("dataInicial", dataEmissaoInicialTime)
				.setParameter("dataFinal", dataEmissaoFinalTime)
				.getResultList();

		return vendasAno;
	}
	
	@Override
	public List<VendasTotaisDTO> totalDeVendasPDVPorPeriodoPorLoja_jab(String dataEmissaoInicial,
			String dataEmissaoFinal) {
		Timestamp dataEmissaoInicialTime = null;
		try {
			dataEmissaoInicialTime = conversordeTimeStamp(dataEmissaoInicial);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataEmissaoFinalTime = null;
		try {
			dataEmissaoFinalTime = conversordeTimeStamp(dataEmissaoFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");

		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome, sum(d.valorDocumento)) "
							+ "from Documento d join d.loja l " 
							+ "where d.statusDocumento = 'E' and "
										+ "d.codigoOperacao IN(:operacao) and " 
										+ "d.tipo = '009' and " 
										+ "d.dataEmissao between :dataInicial and :dataFinal "
							+ "group by l.nome, l.codigo " 
							+ "order by l.codigo";

		List<VendasTotaisDTO> vendasAno = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("operacao", operacao)
				.setParameter("dataInicial", dataEmissaoInicialTime)
				.setParameter("dataFinal", dataEmissaoFinalTime)
				.getResultList();

		return vendasAno;
	}

	@Override
	public List<VendasTotaisDTO> totalDeVendasDanfePorPeriodoPorLoja_jab(String dataEmissaoInicial,
			String dataEmissaoFinal) {
		Timestamp dataEmissaoInicialTime = null;
		try {
			dataEmissaoInicialTime = conversordeTimeStamp(dataEmissaoInicial);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataEmissaoFinalTime = null;
		try {
			dataEmissaoFinalTime = conversordeTimeStamp(dataEmissaoFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<String> ids = new ArrayList<String>();
		ids.add("015");
		ids.add("002");
		
		List<String> operacao = new ArrayList<String>();
		operacao.add("000999");
		operacao.add("000007");
		
		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDTO(l.nome, sum(d.valorDocumento)) "
							+ "from Documento d join d.loja l " 
							+ "where d.tipo IN (:tipo) and "
										+ "d.codigoOperacao IN(:operacao) and " 
										+ "d.statusDocumento = 'E' and " 
										+ "d.dataEmissao between :dataInicial and :dataFinal "
							+ "group by l.nome, l.codigo " 
							+ "order by l.codigo";

		List<VendasTotaisDTO> vendasAno = manager.createQuery(jpql, VendasTotaisDTO.class)
				.setParameter("operacao", operacao)
				.setParameter("tipo", ids)
				.setParameter("dataInicial", dataEmissaoInicialTime)
				.setParameter("dataFinal", dataEmissaoFinalTime)
				.getResultList();

		return vendasAno;
	}
	

	@Override
	public List<VendasTotaisDetalhadasDTO> vendasDetalhadasPorPeriodo(String dataEmissaoInicial,
			String dataEmissaoFinal) {

		Timestamp dataEmissaoInicialTime = null;
		try {
			dataEmissaoInicialTime = conversordeTimeStamp(dataEmissaoInicial);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataEmissaoFinalTime = null;
		try {
			dataEmissaoFinalTime = conversordeTimeStamp(dataEmissaoFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDetalhadasDTO(" + "d.loja.nome"
				+ ", c.referencia.produto.grupo.descricao" + ", c.referencia.refplu"
				+ ", c.referencia.partNumber.codigo" + ", c.referencia.produto.descricao"
				+ ", c.referencia.custo.custoReposicao" + ", d.itensVendidos.precoDeVenda"
				+ ", d.itensVendidos.valorDesconto" + ", c.valorUnitario) " + "from Comissao c join " + "c.documento d "
				+ "where c.loja = d.loja and " + "d.tipo = '009' and "
				+ "c.referencia.produto.secao = c.referencia.produto.grupo.secao and "
				+ "c.referencia.custo.loja.codigo = c.loja.codigo and "
				+ "d.itensVendidos.loja.codigo = c.loja.codigo and "
				+ "d.itensVendidos.referencia.refplu = c.referencia.refplu and "
				+ "d.itensVendidos.sequenciaItem = c.sequenciaItem and "
				+ "d.dataEmissao between :dataInicial and :dataFinal " + "order by d.loja.codigo";

		List<VendasTotaisDetalhadasDTO> vendasDetalhadas = manager.createQuery(jpql, VendasTotaisDetalhadasDTO.class)
				.setParameter("dataInicial", dataEmissaoInicialTime).setParameter("dataFinal", dataEmissaoFinalTime)
				.getResultList();

		return vendasDetalhadas;
	}

	@Override
	public List<ComissaoTotalDTO> comissoesTotaisPorPeriodo(String dataEmissaoInicial, String dataEmissaoFinal) {
		Timestamp dataEmissaoInicialTime = null;
		try {
			dataEmissaoInicialTime = conversordeTimeStamp(dataEmissaoInicial);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataEmissaoFinalTime = null;
		try {
			dataEmissaoFinalTime = conversordeTimeStamp(dataEmissaoFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String jpql = "select new com.sysconard.Glojas.DTO.ComissaoTotalDTO(" + "d.loja.nome"
				+ ", d.itensVendidos.funcionario.codigo" + ", d.itensVendidos.funcionario.nome"
				+ ", sum(d.itensVendidos.valorDesconto)" + ", sum(c.valorUnitario)"
				+ ", d.itensVendidos.funcionario.percentualComissao) " + "from Comissao c join " + "c.documento d "
				+ "where c.loja = d.loja and " + "d.tipo = '009' and "
				+ "d.itensVendidos.loja.codigo = c.loja.codigo and "
				+ "d.itensVendidos.referencia.refplu = c.referencia.refplu and "
				+ "d.itensVendidos.sequenciaItem = c.sequenciaItem and " + "d.itensVendidos.loja = c.loja and "
				+ "d.dataEmissao between :dataInicial and :dataFinal " + "group by d.loja.nome "
				+ ", d.itensVendidos.funcionario.codigo " + ", d.itensVendidos.funcionario.nome "
				+ ", d.itensVendidos.funcionario.percentualComissao " + "order by d.loja.nome "
				+ ", d.itensVendidos.funcionario.codigo";

		List<ComissaoTotalDTO> comissoesTotais = manager.createQuery(jpql, ComissaoTotalDTO.class)
				.setParameter("dataInicial", dataEmissaoInicialTime).setParameter("dataFinal", dataEmissaoFinalTime)
				.getResultList();

		return comissoesTotais;
	}

	@Override
	public BigDecimal valorTotalcomissoesPorPeriodo(String dataEmissaoInicial, String dataEmissaoFinal) {
		Timestamp dataEmissaoInicialTime = null;
		try {
			dataEmissaoInicialTime = conversordeTimeStamp(dataEmissaoInicial);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataEmissaoFinalTime = null;
		try {
			dataEmissaoFinalTime = conversordeTimeStamp(dataEmissaoFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Optional<BigDecimal> optional = Optional.ofNullable(manager
				.createQuery("select sum(c.valorUnitario * (d.itensVendidos.funcionario.percentualComissao / 100))"
						+ "from Comissao c " + "join c.documento d " + "where c.loja = d.loja and "
						+ "d.tipo = '009' and " + "d.itensVendidos.loja.codigo = c.loja.codigo and "
						+ "d.itensVendidos.referencia.refplu = c.referencia.refplu and "
						+ "d.itensVendidos.sequenciaItem = c.sequenciaItem and " + "d.itensVendidos.loja = c.loja and "
						+ "d.dataEmissao between :dataInicial and :dataFinal ", BigDecimal.class)
				.setParameter("dataInicial", dataEmissaoInicialTime).setParameter("dataFinal", dataEmissaoFinalTime)
				.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}

	@Override
	public BigDecimal valorTotalDescontoPorPeriodo(String dataEmissaoInicial, String dataEmissaoFinal) {
		Timestamp dataEmissaoInicialTime = null;
		try {
			dataEmissaoInicialTime = conversordeTimeStamp(dataEmissaoInicial);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataEmissaoFinalTime = null;
		try {
			dataEmissaoFinalTime = conversordeTimeStamp(dataEmissaoFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Optional<BigDecimal> optional = Optional.ofNullable(manager
				.createQuery("select sum(d.itensVendidos.valorDesconto)  " + "from Comissao c " + "join c.documento d "
						+ "where c.loja = d.loja and " + "d.tipo = '009' and "
						+ "d.itensVendidos.loja.codigo = c.loja.codigo and "
						+ "d.itensVendidos.referencia.refplu = c.referencia.refplu and "
						+ "d.itensVendidos.sequenciaItem = c.sequenciaItem and " + "d.itensVendidos.loja = c.loja and "
						+ "d.dataEmissao between :dataInicial and :dataFinal ", BigDecimal.class)
				.setParameter("dataInicial", dataEmissaoInicialTime).setParameter("dataFinal", dataEmissaoFinalTime)
				.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}

	public Timestamp conversordeTimeStamp(String data) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataconvertida = formato.parse(data);
		Timestamp timestamp = new Timestamp(dataconvertida.getTime());

		return timestamp;
	}

	@Override
	public List<VendasTotaisDetalhadasDTO> vendasDetalhadasPorPeriodo_jab(String dataEmissaoInicial,
			String dataEmissaoFinal) {
		Timestamp dataEmissaoInicialTime = null;
		try {
			dataEmissaoInicialTime = conversordeTimeStamp(dataEmissaoInicial);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataEmissaoFinalTime = null;
		try {
			dataEmissaoFinalTime = conversordeTimeStamp(dataEmissaoFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String jpql = "select new com.sysconard.Glojas.DTO.VendasTotaisDetalhadasDTO(" 
										+ "d.codigo"
										+ ", d.numeroNota"
										+ ", d.loja.nome"
										+ ", its.referencia.produto.grupo.descricao" 
										+ ", its.referencia.refplu"
										+ ", its.referencia.produto.descricao"
										+ ", its.referencia.custo.custoReposicao" 
										+ ", its.precoDeVenda"
										+ ", its.totalItens"
										+ ", its.valorDesconto" 
										+ ", its.valorLiquido) " 
							+ "from ItensVendidos its join " 
										+ "its.documento d "
							+ "where its.loja = d.loja and " 
											+ "d.tipo in ('009', '002', '015') and "
											+ "its.referencia.produto.secao = its.referencia.produto.grupo.secao and "
											+ "its.referencia.custo.loja.codigo = its.loja.codigo and "
											+ "d.dataEmissao between :dataInicial and :dataFinal " 
							+ "order by d.loja.codigo";

		List<VendasTotaisDetalhadasDTO> vendasDetalhadas = manager.createQuery(jpql, VendasTotaisDetalhadasDTO.class)
				.setParameter("dataInicial", dataEmissaoInicialTime).setParameter("dataFinal", dataEmissaoFinalTime)
				.getResultList();

		return vendasDetalhadas;
	}

	

	

	

	


}
