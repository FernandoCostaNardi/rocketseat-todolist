package com.sysconard.Glojas.DTO;

import java.math.BigDecimal;

public class CompraQdeVendidaEstoqueAtualPorLoja {

	private String loja;
	private BigDecimal qdeVendida;
	private BigDecimal qdeEstoqueTotal;
	
	public CompraQdeVendidaEstoqueAtualPorLoja(String loja, BigDecimal qdeVendida, BigDecimal qdeEstoqueTotal) {
		super();
		this.loja = loja;
		this.qdeVendida = qdeVendida;
		this.qdeEstoqueTotal = qdeEstoqueTotal;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public BigDecimal getQdeVendida() {
		return qdeVendida;
	}

	public void setQdeVendida(BigDecimal qdeVendida) {
		this.qdeVendida = qdeVendida;
	}

	public BigDecimal getQdeEstoqueTotal() {
		return qdeEstoqueTotal;
	}

	public void setQdeEstoqueTotal(BigDecimal qdeEstoqueTotal) {
		this.qdeEstoqueTotal = qdeEstoqueTotal;
	}
	
}
