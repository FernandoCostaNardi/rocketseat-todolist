package com.sysconard.Glojas.repository.helper.ItensVendidos;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sysconard.Glojas.DTO.CompraGeralDTO;
import com.sysconard.Glojas.util.DatasUtil;
import com.sysconard.Glojas.util.LojasClientesUtil;
import com.sysconard.Glojas.util.OperacaoUtil;
import com.sysconard.Glojas.util.TipoUtil;

public class ItensVendidosrepImpl implements ItensVendidosrepQueries{

	DatasUtil datasUtil = new DatasUtil();
	OperacaoUtil operacaoUtil = new OperacaoUtil();
	TipoUtil tipoUtil = new TipoUtil();
	LojasClientesUtil lojasClientesUtil = new LojasClientesUtil();
	
	@PersistenceContext
	private EntityManager manager;
	
	List<String> tipoTroca = tipoUtil.tipoTroca();
	List<String> operacaoTroca = operacaoUtil.operacaoTroca();
	List<Long> lojasJab = lojasClientesUtil.lojasJab();
	List<String> tipoPDVEDanfe = tipoUtil.tipoPDVEDanfe();

	LocalDate now = LocalDate.now();
	Timestamp hoje = Timestamp.valueOf(now.atStartOfDay());
	
	@Override
	public List<CompraGeralDTO> buscaComprasGeral() {
		Timestamp dataInicial90 = null;
		try {
			dataInicial90 = conversordeTimeStamp(datasUtil.primeiroDiaDoMes_90diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataFinal90 = null;
		try {
			dataFinal90 = conversordeTimeStamp(datasUtil.UltimoDiaDoMes_90diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataInicial60 = null;
		try {
			dataInicial60 = conversordeTimeStamp(datasUtil.primeiroDiaDoMes_60diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataFinal60 = null;
		try {
			dataFinal60 = conversordeTimeStamp(datasUtil.UltimoDiaDoMes_60diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataInicial30 = null;
		try {
			dataInicial30 = conversordeTimeStamp(datasUtil.primeiroDiaDoMes_30diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp dataFinal30 = null;
		try {
			dataFinal30 = conversordeTimeStamp(datasUtil.UltimoDiaDoMes_30diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
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
		
		
			String jpql = "select new com.sysconard.Glojas.DTO.CompraGeralDTO(" 
											+ "g.descricao"
											+ ", pt.codigo "
											+ ", m.descricao "
											+ ", r.refplu "
											+ ", p.descricao"
															+ ", (select c.custoReposicao "
															+ "	 from Custo c "
															+ " where c.loja.codigo = 4 "
																	+ " and c.refplu = r.refplu) as custo "
															
															+ ", (select pr.precoVenda "
															+ " from Preco pr "
															+ " where pr.loja.codigo = 4 "
																	+ " and pr.refplu = r.refplu) as precoVenda "
																														
															+ ", (select sum(its.totalItens) as total90 "
															+ " from ItensVendidos its join "
																		+ "its.documento d "
															+ " where its.loja = d.loja "
																	+ " and d.tipo IN (:tipoPDVEDanfe) "
																	+ " and d.statusDocumento = 'E' "
																	+ " and its.referencia.refplu = r.refplu "
																	+ " and d.dataEmissao between :dataInicial90 and :dataFinal90 "
															+ " group by its.referencia.refplu) as Vendas90 "
																	
															+ ", (select sum(its.totalItens) as total60 "
															+ " from ItensVendidos its join "
																		+ "its.documento d "
															+ " where its.loja = d.loja "
																	+ " and d.tipo IN (:tipoPDVEDanfe) "
																	+ " and d.statusDocumento = 'E' "
																	+ " and its.referencia.refplu = r.refplu "
																	+ " and d.dataEmissao between :dataInicial60 and :dataFinal60 "
															+ " group by its.referencia.refplu) as Vendas60 "
																	
															+ ", (select sum(its.totalItens) as total30 "
															+ " from ItensVendidos its join "
																		+ "its.documento d "
															+ " where its.loja = d.loja "
																	+ " and d.tipo IN (:tipoPDVEDanfe) "
																	+ " and d.statusDocumento = 'E' "
																	+ " and its.referencia.refplu = r.refplu "
																	+ " and d.dataEmissao between :dataInicial30 and :dataFinal30 "
															+ " group by its.referencia.refplu) as Vendas30 "
																	
															+ ", (select sum(its.totalItens) as total "
															+ " from ItensVendidos its join "
																		+ "its.documento d "
															+ " where its.loja = d.loja "
																	+ " and d.tipo IN (:tipoPDVEDanfe) "
																	+ " and d.statusDocumento = 'E' "
																	+ " and its.referencia.refplu = r.refplu "
																	+ " and d.dataEmissao between :dataInicial and :dataFinal "
															+ " group by its.referencia.refplu) as Vendas "
																														
															+ ", (select sum(e.estoque) as est "
															+ " from Estoque e "
															+ " where e.localEstoque = '001' "
																	+ " and e.referencia.refplu = r.refplu "
															+ " group by e.referencia.refplu) as estoque "
											+ ") "
								+ "from Produto p " 
											+ "join p.grupo g "
											+ "join p.marca m "
											+ "join p.referencia r "
											+ "left join r.partNumber pt "
								+ "where g.secao = p.secao "
								+ "order by p.codigo";

			List<CompraGeralDTO> vendasTotais = manager.createQuery(jpql, CompraGeralDTO.class)
			.setParameter("dataInicial90", dataInicial90).setParameter("dataFinal90", dataFinal90)
			.setParameter("dataInicial60", dataInicial60).setParameter("dataFinal60", dataFinal60)
			.setParameter("dataInicial30", dataInicial30).setParameter("dataFinal30", dataFinal30)
			.setParameter("dataInicial", dataInicial).setParameter("dataFinal", dataFinal)
			.setParameter("tipoPDVEDanfe", tipoPDVEDanfe)
			.getResultList();
			return vendasTotais;
	}

	@Override
	public List<CompraGeralDTO> buscaComprasGeralOex() {
		Timestamp dataInicial90 = null;
		try {
			dataInicial90 = conversordeTimeStamp(datasUtil.primeiroDiaDoMes_90diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataFinal90 = null;
		try {
			dataFinal90 = conversordeTimeStamp(datasUtil.UltimoDiaDoMes_90diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataInicial60 = null;
		try {
			dataInicial60 = conversordeTimeStamp(datasUtil.primeiroDiaDoMes_60diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataFinal60 = null;
		try {
			dataFinal60 = conversordeTimeStamp(datasUtil.UltimoDiaDoMes_60diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataInicial30 = null;
		try {
			dataInicial30 = conversordeTimeStamp(datasUtil.primeiroDiaDoMes_30diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataFinal30 = null;
		try {
			dataFinal30 = conversordeTimeStamp(datasUtil.UltimoDiaDoMes_30diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

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


		String jpql = "select new com.sysconard.Glojas.DTO.CompraGeralDTO("
				+ "g.descricao"
				+ ", pt.codigo "
				+ ", m.descricao "
				+ ", r.refplu "
				+ ", p.descricao"
				+ ", (select c.custoReposicao "
				+ "	 from Custo c "
				+ " where c.loja.codigo = 4 "
				+ " and c.refplu = r.refplu) as custo "

				+ ", (select pr.precoVenda "
				+ " from Preco pr "
				+ " where pr.loja.codigo = 4 "
				+ " and pr.refplu = r.refplu) as precoVenda "

				+ ", (select sum(its.totalItens) as total90 "
				+ " from ItensVendidos its join "
				+ "its.documento d "
				+ " where its.loja = d.loja "
				+ " and d.tipo IN (:tipoPDVEDanfe) "
				+ " and d.statusDocumento = 'E' "
				+ " and its.referencia.refplu = r.refplu "
				+ " and d.dataEmissao between :dataInicial90 and :dataFinal90 "
				+ " group by its.referencia.refplu) as Vendas90 "

				+ ", (select sum(its.totalItens) as total60 "
				+ " from ItensVendidos its join "
				+ "its.documento d "
				+ " where its.loja = d.loja "
				+ " and d.tipo IN (:tipoPDVEDanfe) "
				+ " and d.statusDocumento = 'E' "
				+ " and its.referencia.refplu = r.refplu "
				+ " and d.dataEmissao between :dataInicial60 and :dataFinal60 "
				+ " group by its.referencia.refplu) as Vendas60 "

				+ ", (select sum(its.totalItens) as total30 "
				+ " from ItensVendidos its join "
				+ "its.documento d "
				+ " where its.loja = d.loja "
				+ " and d.tipo IN (:tipoPDVEDanfe) "
				+ " and d.statusDocumento = 'E' "
				+ " and its.referencia.refplu = r.refplu "
				+ " and d.dataEmissao between :dataInicial30 and :dataFinal30 "
				+ " group by its.referencia.refplu) as Vendas30 "

				+ ", (select sum(its.totalItens) as total "
				+ " from ItensVendidos its join "
				+ "its.documento d "
				+ " where its.loja = d.loja "
				+ " and d.tipo IN (:tipoPDVEDanfe) "
				+ " and d.statusDocumento = 'E' "
				+ " and its.referencia.refplu = r.refplu "
				+ " and d.dataEmissao between :dataInicial and :dataFinal "
				+ " group by its.referencia.refplu) as Vendas "

				+ ", (select sum(e.estoque) as est "
				+ " from Estoque e "
				+ " where e.localEstoque = '001' "
				+ " and e.referencia.refplu = r.refplu "
				+ " group by e.referencia.refplu) as estoque "
				+ ") "
				+ "from Produto p "
				+ "join p.grupo g "
				+ "join p.marca m "
				+ "join p.referencia r "
				+ "left join r.partNumber pt "
				+ "where g.secao = p.secao "
				+ " and m.descricao in ('OEX', 'Cellution') "
				+ "order by p.codigo";

		List<CompraGeralDTO> vendasTotais = manager.createQuery(jpql, CompraGeralDTO.class)
				.setParameter("dataInicial90", dataInicial90).setParameter("dataFinal90", dataFinal90)
				.setParameter("dataInicial60", dataInicial60).setParameter("dataFinal60", dataFinal60)
				.setParameter("dataInicial30", dataInicial30).setParameter("dataFinal30", dataFinal30)
				.setParameter("dataInicial", dataInicial).setParameter("dataFinal", dataFinal)
				.setParameter("tipoPDVEDanfe", tipoPDVEDanfe)
				.getResultList();
		return vendasTotais;
	}

	@Override
	public List<CompraGeralDTO> buscaComprasGeralWCost() {
		Timestamp dataInicial90 = null;
		try {
			dataInicial90 = conversordeTimeStamp(datasUtil.primeiroDiaDoMes_90diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataFinal90 = null;
		try {
			dataFinal90 = conversordeTimeStamp(datasUtil.UltimoDiaDoMes_90diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataInicial60 = null;
		try {
			dataInicial60 = conversordeTimeStamp(datasUtil.primeiroDiaDoMes_60diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataFinal60 = null;
		try {
			dataFinal60 = conversordeTimeStamp(datasUtil.UltimoDiaDoMes_60diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataInicial30 = null;
		try {
			dataInicial30 = conversordeTimeStamp(datasUtil.primeiroDiaDoMes_30diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp dataFinal30 = null;
		try {
			dataFinal30 = conversordeTimeStamp(datasUtil.UltimoDiaDoMes_30diasString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

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


		String jpql = "select new com.sysconard.Glojas.DTO.CompraGeralDTO("
				+ "g.descricao"
				+ ", pt.codigo "
				+ ", m.descricao "
				+ ", r.refplu "
				+ ", p.descricao"

				+ ", (select c.custoReposicao "
				+ "	 from Custo c "
				+ " where c.loja.codigo = 4 "
				+ " and c.refplu = r.refplu) as custo "

				+ ", (select pr.precoVenda "
				+ " from Preco pr "
				+ " where pr.loja.codigo = 4 "
				+ " and pr.refplu = r.refplu) as precoVenda "

				+ ", (select sum(its.totalItens) as total90 "
				+ " from ItensVendidos its join "
				+ "its.documento d "
				+ " where its.loja = d.loja "
				+ " and d.tipo IN (:tipoPDVEDanfe) "
				+ " and d.statusDocumento = 'E' "
				+ " and its.referencia.refplu = r.refplu "
				+ " and d.dataEmissao between :dataInicial90 and :dataFinal90 "
				+ " group by its.referencia.refplu) as Vendas90 "

				+ ", (select sum(its.totalItens) as total60 "
				+ " from ItensVendidos its join "
				+ "its.documento d "
				+ " where its.loja = d.loja "
				+ " and d.tipo IN (:tipoPDVEDanfe) "
				+ " and d.statusDocumento = 'E' "
				+ " and its.referencia.refplu = r.refplu "
				+ " and d.dataEmissao between :dataInicial60 and :dataFinal60 "
				+ " group by its.referencia.refplu) as Vendas60 "

				+ ", (select sum(its.totalItens) as total30 "
				+ " from ItensVendidos its join "
				+ "its.documento d "
				+ " where its.loja = d.loja "
				+ " and d.tipo IN (:tipoPDVEDanfe) "
				+ " and d.statusDocumento = 'E' "
				+ " and its.referencia.refplu = r.refplu "
				+ " and d.dataEmissao between :dataInicial30 and :dataFinal30 "
				+ " group by its.referencia.refplu) as Vendas30 "

				+ ", (select sum(its.totalItens) as total "
				+ " from ItensVendidos its join "
				+ "its.documento d "
				+ " where its.loja = d.loja "
				+ " and d.tipo IN (:tipoPDVEDanfe) "
				+ " and d.statusDocumento = 'E' "
				+ " and its.referencia.refplu = r.refplu "
				+ " and d.dataEmissao between :dataInicial and :dataFinal "
				+ " group by its.referencia.refplu) as Vendas "

				+ ", (select sum(e.estoque) as est "
				+ " from Estoque e "
				+ " where e.localEstoque = '001' "
				+ " and e.referencia.refplu = r.refplu "
				+ " group by e.referencia.refplu) as estoque "
				+ ") "
				+ "from Produto p "
				+ "join p.grupo g "
				+ "join p.marca m "
				+ "join p.referencia r "
				+ "left join r.partNumber pt "
				+ "where g.secao = p.secao "
				+ "order by p.codigo";

		List<CompraGeralDTO> vendasTotais = manager.createQuery(jpql, CompraGeralDTO.class)
				.setParameter("dataInicial90", dataInicial90).setParameter("dataFinal90", dataFinal90)
				.setParameter("dataInicial60", dataInicial60).setParameter("dataFinal60", dataFinal60)
				.setParameter("dataInicial30", dataInicial30).setParameter("dataFinal30", dataFinal30)
				.setParameter("dataInicial", dataInicial).setParameter("dataFinal", dataFinal)
				.setParameter("tipoPDVEDanfe", tipoPDVEDanfe)
				.getResultList();
		return vendasTotais;
	}

	public Timestamp conversordeTimeStamp(String data) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataconvertida = formato.parse(data);
		Timestamp timestamp = new Timestamp(dataconvertida.getTime());

		return timestamp;
	}

	
	
	

}
