package com.sysconard.Glojas.service.vendas.vendedores;

import com.sysconard.Glojas.DTO.dashboard.InfoVendedoresDashboardDTO;

import java.util.List;

public interface TotalQuantidadeVendaVendedoresService {

    List<InfoVendedoresDashboardDTO> totalQuantidadeVendaValorDia();
    List<InfoVendedoresDashboardDTO> totalQuantidadeVendaValorMes();
    List<InfoVendedoresDashboardDTO> totalQuantidadeVendaValorAno();

}

