package com.sysconard.Glojas.service.dashboard.impl;

import com.sysconard.Glojas.DTO.dashboard.InfoVendedoresDashboardDTO;
import com.sysconard.Glojas.service.dashboard.VendaTrocaFuncionarioService;
import com.sysconard.Glojas.service.vendas.vendedores.TotalTrocaVendedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaTrocaFuncionarioServiceImpl implements VendaTrocaFuncionarioService {

    @Autowired
    private TotalTrocaVendedoresService totalTrocaVendedoresService;

    @Override
    public InfoVendedoresDashboardDTO trocasTotaisDoDia() {
        List<InfoVendedoresDashboardDTO> vendas = totalTrocaVendedoresService.totalTrocaValorDia();

        if(vendas.size() == 0){
            InfoVendedoresDashboardDTO dto = InfoVendedoresDashboardDTO.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
    }

    @Override
    public InfoVendedoresDashboardDTO trocasTotaisDoMes() {
        List<InfoVendedoresDashboardDTO> vendas = totalTrocaVendedoresService.totalTrocaValorMes();

        if(vendas.size() == 0){
            InfoVendedoresDashboardDTO dto = InfoVendedoresDashboardDTO.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
    }

    @Override
    public InfoVendedoresDashboardDTO trocasTotaisDoAno() {
        List<InfoVendedoresDashboardDTO> vendas = totalTrocaVendedoresService.totalTrocaValorAno();

        if(vendas.size() == 0){
            InfoVendedoresDashboardDTO dto = InfoVendedoresDashboardDTO.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
    }
}
