package com.sysconard.Glojas.DTO;

import java.math.BigDecimal;

public class TrocasDetalhadasDTO {

	private Long codigo;
	private String numeroNota;
	private String loja;
	private String refplu;
	private String produtoDescricao;
	private BigDecimal totalItens;
	private BigDecimal valorUnitario;
	
	public TrocasDetalhadasDTO(Long codigo, String numeroNota, String loja, String refplu,
			String produtoDescricao, BigDecimal totalItens, BigDecimal valorUnitario) {
		super();
		this.codigo = codigo;
		this.numeroNota = numeroNota;
		this.loja = loja;
		this.refplu = refplu;
		this.produtoDescricao = produtoDescricao;
		this.totalItens = totalItens;
		this.valorUnitario = valorUnitario;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(String numeroNota) {
		this.numeroNota = numeroNota;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public String getRefplu() {
		return refplu;
	}

	public void setRefplu(String refplu) {
		this.refplu = refplu;
	}

	public String getProdutoDescricao() {
		return produtoDescricao;
	}

	public void setProdutoDescricao(String produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}

	public BigDecimal getTotalItens() {
		return totalItens;
	}

	public void setTotalItens(BigDecimal totalItens) {
		this.totalItens = totalItens;
	}


	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	
	
	
	
	
	
}
