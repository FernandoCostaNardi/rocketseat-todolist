package com.sysconard.Glojas.DTO.dashboard;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class InfoProdutoDashboard {

    private String cdProduto;
    private String nmProduto;
    private Integer qtProduto;
    private BigDecimal vlProduto;

    public InfoProdutoDashboard() {
    }

    public InfoProdutoDashboard(String cdProduto, String nmProduto, Integer qtProduto) {
        this.cdProduto = cdProduto;
        this.nmProduto = nmProduto;
        this.qtProduto = qtProduto;
    }

    public InfoProdutoDashboard(String cdProduto, String nmProduto, BigDecimal vlProduto) {
        this.cdProduto = cdProduto;
        this.nmProduto = nmProduto;
        this.vlProduto = vlProduto;
    }

    public InfoProdutoDashboard(String cdProduto, String nmProduto, Integer qtProduto, BigDecimal vlProduto) {
        this.cdProduto = cdProduto;
        this.nmProduto = nmProduto;
        this.qtProduto = qtProduto;
        this.vlProduto = vlProduto;
    }

    public InfoProdutoDashboard criaInstanciaVazia(){
        return InfoProdutoDashboard.builder()
                .cdProduto("")
                .nmProduto("")
                .qtProduto(0)
                .vlProduto(BigDecimal.ZERO)
                .build();
    }
}
