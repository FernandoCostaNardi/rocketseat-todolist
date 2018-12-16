package com.sysconard.Glojas.DTO;

import java.math.BigDecimal;

public class CompraGeralDTO {

	private String grupo;
	private String partNumber;
	private String marca;
	private String refplu;
	private String descricaoProduto;
	private BigDecimal precoCusto;
	private BigDecimal precoVenda;
	private BigDecimal venda90;
	private BigDecimal venda60;
	private BigDecimal venda30;
	private BigDecimal vendaMesAtual;
	private BigDecimal estoqueAtual;
	
	public CompraGeralDTO(String grupo, String partNumber, String marca, String refplu, String descricaoProduto, BigDecimal precoCusto,
											BigDecimal precoVenda, BigDecimal venda90, BigDecimal venda60, BigDecimal venda30, BigDecimal vendaMesAtual, BigDecimal estoqueAtual) {
		super();
		this.grupo = grupo;
		this.partNumber = partNumber;
		this.marca = marca;
		this.refplu = refplu;
		this.descricaoProduto = descricaoProduto;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.estoqueAtual = estoqueAtual;
		this.venda60 = venda60;
		this.venda90 = venda90;
		this.venda30 = venda30;
		this.vendaMesAtual = vendaMesAtual;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getRefplu() {
		return refplu;
	}
	public void setRefplu(String refplu) {
		this.refplu = refplu;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}
	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}
	public BigDecimal getVenda90() {
		return venda90;
	}
	public void setVenda90(BigDecimal venda90) {
		this.venda90 = venda90;
	}
	public BigDecimal getVenda60() {
		return venda60;
	}
	public void setVenda60(BigDecimal venda60) {
		this.venda60 = venda60;
	}
	public BigDecimal getVenda30() {
		return venda30;
	}
	public void setVenda30(BigDecimal venda30) {
		this.venda30 = venda30;
	}
	public BigDecimal getVendaMesAtual() {
		return vendaMesAtual;
	}
	public void setVendaMesAtual(BigDecimal vendaMesAtual) {
		this.vendaMesAtual = vendaMesAtual;
	}
	public BigDecimal getEstoqueAtual() {
		return estoqueAtual;
	}
	public void setEstoqueAtual(BigDecimal estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}
}