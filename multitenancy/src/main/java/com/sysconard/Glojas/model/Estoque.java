package com.sysconard.Glojas.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.sysconard.Glojas.DTO.EstoqueDTO;

@NamedNativeQuery(name = "buscaEstoque", query = "select referencia1_.refplu as refplu, marca3_.mardes as marca, produto2_.prodes as descricao, estoque0_.esttot as loj1, "
		+ "(select estoque3_.esttot from estoque estoque3_ inner join referencia referencia4_ on estoque3_.refplu=referencia4_.refplu where estoque3_.lojcod=2 and estoque3_.loccod=1 and referencia4_.refplu=referencia1_.refplu) as loj2, "
		+ "(select estoque4_.esttot from estoque estoque4_ inner join referencia referencia5_ on estoque4_.refplu=referencia5_.refplu where estoque4_.lojcod=3 and estoque4_.loccod=1 and referencia5_.refplu=referencia1_.refplu) as loj3, "
		+ "(select estoque6_.esttot from estoque estoque6_ inner join referencia referencia7_ on estoque6_.refplu=referencia7_.refplu where estoque6_.lojcod=4 and estoque6_.loccod=1 and referencia7_.refplu=referencia1_.refplu) as loj4, "
		+ "(select estoque7_.esttot from estoque estoque7_ inner join referencia referencia8_ on estoque7_.refplu=referencia8_.refplu where estoque7_.lojcod=5 and estoque7_.loccod=1 and referencia8_.refplu=referencia1_.refplu) as loj5, "
		+ "(select estoque8_.esttot from estoque estoque8_ inner join referencia referencia9_ on estoque8_.refplu=referencia9_.refplu where estoque8_.lojcod=6 and estoque8_.loccod=1 and referencia9_.refplu=referencia1_.refplu) as loj6, "
		+ "(select estoque9_.esttot from estoque estoque9_ inner join referencia referencia10_ on estoque9_.refplu=referencia10_.refplu where estoque9_.lojcod=7 and estoque9_.loccod=1 and referencia10_.refplu=referencia1_.refplu) as loj7, "
		+ "(select estoque10_.esttot from estoque estoque10_ inner join referencia referencia11_ on estoque10_.refplu=referencia11_.refplu where estoque10_.lojcod=8 and estoque10_.loccod=1 and referencia11_.refplu=referencia1_.refplu) as loj8, "
		+ "(select estoque11_.esttot from estoque estoque11_ inner join referencia referencia12_ on estoque11_.refplu=referencia12_.refplu where estoque11_.lojcod=9 and estoque11_.loccod=1 and referencia12_.refplu=referencia1_.refplu) as loj9 "
		+ "from estoque estoque0_ inner join referencia referencia1_ on estoque0_.refplu=referencia1_.refplu inner join produto produto2_ on referencia1_.procod=produto2_.procod, marca marca3_ where produto2_.marcod=marca3_.marcod and estoque0_.lojcod=1 and estoque0_.loccod=1", resultSetMapping = "buscaEstoqueMapping")
@SqlResultSetMapping(name = "buscaEstoqueMapping", classes = {
		@ConstructorResult(targetClass = com.sysconard.Glojas.DTO.EstoqueDTO.class, columns = {
				@ColumnResult(name = "refplu"), @ColumnResult(name = "marca"), @ColumnResult(name = "descricao"),
				@ColumnResult(name = "loj1"), @ColumnResult(name = "loj2"), @ColumnResult(name = "loj3"),
				@ColumnResult(name = "loj4"), @ColumnResult(name = "loj5"),
				@ColumnResult(name = "loj6"), @ColumnResult(name = "loj7"), @ColumnResult(name = "loj8"), @ColumnResult(name = "loj9") }) })
@Entity
@Table(name = "ESTOQUE")
public class Estoque implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ROWID")
	String rowid;

	@ManyToOne
	@JoinColumn(name = "LOJCOD")
	private Loja loja;

	@ManyToOne
	@JoinColumn(name = "REFPLU")
	private Referencia referencia;

	@Column(name = "ESTTOT")
	private BigDecimal estoque;

	@Column(name = "LOCCOD")
	private double localEstoque;

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

	public BigDecimal getEstoque() {
		return estoque;
	}

	public void setEstoque(BigDecimal estoque) {
		this.estoque = estoque;
	}

	public double getLocalEstoque() {
		return localEstoque;
	}

	public void setLocalEstoque(double localEstoque) {
		this.localEstoque = localEstoque;
	}

}
