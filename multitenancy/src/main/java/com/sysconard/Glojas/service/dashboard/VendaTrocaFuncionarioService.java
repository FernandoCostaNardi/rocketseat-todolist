package com.sysconard.Glojas.service.dashboard;

import com.sysconard.Glojas.DTO.dashboard.InfoVendedoresDashboardDTO;

public interface VendaTrocaFuncionarioService {

    public InfoVendedoresDashboardDTO trocasTotaisDoDia();
    public InfoVendedoresDashboardDTO trocasTotaisDoMes();
    public InfoVendedoresDashboardDTO trocasTotaisDoAno();
}
