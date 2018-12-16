package com.sysconard.Glojas.repository.helper.preco;

import java.math.BigDecimal;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class PrecosImpl implements PrecosQueries{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public BigDecimal encontrarPrecoPeloRefplu(String refplu) {
		Optional<BigDecimal> optional = Optional
				.ofNullable(manager
						.createQuery("select p.precoVenda from Preco p "
											+ "where p.refplu = :refplu  and "
											+ "p.loja.codigo = '000003' " , BigDecimal.class)
						.setParameter("refplu", refplu)
						.getSingleResult());

		return optional.orElse(BigDecimal.ZERO);
	}

}
