package com.sysconard.Glojas.service.vendas.geral.impl;

import com.sysconard.Glojas.DTO.vendas.UnicoValorDTO;
import com.sysconard.Glojas.repository.Documentos;
import com.sysconard.Glojas.service.vendas.geral.TotalTrocasService;
import com.sysconard.Glojas.util.DatasUtil;
import com.sysconard.Glojas.util.OperacaoUtil;
import com.sysconard.Glojas.util.TipoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class TotalTrocasServiceImpl implements TotalTrocasService {

    @Autowired
    private Documentos documentoRepository;

    OperacaoUtil operacaoUtil = new OperacaoUtil();
    List<String> operacaoTroca = operacaoUtil.operacaoTroca();

    TipoUtil tipoUtil = new TipoUtil();
    List<String> tipoTroca = tipoUtil.tipoTroca();

    DatasUtil datasUtil = new DatasUtil();
    Timestamp hoje = datasUtil.SysDataDeHoje();
    Timestamp primeiroDiaDoMesAtual = datasUtil.SysDataPrimeiroDiaDoMesAtual();
    Timestamp ultimoDiaDoMesAtual = datasUtil.SysDataUltimoDiaDoMesAtual();
    Timestamp primeiroDiaDoAnoAtual = datasUtil.SysDataPrimeiroDiaDoAnoAtual();
    Timestamp ultimoDiaDoAnoAtual = datasUtil.SysDataUltimoDiaDoAnoAtual();


    @Override
    public BigDecimal totalTrocasDoDia() {
        UnicoValorDTO totalTrocasDoDia = documentoRepository.valorTotalTroca(tipoTroca, operacaoTroca, hoje, hoje);
        if(totalTrocasDoDia.getValor() == null){
            totalTrocasDoDia.setValor(BigDecimal.ZERO);
        }
        return totalTrocasDoDia.getValor();
    }

    @Override
    public BigDecimal totalTrocasDoMes() {
        UnicoValorDTO totalTrocasDoMes = documentoRepository.valorTotalTroca(tipoTroca, operacaoTroca, primeiroDiaDoMesAtual, ultimoDiaDoMesAtual);
        if(totalTrocasDoMes.getValor() == null){
            totalTrocasDoMes.setValor(BigDecimal.ZERO);
        }
        return totalTrocasDoMes.getValor();
    }

    @Override
    public BigDecimal totalTrocasDoAno() {
        UnicoValorDTO totalTrocasDoAno = documentoRepository.valorTotalTroca(tipoTroca, operacaoTroca, primeiroDiaDoAnoAtual, ultimoDiaDoAnoAtual);
        if(totalTrocasDoAno.getValor() == null){
            totalTrocasDoAno.setValor(BigDecimal.ZERO);
        }
        return totalTrocasDoAno.getValor();
    }
}
