package com.sysconard.Glojas.DTO.dashboard;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class InfoVendedoresDashboardDTO {

    private String cdFuncionario;
    private String nmFuncionario;
    private Integer qtProduto;
    private BigDecimal vlTotal;
    private BigDecimal vlMedia;

    public InfoVendedoresDashboardDTO() {
    }

    public InfoVendedoresDashboardDTO(String cdFuncionario, String nmFuncionario, BigDecimal vlTotal) {
        this.cdFuncionario = cdFuncionario;
        this.nmFuncionario = nmFuncionario;
        this.vlTotal = vlTotal;
    }

    public InfoVendedoresDashboardDTO(String cdFuncionario, String nmFuncionario, Integer qtProduto, BigDecimal vlMedia) {
        this.cdFuncionario = cdFuncionario;
        this.nmFuncionario = nmFuncionario;
        this.qtProduto = qtProduto;
        this.vlMedia = vlMedia;
    }

    public InfoVendedoresDashboardDTO(String cdFuncionario, String nmFuncionario, Integer qtProduto, BigDecimal vlTotal, BigDecimal vlMedia) {
        this.cdFuncionario = cdFuncionario;
        this.nmFuncionario = nmFuncionario;
        this.qtProduto = qtProduto;
        this.vlTotal = vlTotal;
        this.vlMedia = vlMedia;
    }

    public InfoVendedoresDashboardDTO criaInstanciaVazia(){
        return InfoVendedoresDashboardDTO.builder()
                .cdFuncionario("")
                .nmFuncionario("")
                .qtProduto(0)
                .vlTotal(BigDecimal.ZERO)
                .vlMedia(BigDecimal.ZERO)
                .build();
    }
}
