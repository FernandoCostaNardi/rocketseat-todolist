package com.sysconard.Glojas.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@Table(name = "dashboard_pre_processor")
public class DashboardPreProcessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "venda_dia")
    private BigDecimal vendaDia;
    @Column(name = "troca_dia")
    private BigDecimal trocaDia;
    @Column(name = "total_dia")
    private BigDecimal totalVendaDia;
    @Column(name = "venda_mes")
    private BigDecimal vendaMes;
    @Column(name = "troca_mes")
    private BigDecimal trocaMês;
    @Column(name = "total_mes")
    private BigDecimal totalVendaMês;
    @Column(name = "venda_ano")
    private BigDecimal vendaAno;
    @Column(name = "troca_ano")
    private BigDecimal trocaAno;
    @Column(name = "total_ano")
    private BigDecimal totalVendaAno;

    @Column(name = "nm_func_venda_dia")
    private String nmFuncionarioVendaDia;
    @Column(name = "vl_func_venda_dia")
    private BigDecimal vlTotalVendaDia;
    @Column(name = "nm_func_venda_mes")
    private String nmFuncionarioVendaMes;
    @Column(name = "vl_func_venda_mes")
    private BigDecimal vlTotalVendaMes;
    @Column(name = "nm_func_venda_ano")
    private String nmFuncionarioVendaAno;
    @Column(name = "vl_func_venda_ano")
    private BigDecimal vlTotalVendaAno;

    @Column(name = "nm_func_quan_dia")
    private String nmFuncionarioVendaQuantidadeDia;
    @Column(name = "qt_func_quan_dia")
    private Integer qtProdutoVendaQuantidadeDia;
    @Column(name = "nm_func_quan_mes")
    private String nmFuncionarioVendaQuantidadeMes;
    @Column(name = "qt_func_quan_mes")
    private Integer qtProdutoVendaQuantidadeMes;
    @Column(name = "nm_func_quan_ano")
    private String nmFuncionarioVendaQuantidadeAno;
    @Column(name = "qt_func_quan_ano")
    private Integer qtProdutoVendaQuantidadeAno;

    @Column(name = "nm_func_troca_dia")
    private String nmFuncionarioTrocaDia;
    @Column(name = "vl_func_troca_dia")
    private BigDecimal vlTotalTrocaDia;
    @Column(name = "nm_func_troca_mes")
    private String nmFuncionarioTrocaMes;
    @Column(name = "vl_func_troca_mes")
    private BigDecimal vlTotalTrocaMes;
    @Column(name = "nm_func_troca_ano")
    private String nmFuncionarioTrocaAno;
    @Column(name = "vl_func_troca_ano")
    private BigDecimal vlTotalTrocaAno;

    @Column(name = "nm_prod_val_dia")
    private String nmProdutoVendidoDia;
    @Column(name = "qt_prod_val_dia")
    private Integer qtProdutoVendidoDia;
    @Column(name = "nm_prod_val_mes")
    private String nmProdutoVendidoMes;
    @Column(name = "qt_prod_val_mes")
    private Integer qtProdutoVendidoMes;
    @Column(name = "nm_prod_val_ano")
    private String nmProdutoVendidoAno;
    @Column(name = "qt_prod_val_ano")
    private Integer qtProdutoVendidoAno;

    @Column(name = "nm_prod_agre_dia")
    private String nmProdutoValorAgregadoVendidoDia;
    @Column(name = "vl_prod_agre_dia")
    private BigDecimal vlProdutoValorAgregadoVendidoDia;
    @Column(name = "nm_prod_agre_mes")
    private String nmProdutoValorAgregadoVendidoMes;
    @Column(name = "vl_prod_agre_mes")
    private BigDecimal vlProdutoValorAgregadoVendidoMes;
    @Column(name = "nm_prod_agre_ano")
    private String nmProdutoValorAgregadoVendidoAno;
    @Column(name = "vl_prod_agre_ano")
    private BigDecimal vlProdutoValorAgregadoVendidoAno;

}
