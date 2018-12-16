package com.sysconard.Glojas.DTO;

import java.math.BigDecimal;

public class VendasTotaisDTO {

	private String loja;
	private BigDecimal valorVenda;
	private BigDecimal valorVendaDanfe;
	private BigDecimal valorTroca;
		
	
	
	public VendasTotaisDTO(BigDecimal valorVenda) {
		super();
		this.valorVenda = valorVenda;
	}

	public VendasTotaisDTO(String loja, BigDecimal valorVenda) {
		super();
		this.loja = loja;
		this.valorVenda = valorVenda;
	}

	public VendasTotaisDTO(BigDecimal valorVenda, BigDecimal valorVendaDanfe, BigDecimal valorTroca) {
		super();
		this.valorVenda = valorVenda;
		this.valorVendaDanfe = valorVendaDanfe;
		this.valorTroca = valorTroca;
	}

	public VendasTotaisDTO(String loja, BigDecimal valorVenda, BigDecimal valorVendaDanfe, BigDecimal valorTroca) {
		super();
		this.loja = loja;
		this.valorVenda = valorVenda;
		this.valorVendaDanfe = valorVendaDanfe;
		this.valorTroca = valorTroca;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public BigDecimal getValorVendaDanfe() {
		return valorVendaDanfe;
	}

	public void setValorVendaDanfe(BigDecimal valorVendaDanfe) {
		this.valorVendaDanfe = valorVendaDanfe;
	}

	public BigDecimal getValorTroca() {
		return valorTroca;
	}

	public void setValorTroca(BigDecimal valorTroca) {
		this.valorTroca = valorTroca;
	}

	

	

}
