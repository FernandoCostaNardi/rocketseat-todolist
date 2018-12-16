package com.sysconard.Glojas.DTO;

import java.math.BigDecimal;

public class ComissaoTotalDTO {

	private String loja;
	private Long codigoFuncionario;
	private String nomeFuncionario;
	private BigDecimal valorDeDescontoDadoPeloFuncionario;
	private BigDecimal valorVendidoFuncionario;
	private BigDecimal valorPercentualDeComissaoFuncionario;
	private BigDecimal valorDaComissao;

	public ComissaoTotalDTO(String loja, Long codigoFuncionario, String nomeFuncionario,
			BigDecimal valorDeDescontoDadoPeloFuncionario, BigDecimal valorVendidoFuncionario,
			BigDecimal valorPercentualDeComissaoFuncionario) {
		super();
		this.loja = loja;
		this.codigoFuncionario = codigoFuncionario;
		this.nomeFuncionario = nomeFuncionario;
		this.valorDeDescontoDadoPeloFuncionario = valorDeDescontoDadoPeloFuncionario;
		this.valorVendidoFuncionario = valorVendidoFuncionario;
		this.valorPercentualDeComissaoFuncionario = valorPercentualDeComissaoFuncionario;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public Long getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(Long codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public BigDecimal getValorDeDescontoDadoPeloFuncionario() {
		return valorDeDescontoDadoPeloFuncionario;
	}

	public void setValorDeDescontoDadoPeloFuncionario(BigDecimal valorDeDescontoDadoPeloFuncionario) {
		this.valorDeDescontoDadoPeloFuncionario = valorDeDescontoDadoPeloFuncionario;
	}

	public BigDecimal getValorVendidoFuncionario() {
		return valorVendidoFuncionario;
	}

	public void setValorVendidoFuncionario(BigDecimal valorVendidoFuncionario) {
		this.valorVendidoFuncionario = valorVendidoFuncionario;
	}

	public BigDecimal getValorPercentualDeComissaoFuncionario() {
		return valorPercentualDeComissaoFuncionario;
	}

	public void setValorPercentualDeComissaoFuncionario(BigDecimal valorPercentualDeComissaoFuncionario) {
		this.valorPercentualDeComissaoFuncionario = valorPercentualDeComissaoFuncionario;
	}

	public BigDecimal getValorDaComissao() {
		return valorDaComissao;
	}

	public void setValorDaComissao(BigDecimal valorDaComissao) {
		this.valorDaComissao = valorDaComissao;
	}

}
