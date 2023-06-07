package com.sysconard.Glojas.repository.helper.estoque;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.sysconard.Glojas.DTO.EstoqueDTO;
import com.sysconard.Glojas.DTO.ProdutoCadastradosDTO;
import com.sysconard.Glojas.repository.Produtos;

public class EstoquesImpl implements EstoquesQueries {
		
	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("null")
	@Override
	public List<Object[]> buscaEstoqueDasLojas() {

		// String jpql = "select new
		// com.sysconard.Glojas.DTO.EstoqueDTO(r.refplu, p.marca.descricao,
		// p.descricao, e.estoque as estAldeota, "
		// + " (select e1.estoque as estIguatemi from Estoque e1 join
		// e1.referencia r1 where e1.loja.codigo = 000024 and e1.localEstoque =
		// 001 and r1.refplu = r.refplu), "
		// + "from Estoque e join e.referencia r join r.produto p where
		// e.loja.codigo = 000022 and e.localEstoque = 001";
		// List<EstoqueDTO> estoqueLojas = manager.createQuery(jpql,
		// EstoqueDTO.class).getResultList();

		String jpql = "select referencia1_.refplu as col_0_0_, marca3_.mardes as col_1_0_, produto2_.prodes as col_2_0_, estoque0_.esttot as col_3_0_, "
				+ "(select estoque3_.esttot from estoque estoque3_ inner join referencia referencia4_ on estoque3_.refplu=referencia4_.refplu where estoque3_.lojcod=22 and estoque3_.loccod=1 and referencia4_.refplu=referencia1_.refplu) as col_4_0_, "
				+ "(select estoque4_.esttot from estoque estoque4_ inner join referencia referencia5_ on estoque4_.refplu=referencia5_.refplu where estoque4_.lojcod=24 and estoque4_.loccod=1 and referencia5_.refplu=referencia1_.refplu) as col_5_0_, "
				+ "(select estoque6_.esttot from estoque estoque6_ inner join referencia referencia7_ on estoque6_.refplu=referencia7_.refplu where estoque6_.lojcod=26 and estoque6_.loccod=1 and referencia7_.refplu=referencia1_.refplu) as col_6_0_, "
				+ "(select estoque7_.esttot from estoque estoque7_ inner join referencia referencia8_ on estoque7_.refplu=referencia8_.refplu where estoque7_.lojcod=28 and estoque7_.loccod=1 and referencia8_.refplu=referencia1_.refplu) as col_7_0_ "
				+ "from estoque estoque0_ inner join referencia referencia1_ on estoque0_.refplu=referencia1_.refplu inner join produto produto2_ on referencia1_.procod=produto2_.procod, marca marca3_ where produto2_.marcod=marca3_.marcod and estoque0_.lojcod=16 and estoque0_.loccod=1";
		Query q = manager.createNativeQuery(jpql);

		List<Object[]> estoqueLojas = q.getResultList();

		return estoqueLojas;
	}

	@Override
	public List<EstoqueDTO> buscaEstoque() {
		
//		String jpql = "select new com.sysconard.Glojas.DTO.EstoqueDTO("
//				+ "r.refplu "
//				+ ", r.produto.marca.descricao "
//				+ ", r.produto.descricao "
//				+ ", e.estoque) "
////				+ ", (select e2.estoque "
////					+ "	from Estoque e2 "
////							+ "	join e2.referencia r2 "
////					+ "where e2.loja.codigo = 2"
////							+ "and e2.localEstoque = 001 "
////							+ "and e2.referencia = e.referencia) as estoque1 ) "
//		+ " from Estoque e "
//				+ "join e.loja l "
//				+ "join e.referencia r "
//		+ "where l.codigo = e.loja.codigo "
//				+ "and e.referencia.refplu = r.refplu "
//				+ "and e.localEstoque = 001 "
//				+ "and e.loja.codigo = 1"
//		+ "order by r.produto.codigo";
//
//		List<EstoqueDTO> listaEstoque = manager.createQuery(jpql, EstoqueDTO.class)
//		.getResultList();
		
		
		
		
		List<EstoqueDTO> listaEstoque = manager.createNamedQuery("buscaEstoque").getResultList();
		return listaEstoque;
	}

	@Override
	public List<EstoqueDTO> buscaEstoqueOex() {
		List<EstoqueDTO> listaEstoqueOex = manager.createNamedQuery("buscaEstoqueOex").getResultList();
		return listaEstoqueOex;
	}

	@Override
	public BigDecimal estoqueDoProdutoPelaRefplu(String refplu) {
		Optional<BigDecimal> optional = Optional
				.ofNullable(manager
						.createQuery("select sum(e.estoque) from Estoque e "
											+ "where e.referencia.refplu = :refplu and "
											+ "e.localEstoque = '001'", BigDecimal.class)
						.setParameter("refplu", refplu)
						.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}

}
