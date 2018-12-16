package com.sysconard.Glojas.DTO;

import java.math.BigDecimal;

public class GraficoVendasMes {

	private String dia;
	private BigDecimal total;

	public GraficoVendasMes(String dia, BigDecimal total) {
		super();
		this.dia = dia;
		this.total = total;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
