package com.sysconard.Glojas.service.dashboard.impl;

import com.sysconard.Glojas.DTO.dashboard.InfoVendedoresDashboardDTO;
import com.sysconard.Glojas.service.dashboard.VendaFuncionarioDiaService;
import com.sysconard.Glojas.service.vendas.vendedores.TotalVendaVendedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaFuncionarioDiaServiceImpl implements VendaFuncionarioDiaService {

    @Autowired
    private TotalVendaVendedoresService totalVendaVendedoresService;

    @Override
    public InfoVendedoresDashboardDTO vendasTotaisDoDia() {
        List<InfoVendedoresDashboardDTO> vendas = totalVendaVendedoresService.totalVendaValorDia();

        if(vendas.size() == 0){
            InfoVendedoresDashboardDTO dto = InfoVendedoresDashboardDTO.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
    }
}
