package com.sysconard.Glojas.DTO;

import java.math.BigDecimal;

public class VendasTotaisDetalhadasDTO {

	private Long codigo;
	private String numeroNota;
	private String loja;
	private String grupo;
	private String refplu;
	private String produtoDescricao;
	private String subgrupo;
	private BigDecimal custoReposicao;
	private BigDecimal precoDeVenda;
	private BigDecimal totalItens;
	private BigDecimal valorTotal;
	private BigDecimal descontoDeVenda;
	private BigDecimal porcentageDesconto;
	private BigDecimal precoDeVendaComDesconto;
	private BigDecimal margemBruta;

	public VendasTotaisDetalhadasDTO(Long codigo, String numeroNota, String loja, String grupo, String refplu,
			String produtoDescricao, BigDecimal custoReposicao, BigDecimal precoDeVenda, BigDecimal totalItens,  BigDecimal descontoDeVenda,
			BigDecimal precoDeVendaComDesconto) {
		super();
		this.codigo = codigo;
		this.numeroNota = numeroNota;
		this.loja = loja;
		this.grupo = grupo;
		this.refplu = refplu;
		this.produtoDescricao = produtoDescricao;
		this.custoReposicao = custoReposicao;
		this.precoDeVenda = precoDeVenda;
		this.totalItens = totalItens;
		this.descontoDeVenda = descontoDeVenda;
		this.precoDeVendaComDesconto = precoDeVendaComDesconto;
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

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getSubgrupo() {
		return subgrupo;
	}

	public void setSubgrupo(String subgrupo) {
		this.subgrupo = subgrupo;
	}

	public BigDecimal getCustoReposicao() {
		return custoReposicao;
	}

	public void setCustoReposicao(BigDecimal custoReposicao) {
		this.custoReposicao = custoReposicao;
	}

	public BigDecimal getPrecoDeVenda() {
		return precoDeVenda;
	}

	public void setPrecoDeVenda(BigDecimal precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}

	public BigDecimal getTotalItens() {
		return totalItens;
	}

	public void setTotalItens(BigDecimal totalItens) {
		this.totalItens = totalItens;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getDescontoDeVenda() {
		return descontoDeVenda;
	}

	public void setDescontoDeVenda(BigDecimal descontoDeVenda) {
		this.descontoDeVenda = descontoDeVenda;
	}

	public BigDecimal getPorcentageDesconto() {
		return porcentageDesconto;
	}

	public void setPorcentageDesconto(BigDecimal porcentageDesconto) {
		this.porcentageDesconto = porcentageDesconto;
	}

	public BigDecimal getPrecoDeVendaComDesconto() {
		return precoDeVendaComDesconto;
	}

	public void setPrecoDeVendaComDesconto(BigDecimal precoDeVendaComDesconto) {
		this.precoDeVendaComDesconto = precoDeVendaComDesconto;
	}

	public BigDecimal getMargemBruta() {
		return margemBruta;
	}

	public void setMargemBruta(BigDecimal margemBruta) {
		this.margemBruta = margemBruta;
	}

}
