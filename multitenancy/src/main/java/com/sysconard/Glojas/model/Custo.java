package com.sysconard.Glojas.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTO")
public class Custo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REFPLU", columnDefinition = "char(6)")
	private String refplu;

	@ManyToOne
	@JoinColumn(name = "LOJCOD")
	private Loja loja;

	@Column(name = "CSTREP")
	private BigDecimal custoReposicao;

	public String getRefplu() {
		return refplu;
	}

	public void setRefplu(String refplu) {
		this.refplu = refplu;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public BigDecimal getCustoReposicao() {
		return custoReposicao;
	}

	public void setCustoReposicao(BigDecimal custoReposicao) {
		this.custoReposicao = custoReposicao;
	}

}
