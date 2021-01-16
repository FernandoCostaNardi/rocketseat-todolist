package com.sysconard.Glojas.service.vendas.vendedores.impl;

import com.sysconard.Glojas.DTO.dashboard.InfoVendedoresDashboardDTO;
import com.sysconard.Glojas.repository.Funcionarios;
import com.sysconard.Glojas.service.vendas.vendedores.TotalTrocaVendedoresService;
import com.sysconard.Glojas.util.DatasUtil;
import com.sysconard.Glojas.util.OperacaoUtil;
import com.sysconard.Glojas.util.TipoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TotalTrocaVendedoresServiceImpl implements TotalTrocaVendedoresService {

    @Autowired
    private Funcionarios vendedorRepository;

    OperacaoUtil operacaoUtil = new OperacaoUtil();
    List<String> operacaoTroca = operacaoUtil.operacaoTroca();

    TipoUtil tipoUtil = new TipoUtil();
    List<String> tipoTroca = tipoUtil.tipoTroca();

    DatasUtil datasUtil = new DatasUtil();
    LocalDate now = LocalDate.now();
    Timestamp hoje = Timestamp.valueOf(now.atStartOfDay());
    Timestamp primeiroDiaDoMesAtual = datasUtil.SysDataPrimeiroDiaDoMesAtual();
    Timestamp ultimoDiaDoMesAtual = datasUtil.SysDataUltimoDiaDoMesAtual();
    Timestamp primeiroDiaDoAnoAtual = datasUtil.SysDataPrimeiroDiaDoAnoAtual();
    Timestamp ultimoDiaDoAnoAtual = datasUtil.SysDataUltimoDiaDoAnoAtual();

    List<InfoVendedoresDashboardDTO> list = new ArrayList<>();

    @Override
    public List<InfoVendedoresDashboardDTO> totalTrocaValorDia() {
        List<InfoVendedoresDashboardDTO> total = vendedorRepository.recuperarTotalTrocas(tipoTroca, operacaoTroca, hoje, hoje);
        if(total == null){
            return list;
        }
        return total;
    }

    @Override
    public List<InfoVendedoresDashboardDTO> totalTrocaValorMes() {
        List<InfoVendedoresDashboardDTO> total = vendedorRepository.recuperarTotalTrocas(tipoTroca, operacaoTroca, primeiroDiaDoMesAtual, ultimoDiaDoMesAtual);
        if(total == null){
            return list;
        }
        return total;
    }

    @Override
    public List<InfoVendedoresDashboardDTO> totalTrocaValorAno() {
        List<InfoVendedoresDashboardDTO> total = vendedorRepository.recuperarTotalTrocas(tipoTroca, operacaoTroca, primeiroDiaDoAnoAtual, ultimoDiaDoAnoAtual);
        if(total == null){
            return list;
        }
        return total;
    }
}
