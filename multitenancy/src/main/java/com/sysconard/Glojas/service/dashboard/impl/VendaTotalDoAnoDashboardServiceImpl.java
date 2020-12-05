package com.sysconard.Glojas.service.dashboard.impl;

import com.sysconard.Glojas.DTO.dashboard.TotaisDashboardDTO;
import com.sysconard.Glojas.service.dashboard.VendaTotalDoAnoDashboardService;
import com.sysconard.Glojas.service.vendas.geral.TotalTrocasService;
import com.sysconard.Glojas.service.vendas.geral.TotalVendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class VendaTotalDoAnoDashboardServiceImpl implements VendaTotalDoAnoDashboardService {

    @Autowired
    private TotalVendasService totalVendasService;

    @Autowired
    private TotalTrocasService totalTrocasService;

    @Override
    public TotaisDashboardDTO vendasTotaisDoAno() {

        BigDecimal totalVenda = totalVendasService.totalVendasDoAno();
        BigDecimal totalTroca = totalTrocasService.totalTrocasDoAno();

        TotaisDashboardDTO total = TotaisDashboardDTO.builder().build().criarInstancia(totalVenda, totalTroca);

        return total;
    }
}
