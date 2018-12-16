package com.sysconard.Glojas.DTO;

import java.math.BigDecimal;
import java.util.Date;

public class CompraAnaliseUltimasVendas {

	private String fornecedor;
	private Date dataCompra;
	private BigDecimal valorPagoNf;
	private BigDecimal qdeComprada;
	
	public CompraAnaliseUltimasVendas(String fornecedor, Date dataCompra, BigDecimal valorPagoNf,
			BigDecimal qdeComprada) {
		super();
		this.fornecedor = fornecedor;
		this.dataCompra = dataCompra;
		this.valorPagoNf = valorPagoNf;
		this.qdeComprada = qdeComprada;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public BigDecimal getValorPagoNf() {
		return valorPagoNf;
	}

	public void setValorPagoNf(BigDecimal valorPagoNf) {
		this.valorPagoNf = valorPagoNf;
	}

	public BigDecimal getQdeComprada() {
		return qdeComprada;
	}

	public void setQdeComprada(BigDecimal qdeComprada) {
		this.qdeComprada = qdeComprada;
	}
	
	
	
}
