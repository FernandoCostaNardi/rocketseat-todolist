package com.sysconard.Glojas.service.dashboard;

import com.sysconard.Glojas.DTO.dashboard.InfoVendedoresDashboardDTO;

public interface VendaQuantidadeFuncionarioService {

    public InfoVendedoresDashboardDTO vendasQuantidadeTotaisDoDia();
    public InfoVendedoresDashboardDTO vendasQuantidadeTotaisDoMes();
    public InfoVendedoresDashboardDTO vendasQuantidadeTotaisDoAno();
}
