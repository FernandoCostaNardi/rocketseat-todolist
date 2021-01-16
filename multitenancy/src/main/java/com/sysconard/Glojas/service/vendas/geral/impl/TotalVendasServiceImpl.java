package com.sysconard.Glojas.service.vendas.geral.impl;

import com.sysconard.Glojas.DTO.vendas.UnicoValorDTO;
import com.sysconard.Glojas.repository.Documentos;
import com.sysconard.Glojas.service.vendas.geral.TotalVendasService;
import com.sysconard.Glojas.util.DatasUtil;
import com.sysconard.Glojas.util.OperacaoUtil;
import com.sysconard.Glojas.util.TipoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Service
public class TotalVendasServiceImpl implements TotalVendasService {

    @Autowired
    private Documentos documentoRepository;

    OperacaoUtil operacaoUtil = new OperacaoUtil();
    List<String> operacaoVenda = operacaoUtil.operacaoVenda();
    List<String> operacaoTroca = operacaoUtil.operacaoTroca();

    TipoUtil tipoUtil = new TipoUtil();
    List<String> tipoPDVEDanfe = tipoUtil.tipoPDVEDanfe();

    DatasUtil datasUtil = new DatasUtil();
    LocalDate now = LocalDate.now();
    Timestamp hoje = Timestamp.valueOf(now.atStartOfDay());
    Timestamp primeiroDiaDoMesAtual = datasUtil.SysDataPrimeiroDiaDoMesAtual();
    Timestamp ultimoDiaDoMesAtual = datasUtil.SysDataUltimoDiaDoMesAtual();
    Timestamp primeiroDiaDoAnoAtual = datasUtil.SysDataPrimeiroDiaDoAnoAtual();
    Timestamp ultimoDiaDoAnoAtual = datasUtil.SysDataUltimoDiaDoAnoAtual();

    @Override
    public BigDecimal totalVendasDoDia() {
        UnicoValorDTO totalVendasDoDia = documentoRepository.valorTotal(tipoPDVEDanfe, operacaoVenda, hoje, hoje);
        if(totalVendasDoDia.getValor() == null){
            totalVendasDoDia.setValor(BigDecimal.ZERO);
        }
        return totalVendasDoDia.getValor();
    }

    @Override
    public BigDecimal totalVendasDoMes() {
        UnicoValorDTO totalVendasDoMes = documentoRepository.valorTotal(tipoPDVEDanfe, operacaoVenda, primeiroDiaDoMesAtual, ultimoDiaDoMesAtual);
        if(totalVendasDoMes.getValor() == null){
            totalVendasDoMes.setValor(BigDecimal.ZERO);
        }
        return totalVendasDoMes.getValor();
    }

    @Override
    public BigDecimal totalVendasDoAno() {
        UnicoValorDTO totalVendasDoAno = documentoRepository.valorTotal(tipoPDVEDanfe, operacaoVenda, primeiroDiaDoAnoAtual, ultimoDiaDoAnoAtual);
        if(totalVendasDoAno.getValor() == null){
            totalVendasDoAno.setValor(BigDecimal.ZERO);
        }
        return totalVendasDoAno.getValor();
    }
}
