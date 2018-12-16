package com.sysconard.Glojas.DTO;

public class CompraPesquisaRapidaDTO {

	private String refplu;
	private String descricao;
	
	public CompraPesquisaRapidaDTO(String refplu, String descricao) {
		super();
		this.refplu = refplu;
		this.descricao = descricao;
	}
	public String getRefplu() {
		return refplu;
	}
	public void setRefplu(String refplu) {
		this.refplu = refplu;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
