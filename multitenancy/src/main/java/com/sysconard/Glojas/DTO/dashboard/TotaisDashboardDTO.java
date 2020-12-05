package com.sysconard.Glojas.DTO.dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class TotaisDashboardDTO {

    private BigDecimal vendas;
    private BigDecimal trocas;
    private BigDecimal total;

    public TotaisDashboardDTO() {
    }

    public TotaisDashboardDTO criarInstancia(BigDecimal totalVenda, BigDecimal totalTroca){
        TotaisDashboardDTO total = TotaisDashboardDTO.builder()
                .vendas(totalVenda)
                .trocas(totalTroca)
                .total(totalVenda.subtract(totalTroca))
                .build();
        return total;
    }

}
