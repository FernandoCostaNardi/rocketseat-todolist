package com.sysconard.Glojas.DTO;

import java.math.BigDecimal;

public class VendaContribucaoMarca {

	private String marca;
	private BigDecimal valorTrocaItens;
	private BigDecimal valorTotalItens;
	
	public VendaContribucaoMarca(BigDecimal valorTotalItens) {
		super();
		this.valorTotalItens = valorTotalItens;
	}
	
	public VendaContribucaoMarca(String marca, BigDecimal valorTotalItens) {
		super();
		this.marca = marca;
		this.valorTotalItens = valorTotalItens;
	}
	
	public VendaContribucaoMarca(String marca, BigDecimal valorTrocaItens, BigDecimal valorTotalItens) {
		super();
		this.marca = marca;
		this.valorTotalItens = valorTotalItens;
		this.valorTrocaItens = valorTrocaItens;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public BigDecimal getValorTotalItens() {
		return valorTotalItens;
	}

	public void setValorTotalItens(BigDecimal valorTotalItens) {
		this.valorTotalItens = valorTotalItens;
	}

	public BigDecimal getValorTrocaItens() {
		return valorTrocaItens;
	}

	public void setValorTrocaItens(BigDecimal valorTrocaItens) {
		this.valorTrocaItens = valorTrocaItens;
	}
	
	
	
	
}
