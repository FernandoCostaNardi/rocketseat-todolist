package com.sysconard.Glojas.service.dashboard.impl;

import com.sysconard.Glojas.DTO.dashboard.TotaisDashboardDTO;
import com.sysconard.Glojas.service.dashboard.VendaTotalDoMesDashboardService;
import com.sysconard.Glojas.service.vendas.geral.TotalTrocasService;
import com.sysconard.Glojas.service.vendas.geral.TotalVendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class VendaTotalDoMesDashboardServiceImpl implements VendaTotalDoMesDashboardService {

    @Autowired
    private TotalVendasService totalVendasService;

    @Autowired
    private TotalTrocasService totalTrocasService;

    @Override
    public TotaisDashboardDTO vendasTotaisDoMes() {

        BigDecimal totalVenda = totalVendasService.totalVendasDoMes();
        BigDecimal totalTroca = totalTrocasService.totalTrocasDoMes();

        TotaisDashboardDTO total = TotaisDashboardDTO.builder().build().criarInstancia(totalVenda, totalTroca);

        return total;
    }
}
