package com.sysconard.Glojas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "DOCUMENTO")
public class Documento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOCCOD")
	private Long codigo;

	@ManyToOne
	@JoinColumn(name = "LOJCOD")
	private Loja loja;

	@ManyToOne
	@JoinColumn(name = "AGECOD")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "FUNCOD")
	private Funcionario funcionario;

	@Column(name = "ORICOD", columnDefinition = "char(3)")
	private String tipo;

	@Column(name = "DOCNUMDOC", columnDefinition = "char(20)")
	private String numeroNota;

	@Column(name = "DOCVLRTOT")
	private BigDecimal valorDocumento;
	
	@Column(name = "DOCSTA", columnDefinition = "char(1)")
	private String statusDocumento;
	
	@Column(name = "OPECOD", columnDefinition = "char(6)")
	private String codigoOperacao;
	
	@Column(name = "DOCSTANFE", columnDefinition = "char(1)")
	private String statusDanfe;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DOCDATEMI")
	private Date dataEmissao;

	@OneToOne
	@JoinColumn(name = "DOCCOD")
	private ItensVendidos itensVendidos;
	
	@OneToOne
	@JoinColumn(name = "DOCCOD")
	private ItensEntrada itensEntrada;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(String numeroNota) {
		this.numeroNota = numeroNota;
	}

	public BigDecimal getValorDocumento() {
		return valorDocumento;
	}

	public void setValorDocumento(BigDecimal valorDocumento) {
		this.valorDocumento = valorDocumento;
	}

	public String getStatusDocumento() {
		return statusDocumento;
	}

	public void setStatusDocumento(String statusDocumento) {
		this.statusDocumento = statusDocumento;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public ItensVendidos getItensVendidos() {
		return itensVendidos;
	}

	public void setItensVendidos(ItensVendidos itensVendidos) {
		this.itensVendidos = itensVendidos;
	}
	
	

	public String getCodigoOperacao() {
		return codigoOperacao;
	}

	public void setCodigoOperacao(String codigoOperacao) {
		this.codigoOperacao = codigoOperacao;
	}

	public String getStatusDanfe() {
		return statusDanfe;
	}

	public void setStatusDanfe(String statusDanfe) {
		this.statusDanfe = statusDanfe;
	}

	public ItensEntrada getItensEntrada() {
		return itensEntrada;
	}

	public void setItensEntrada(ItensEntrada itensEntrada) {
		this.itensEntrada = itensEntrada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
