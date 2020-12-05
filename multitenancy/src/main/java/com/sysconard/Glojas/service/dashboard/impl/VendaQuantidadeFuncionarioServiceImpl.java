package com.sysconard.Glojas.service.dashboard.impl;

import com.sysconard.Glojas.DTO.dashboard.InfoVendedoresDashboardDTO;
import com.sysconard.Glojas.service.dashboard.VendaQuantidadeFuncionarioService;
import com.sysconard.Glojas.service.vendas.vendedores.TotalQuantidadeVendaVendedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaQuantidadeFuncionarioServiceImpl implements VendaQuantidadeFuncionarioService {

    @Autowired
    private TotalQuantidadeVendaVendedoresService totalQuantidadeVendaVendedoresService;

    @Override
    public InfoVendedoresDashboardDTO vendasQuantidadeTotaisDoDia() {
        List<InfoVendedoresDashboardDTO> vendas = totalQuantidadeVendaVendedoresService.totalQuantidadeVendaValorDia();

        if(vendas.size() == 0){
            InfoVendedoresDashboardDTO dto = InfoVendedoresDashboardDTO.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
    }

    @Override
    public InfoVendedoresDashboardDTO vendasQuantidadeTotaisDoMes() {
        List<InfoVendedoresDashboardDTO> vendas = totalQuantidadeVendaVendedoresService.totalQuantidadeVendaValorMes();

        if(vendas.size() == 0){
            InfoVendedoresDashboardDTO dto = InfoVendedoresDashboardDTO.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
    }

    @Override
    public InfoVendedoresDashboardDTO vendasQuantidadeTotaisDoAno() {
        List<InfoVendedoresDashboardDTO> vendas = totalQuantidadeVendaVendedoresService.totalQuantidadeVendaValorAno();

        if(vendas.size() == 0){
            InfoVendedoresDashboardDTO dto = InfoVendedoresDashboardDTO.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
    }
}
