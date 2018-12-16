package com.sysconard.Glojas.DTO;

public class ProdutoCadastradosDTO {

	private Long codigo;
	private String secao;
	private String grupo;
	private String subgrupo;
	private String marca;
	private String partNumber;
	private String refplu;
	private String produtoDescricao;
	private String ncm;
	public ProdutoCadastradosDTO(Long codigo
												, String secao
												, String grupo
												, String subgrupo
												, String marca
												, String partNumber
												, String refplu
												, String produtoDescricao
												, String ncm) {
		super();
		this.codigo = codigo;
		this.secao = secao;
		this.grupo = grupo;
		this.subgrupo = subgrupo;
		this.marca = marca;
		this.partNumber = partNumber;
		this.refplu = refplu;
		this.produtoDescricao = produtoDescricao;
		this.ncm = ncm;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getSecao() {
		return secao;
	}
	public void setSecao(String secao) {
		this.secao = secao;
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
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
	public String getNcm() {
		return ncm;
	}
	public void setNcm(String ncm) {
		this.ncm = ncm;
	}
	
	
}
