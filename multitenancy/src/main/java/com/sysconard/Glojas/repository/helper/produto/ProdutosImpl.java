package com.sysconard.Glojas.repository.helper.produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.sysconard.Glojas.DTO.CompraPesquisaRapidaDTO;
import com.sysconard.Glojas.DTO.ProdutoCadastradosDTO;
import com.sysconard.Glojas.model.Produto;
import com.sysconard.Glojas.repository.filter.ProdutoFilter;
import com.sysconard.Glojas.repository.paginacao.PaginacaoUtil;

public class ProdutosImpl implements ProdutosQueries {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private PaginacaoUtil paginacaoUtil;
	
	@Override
	public List<ProdutoCadastradosDTO> totalDeProdutosCadastrados() {

		String jpql = "select new com.sysconard.Glojas.DTO.ProdutoCadastradosDTO("
									+ "p.codigo "
									+ ", s.descricao "
									+ ", g.descricao "
									+ ", sb.descricao "
									+ ", m.descricao "
									+ ", rf.codigo "
									+ ", r.refplu "
									+ ", p.descricao "
									+ ", p.ncm)"
							+ " from Produto p "
									+ "join p.secao s "
									+ "join p.grupo g "
									+ "join p.subgrupo sb "
									+ "join p.marca m "
									+ "join p.referencia r "
									+ "left join r.partNumber rf " 
							+ "where s.codigo = g.secao.codigo "
									+ "and sb.grupo.codigo = g.codigo "
									+ "and sb.secao.codigo = s.codigo "
							+ "order by p.codigo";

		List<ProdutoCadastradosDTO> totalProdutos = manager.createQuery(jpql, ProdutoCadastradosDTO.class)
				.getResultList();

		return totalProdutos;
	}
	

	@Override
	public Page<Produto> filtrar(ProdutoFilter filtro, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Produto.class);

		paginacaoUtil.preparar(criteria, pageable);
		adicionarFiltro(filtro, criteria);
		 criteria.createAlias("secao", "s", JoinType.INNER_JOIN);
		 criteria.createAlias("grupo", "g", JoinType.INNER_JOIN);
		 criteria.createAlias("subgrupo", "sb", JoinType.INNER_JOIN);
		 criteria.createAlias("marca", "m", JoinType.INNER_JOIN);
		 criteria.createAlias("referencia", "r", JoinType.INNER_JOIN);
		 criteria.createAlias("r.partNumber", "p", JoinType.INNER_JOIN);
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}

	private Long total(ProdutoFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Produto.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void adicionarFiltro(ProdutoFilter filtro, Criteria criteria) {
//		criteria.createAlias("marca", "c");
//		criteria.createAlias("referencia", "r");
//		criteria.createAlias("r.partNumber", "p");


		if (filtro != null) {
			if (!StringUtils.isEmpty(filtro.getDescricao())) {
				criteria.add(Restrictions.ilike("descricao", filtro.getDescricao(), MatchMode.ANYWHERE));
			}

			if (!StringUtils.isEmpty(filtro.getMarca())) {
				criteria.add(Restrictions.ilike("c.descricao", filtro.getMarca(), MatchMode.ANYWHERE));
			}

			if (!StringUtils.isEmpty(filtro.getRefplu())) {
				criteria.add(Restrictions.ilike("r.refplu", filtro.getRefplu(), MatchMode.ANYWHERE));
			}

			if (!StringUtils.isEmpty(filtro.getNcm())) {
				criteria.add(Restrictions.ilike("ncm", filtro.getNcm(), MatchMode.START));
			}

			if (!StringUtils.isEmpty(filtro.getPartNumber())) {
				criteria.add(Restrictions.ilike("p.codigo", filtro.getPartNumber(), MatchMode.ANYWHERE));
			}

		}
	}


	@Override
	public List<CompraPesquisaRapidaDTO> buscarDescricaoERefplu(String descricao) {
		String jpql = "select new com.sysconard.Glojas.DTO.CompraPesquisaRapidaDTO("
									+ " r.refplu "
									+ ", p.descricao) "
							+ " from Produto p "
									+ "join p.referencia r "
							+ " where p.descricao LIKE  :descricao "
							+ "order by p.codigo";

List<CompraPesquisaRapidaDTO> pesquisaProdutos = manager.createQuery(jpql, CompraPesquisaRapidaDTO.class)
.setParameter("descricao", "%" + descricao + "%")
.getResultList();

return pesquisaProdutos;
	}


	@Override
	public Produto encontrarProdutoPeloRefplu(String refplu) {
		Produto produto = manager
						.createQuery("select p from Produto p "
											+ "where p.referencia.refplu = :refplu " , Produto.class)
						.setParameter("refplu", refplu)
						.getSingleResult();

		return produto;
	}

}
