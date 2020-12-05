package com.sysconard.Glojas.repository.helper.funcionario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sysconard.Glojas.DTO.dashboard.InfoVendedoresDashboardDTO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import com.sysconard.Glojas.model.Funcionario;
import com.sysconard.Glojas.repository.filter.FuncionarioFilter;
import com.sysconard.Glojas.repository.paginacao.PaginacaoUtil;

import java.sql.Timestamp;
import java.util.List;

public class FuncionariosImpl implements FuncionariosQueries {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private PaginacaoUtil paginacaoUtil;

	@SuppressWarnings("unchecked")
	@Override
	public Page<Funcionario> filtrar(FuncionarioFilter filtro, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Funcionario.class);

		Sort sort = pageable.getSort();
		if (sort != null) {
			Sort.Order order = sort.iterator().next();
			String property = order.getProperty();
			criteria.addOrder(order.isAscending() ? Order.asc(property) : Order.desc(property));
		}

		paginacaoUtil.preparar(criteria, pageable);
		adicionarFiltro(filtro, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}

	@Override
	public List<InfoVendedoresDashboardDTO> recuperarValorTotalVendas(List<String> tipo, List<String> operacao, Timestamp dataInicial, Timestamp dataFinal) {
		return manager.createNamedQuery("infoVendedores.recuperarVendedorValor", InfoVendedoresDashboardDTO.class)
				.setParameter("tipo", tipo)
				.setParameter("operacao", operacao)
				.setParameter("dataInicial", dataInicial)
				.setParameter("dataFinal", dataFinal)
				.getResultList();
	}

	@Override
	public List<InfoVendedoresDashboardDTO> recuperarQuantidadeProdutoVendido(List<String> tipo, List<String> operacao, Timestamp dataInicial, Timestamp dataFinal) {
		return manager.createNamedQuery("infoVendedores.recuperarVendedorQuantidade", InfoVendedoresDashboardDTO.class)
				.setParameter("tipo", tipo)
				.setParameter("operacao", operacao)
				.setParameter("dataInicial", dataInicial)
				.setParameter("dataFinal", dataFinal)
				.getResultList();
	}

	@Override
	public List<InfoVendedoresDashboardDTO> recuperarTotalTrocas(List<String> tipo, List<String> operacao, Timestamp dataInicial, Timestamp dataFinal) {
		return manager.createNamedQuery("infoVendedores.recuperarVendedorTroca", InfoVendedoresDashboardDTO.class)
				.setParameter("tipo", tipo)
				.setParameter("operacao", operacao)
				.setParameter("dataInicial", dataInicial)
				.setParameter("dataFinal", dataFinal)
				.getResultList();
	}

	private Long total(FuncionarioFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Funcionario.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void adicionarFiltro(FuncionarioFilter filtro, Criteria criteria) {
		criteria.createAlias("cargo", "c");
		criteria.createAlias("loja", "r");
		// criteria.createAlias("r.partNumber", "p");

		if (filtro != null) {
			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}

			if (!StringUtils.isEmpty(filtro.getCargo())) {
				criteria.add(Restrictions.ilike("c.descricao", filtro.getCargo(), MatchMode.ANYWHERE));
			}

			if (!StringUtils.isEmpty(filtro.getLoja())) {
				criteria.add(Restrictions.ilike("r.nome", filtro.getLoja(), MatchMode.ANYWHERE));
			}

		}
	}
}
