package com.sysconard.Glojas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Devolucao implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "AGECOD")
	private Pessoa pessoa;

	@Column(name = "LOJCODDEV")
	private char lojaDevolução;

	@Column(name = "DEVCOD")
	private Long codigoDevolução;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public char getLojaDevolução() {
		return lojaDevolução;
	}

	public void setLojaDevolução(char lojaDevolução) {
		this.lojaDevolução = lojaDevolução;
	}

	public Long getCodigoDevolução() {
		return codigoDevolução;
	}

	public void setCodigoDevolução(Long codigoDevolução) {
		this.codigoDevolução = codigoDevolução;
	}

}
