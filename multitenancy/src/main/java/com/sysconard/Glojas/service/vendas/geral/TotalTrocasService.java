package com.sysconard.Glojas.service.vendas.geral;

import java.math.BigDecimal;

public interface TotalTrocasService {

    BigDecimal totalTrocasDoDia();

    BigDecimal totalTrocasDoMes();

    BigDecimal totalTrocasDoAno();
}
