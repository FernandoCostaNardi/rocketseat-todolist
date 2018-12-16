package com.sysconard.Glojas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;

@Entity
@Table(name = "REFERENCIA")
public class Referencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REFPLU", columnDefinition = "char(6)")
	private String refplu;

	@OneToOne
	@JoinColumn(name = "PROCOD")
	private Produto produto;

	@OneToOne(mappedBy = "referencia")
	@JoinColumn(name = "REFPLU")
	private PartNumber partNumber;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REFPLU")
	private Custo custo;

	public String getRefplu() {
		return refplu;
	}

	public void setRefplu(String refplu) {
		this.refplu = refplu;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public PartNumber getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(PartNumber partNumber) {
		this.partNumber = partNumber;
	}

	public Custo getCusto() {
		return custo;
	}

	public void setCusto(Custo custo) {
		this.custo = custo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((refplu == null) ? 0 : refplu.hashCode());
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
		Referencia other = (Referencia) obj;
		if (refplu == null) {
			if (other.refplu != null)
				return false;
		} else if (!refplu.equals(other.refplu))
			return false;
		return true;
	}

}
