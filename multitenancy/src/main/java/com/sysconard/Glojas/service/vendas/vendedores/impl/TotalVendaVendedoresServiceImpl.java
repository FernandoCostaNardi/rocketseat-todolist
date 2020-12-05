package com.sysconard.Glojas.service.vendas.vendedores.impl;

import com.sysconard.Glojas.DTO.dashboard.InfoVendedoresDashboardDTO;
import com.sysconard.Glojas.repository.Funcionarios;
import com.sysconard.Glojas.service.vendas.vendedores.TotalVendaVendedoresService;
import com.sysconard.Glojas.util.DatasUtil;
import com.sysconard.Glojas.util.OperacaoUtil;
import com.sysconard.Glojas.util.TipoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class TotalVendaVendedoresServiceImpl implements TotalVendaVendedoresService {

    @Autowired
    private Funcionarios vendedorRepository;

    OperacaoUtil operacaoUtil = new OperacaoUtil();
    List<String> operacaoVenda = operacaoUtil.operacaoVenda();
    List<String> operacaoTroca = operacaoUtil.operacaoTroca();

    TipoUtil tipoUtil = new TipoUtil();
    List<String> tipoPDVEDanfe = tipoUtil.tipoPDVEDanfe();

    DatasUtil datasUtil = new DatasUtil();
    Timestamp hoje = datasUtil.SysDataDeHoje();
    Timestamp primeiroDiaDoMesAtual = datasUtil.SysDataPrimeiroDiaDoMesAtual();
    Timestamp ultimoDiaDoMesAtual = datasUtil.SysDataUltimoDiaDoMesAtual();
    Timestamp primeiroDiaDoAnoAtual = datasUtil.SysDataPrimeiroDiaDoAnoAtual();
    Timestamp ultimoDiaDoAnoAtual = datasUtil.SysDataUltimoDiaDoAnoAtual();

    List<InfoVendedoresDashboardDTO> list = new ArrayList<>();

    @Override
    public List<InfoVendedoresDashboardDTO> totalVendaValorDia() {

        List<InfoVendedoresDashboardDTO> total = vendedorRepository.recuperarValorTotalVendas(tipoPDVEDanfe, operacaoVenda, hoje, hoje);
        if(total == null){
            return list;
        }
        return total;
    }

    @Override
    public List<InfoVendedoresDashboardDTO> totalVendaValorMes() {
        List<InfoVendedoresDashboardDTO> total = vendedorRepository.recuperarValorTotalVendas(tipoPDVEDanfe, operacaoVenda, primeiroDiaDoMesAtual, ultimoDiaDoMesAtual);
        if(total == null){
            return list;
        }
        return total;
    }

    @Override
    public List<InfoVendedoresDashboardDTO> totalVendaValorAno() {
        List<InfoVendedoresDashboardDTO> total = vendedorRepository.recuperarValorTotalVendas(tipoPDVEDanfe, operacaoVenda, primeiroDiaDoAnoAtual, ultimoDiaDoAnoAtual);
        if(total == null){
            return list;
        }
        return total;
    }
}
