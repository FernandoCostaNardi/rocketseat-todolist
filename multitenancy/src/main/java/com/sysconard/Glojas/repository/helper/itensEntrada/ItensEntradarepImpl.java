package com.sysconard.Glojas.repository.helper.itensEntrada;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sysconard.Glojas.DTO.TrocasDetalhadasDTO;
import com.sysconard.Glojas.util.DatasUtil;
import com.sysconard.Glojas.util.LojasClientesUtil;
import com.sysconard.Glojas.util.OperacaoUtil;
import com.sysconard.Glojas.util.TipoUtil;

public class ItensEntradarepImpl  implements ItensEntradarepQueries {

	DatasUtil datasUtil = new DatasUtil();
	OperacaoUtil operacaoUtil = new OperacaoUtil();
	TipoUtil tipoUtil = new TipoUtil();
	LojasClientesUtil lojasClientesUtil = new LojasClientesUtil();
	
	@PersistenceContext
	private EntityManager manager;
	
	List<String> tipoTroca = tipoUtil.tipoTroca();
	List<String> operacaoTroca = operacaoUtil.operacaoTroca();
	List<Long> lojasJab = lojasClientesUtil.lojasJab();
	
	Timestamp hoje = datasUtil.SysDataDeHoje();
	
	@Override
	public List<TrocasDetalhadasDTO> trocasDetalhadasDoDia_jab() {
		String jpql = "select new com.sysconard.Glojas.DTO.TrocasDetalhadasDTO( " + "d.codigo " + ", d.numeroNota "
				+ ", d.loja.nome " + ", its.referencia.refplu" + ", its.referencia.produto.descricao"
				+ ", its.totalItens" + ", its.precoDeVenda) " + "from ItensEntrada its join " + "its.documento d "
				+ "where its.loja = d.loja and " + " d.tipo IN (:tipoTroca) and " + " d.statusDocumento = 'E' and "
				+ " d.codigoOperacao IN (:operacaoTroca) and " + " d.dataEmissao = :dataEmissao and "
				+ " d.loja.codigo IN (:loja) " + "order by d.loja.codigo";

		List<TrocasDetalhadasDTO> trocasDia = manager.createQuery(jpql, TrocasDetalhadasDTO.class)
				.setParameter("operacaoTroca", operacaoTroca).setParameter("tipoTroca", tipoTroca)
				.setParameter("dataEmissao", hoje).setParameter("loja", lojasJab).getResultList();

		return trocasDia;
	}

	@Override
	public List<TrocasDetalhadasDTO> trocasDetalhadasPorPeriodo_jab(String dataEmissaoInicial,
			String dataEmissaoFinal) {
		
		Timestamp dataInicial = datasUtil.SysData(dataEmissaoInicial);
		Timestamp dataFinal = datasUtil.SysData(dataEmissaoFinal);
		
		String jpql = "select new com.sysconard.Glojas.DTO.TrocasDetalhadasDTO( "
									+ "d.codigo " 
									+ ", d.numeroNota "
									+ ", d.loja.nome " 
									+ ", its.referencia.refplu" 
									+ ", its.referencia.produto.descricao"
									+ ", its.totalItens" 
									+ ", its.precoDeVenda) " 
							+ "from ItensEntrada its join " 
									+ "its.documento d "
							+ "where its.loja = d.loja and " 
									+ " d.tipo IN (:tipoTroca) and "
									+ " d.statusDocumento = 'E' and "
									+ " d.codigoOperacao IN (:operacaoTroca) and " 
									+ " d.dataEmissao between :dataInicial and :dataFinal and "
									+ " d.loja.codigo IN (:loja) " 
							+ "order by d.loja.codigo";

		List<TrocasDetalhadasDTO> trocasPorPeriodo = manager.createQuery(jpql, TrocasDetalhadasDTO.class)
				.setParameter("operacaoTroca", operacaoTroca)
				.setParameter("tipoTroca", tipoTroca)
				.setParameter("dataInicial", dataInicial)
				.setParameter("dataFinal", dataFinal)
				.setParameter("loja", lojasJab)
				.getResultList();

		return trocasPorPeriodo;
	}

}
