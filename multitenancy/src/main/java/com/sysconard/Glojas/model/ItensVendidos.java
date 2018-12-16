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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_SAIDA")
public class ItensVendidos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SAICOD")
	private Long codigo;

	@ManyToOne
	@JoinColumn(name = "LOJCOD")
	private Loja loja;

	@ManyToOne
	@JoinColumn(name = "REFPLU")
	private Referencia referencia;

	@ManyToOne
	@JoinColumn(name = "FUNCOD")
	private Funcionario funcionario;

	@Column(name = "ITSVLREMBREA")
	private BigDecimal precoDeVenda;

	@Column(name = "ITSVLRDCN")
	private BigDecimal valorDesconto;
	
	@Column(name = "ITSVLRLIQ")
	private BigDecimal valorLiquido;

	@Column(name = "ITSSEQ")
	private BigDecimal sequenciaItem;
	
	@Column(name = "ITSQTDTOT")
	private BigDecimal totalItens;
	
	@OneToOne
	@JoinColumn(name = "SAICOD")
	private Documento documento;

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

	public Referencia getReferencia() {
		return referencia;
	}

	public void setReferencia(Referencia referencia) {
		this.referencia = referencia;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public BigDecimal getPrecoDeVenda() {
		return precoDeVenda;
	}

	public void setPrecoDeVenda(BigDecimal precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(BigDecimal valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public BigDecimal getSequenciaItem() {
		return sequenciaItem;
	}

	public void setSequenciaItem(BigDecimal sequenciaItem) {
		this.sequenciaItem = sequenciaItem;
	}

	public BigDecimal getTotalItens() {
		return totalItens;
	}

	public void setTotalItens(BigDecimal totalItens) {
		this.totalItens = totalItens;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
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
		ItensVendidos other = (ItensVendidos) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
