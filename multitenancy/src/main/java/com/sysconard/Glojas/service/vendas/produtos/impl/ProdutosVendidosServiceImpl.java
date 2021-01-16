package com.sysconard.Glojas.service.vendas.produtos.impl;

import com.sysconard.Glojas.DTO.dashboard.InfoProdutoDashboard;
import com.sysconard.Glojas.repository.Produtos;
import com.sysconard.Glojas.service.vendas.produtos.ProdutosVendidosService;
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
public class ProdutosVendidosServiceImpl implements ProdutosVendidosService {

    @Autowired
    private Produtos produtoRepository;

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

    List<InfoProdutoDashboard> list = new ArrayList<>();

    @Override
    public List<InfoProdutoDashboard> totalQuantidadeProdutoVendaDia() {
        List<InfoProdutoDashboard> total = produtoRepository.recuperarQuantidadeProdutosVendidos(tipoPDVEDanfe, operacaoVenda, hoje, hoje);
        if(total == null){
            return list;
        }
        return total;
    }

    @Override
    public List<InfoProdutoDashboard> totalQuantidadeProdutoVendaMes() {
        List<InfoProdutoDashboard> total = produtoRepository.recuperarQuantidadeProdutosVendidos(tipoPDVEDanfe, operacaoVenda, primeiroDiaDoMesAtual, ultimoDiaDoMesAtual);
        if(total == null){
            return list;
        }
        return total;
    }

    @Override
    public List<InfoProdutoDashboard> totalQuantidadeProdutoVendaAno() {
        List<InfoProdutoDashboard> total = produtoRepository.recuperarQuantidadeProdutosVendidos(tipoPDVEDanfe, operacaoVenda, primeiroDiaDoAnoAtual, ultimoDiaDoAnoAtual);
        if(total == null){
            return list;
        }
        return total;
    }

    @Override
    public List<InfoProdutoDashboard> listaVendasDoDia() {
        List<InfoProdutoDashboard> total = produtoRepository.recuperarListaProdutosVendidos(tipoPDVEDanfe, operacaoVenda, hoje, hoje);
        if(total == null){
            return list;
        }
        return total;
    }

    @Override
    public List<InfoProdutoDashboard> listaVendasDoMes() {
        List<InfoProdutoDashboard> total = produtoRepository.recuperarListaProdutosVendidos(tipoPDVEDanfe, operacaoVenda, primeiroDiaDoMesAtual, ultimoDiaDoMesAtual);
        if(total == null){
            return list;
        }
        return total;
    }

    @Override
    public List<InfoProdutoDashboard> listaVendasDoAno() {
        List<InfoProdutoDashboard> total = produtoRepository.recuperarListaProdutosVendidos(tipoPDVEDanfe, operacaoVenda, primeiroDiaDoAnoAtual, ultimoDiaDoAnoAtual);
        if(total == null){
            return list;
        }
        return total;
    }
}
