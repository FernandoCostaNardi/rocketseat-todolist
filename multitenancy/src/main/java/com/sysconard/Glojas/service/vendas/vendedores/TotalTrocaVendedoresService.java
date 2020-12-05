package com.sysconard.Glojas.service.vendas.vendedores;

import com.sysconard.Glojas.DTO.dashboard.InfoVendedoresDashboardDTO;

import java.util.List;

public interface TotalTrocaVendedoresService {

    List<InfoVendedoresDashboardDTO> totalTrocaValorDia();
    List<InfoVendedoresDashboardDTO> totalTrocaValorMes();
    List<InfoVendedoresDashboardDTO> totalTrocaValorAno();
}
