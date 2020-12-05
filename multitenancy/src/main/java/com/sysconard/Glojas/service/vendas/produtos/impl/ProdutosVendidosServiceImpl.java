package com.sysconard.Glojas.service.vendas.produtos.impl;

import com.sysconard.Glojas.DTO.dashboard.InfoProdutoDashboardDTO;
import com.sysconard.Glojas.repository.Produtos;
import com.sysconard.Glojas.service.vendas.produtos.ProdutosVendidosService;
import com.sysconard.Glojas.util.DatasUtil;
import com.sysconard.Glojas.util.OperacaoUtil;
import com.sysconard.Glojas.util.TipoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutosVendidosServiceImpl implements ProdutosVendidosService {

    @Autowired
    private Produtos produtoRepository;

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

    List<InfoProdutoDashboardDTO> list = new ArrayList<>();

    @Override
    public List<InfoProdutoDashboardDTO> totalQuantidadeProdutoVendaDia() {
        List<InfoProdutoDashboardDTO> total = produtoRepository.recuperarQuantidadeProdutosVendidos(tipoPDVEDanfe, operacaoVenda, hoje, hoje);
        if(total == null){
            return list;
        }
        return total;
    }

    @Override
    public List<InfoProdutoDashboardDTO> totalQuantidadeProdutoVendaMes() {
        List<InfoProdutoDashboardDTO> total = produtoRepository.recuperarQuantidadeProdutosVendidos(tipoPDVEDanfe, operacaoVenda, primeiroDiaDoMesAtual, ultimoDiaDoMesAtual);
        if(total == null){
            return list;
        }
        return total;
    }

    @Override
    public List<InfoProdutoDashboardDTO> totalQuantidadeProdutoVendaAno() {
        List<InfoProdutoDashboardDTO> total = produtoRepository.recuperarQuantidadeProdutosVendidos(tipoPDVEDanfe, operacaoVenda, primeiroDiaDoAnoAtual, ultimoDiaDoAnoAtual);
        if(total == null){
            return list;
        }
        return total;
    }

    @Override
    public List<InfoProdutoDashboardDTO> listaVendasDoDia() {
        List<InfoProdutoDashboardDTO> total = produtoRepository.recuperarListaProdutosVendidos(tipoPDVEDanfe, operacaoVenda, hoje, hoje);
        if(total == null){
            return list;
        }
        return total;
    }

    @Override
    public List<InfoProdutoDashboardDTO> listaVendasDoMes() {
        List<InfoProdutoDashboardDTO> total = produtoRepository.recuperarListaProdutosVendidos(tipoPDVEDanfe, operacaoVenda, primeiroDiaDoMesAtual, ultimoDiaDoMesAtual);
        if(total == null){
            return list;
        }
        return total;
    }

    @Override
    public List<InfoProdutoDashboardDTO> listaVendasDoAno() {
        List<InfoProdutoDashboardDTO> total = produtoRepository.recuperarListaProdutosVendidos(tipoPDVEDanfe, operacaoVenda, primeiroDiaDoAnoAtual, ultimoDiaDoAnoAtual);
        if(total == null){
            return list;
        }
        return total;
    }
}
