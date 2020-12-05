package com.sysconard.Glojas.service.dashboard.impl;

import com.sysconard.Glojas.DTO.dashboard.InfoVendedoresDashboardDTO;
import com.sysconard.Glojas.service.dashboard.VendaFuncionarioMesService;
import com.sysconard.Glojas.service.vendas.vendedores.TotalVendaVendedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaFuncionarioMesServiceImpl implements VendaFuncionarioMesService {

    @Autowired
    private TotalVendaVendedoresService totalVendaVendedoresService;

    @Override
    public InfoVendedoresDashboardDTO vendasTotaisDoMes() {
        List<InfoVendedoresDashboardDTO> vendas = totalVendaVendedoresService.totalVendaValorMes();

        if(vendas.size() == 0){
            InfoVendedoresDashboardDTO dto = InfoVendedoresDashboardDTO.builder().build().criaInstanciaVazia();
            return dto;
        }

        return vendas.get(0);
    }
}
