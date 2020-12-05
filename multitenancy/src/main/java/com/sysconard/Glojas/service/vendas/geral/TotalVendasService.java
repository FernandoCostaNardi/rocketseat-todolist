package com.sysconard.Glojas.service.vendas.geral;

import java.math.BigDecimal;

public interface TotalVendasService {

    BigDecimal totalVendasDoDia();

    BigDecimal totalVendasDoMes();

    BigDecimal totalVendasDoAno();

}
