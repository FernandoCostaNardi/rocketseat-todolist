package com.sysconard.Glojas.DTO.vendas;

import java.math.BigDecimal;

public class UnicoValorDTO {

    private BigDecimal valor;

    public UnicoValorDTO() {
    }

    public UnicoValorDTO(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
