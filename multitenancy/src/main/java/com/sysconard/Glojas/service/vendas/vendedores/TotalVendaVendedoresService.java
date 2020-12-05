package com.sysconard.Glojas.service.vendas.vendedores;

import com.sysconard.Glojas.DTO.dashboard.InfoVendedoresDashboardDTO;

import java.util.List;

public interface TotalVendaVendedoresService {

    List<InfoVendedoresDashboardDTO> totalVendaValorDia();
    List<InfoVendedoresDashboardDTO> totalVendaValorMes();
    List<InfoVendedoresDashboardDTO> totalVendaValorAno();

}
