package com.sysconard.Glojas.service.dashboard.impl;

import com.sysconard.Glojas.DTO.dashboard.InfoProdutoDashboard;
import com.sysconard.Glojas.service.dashboard.VendaProdutoDashboardService;
import com.sysconard.Glojas.service.vendas.produtos.ProdutosVendidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaProdutoDashboardServiceImpl implements VendaProdutoDashboardService {

    @Autowired
    private ProdutosVendidosService produtosVendidosService;

    @Override
    public InfoProdutoDashboard produtoMaisVendidoDoDia() {
        List<InfoProdutoDashboard> vendas = produtosVendidosService.totalQuantidadeProdutoVendaDia();

        if(vendas.size() == 0){
            InfoProdutoDashboard dto = InfoProdutoDashboard.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
}

    @Override
    public InfoProdutoDashboard produtoMaisVendidoDoMes() {
        List<InfoProdutoDashboard> vendas = produtosVendidosService.totalQuantidadeProdutoVendaMes();

        if(vendas.size() == 0){
            InfoProdutoDashboard dto = InfoProdutoDashboard.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
    }

    @Override
    public InfoProdutoDashboard produtoMaisVendidoDoAno() {
        List<InfoProdutoDashboard> vendas = produtosVendidosService.totalQuantidadeProdutoVendaAno();

        if(vendas.size() == 0){
            InfoProdutoDashboard dto = InfoProdutoDashboard.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
    }

    @Override
    public InfoProdutoDashboard produtoComMaiorValorAgregadoVendidoNodia() {
        List<InfoProdutoDashboard> vendas = produtosVendidosService.listaVendasDoDia();

        if(vendas.size() == 0){
            InfoProdutoDashboard dto = InfoProdutoDashboard.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
    }

    @Override
    public InfoProdutoDashboard produtoComMaiorValorAgregadoVendidoNoMes() {
        List<InfoProdutoDashboard> vendas = produtosVendidosService.listaVendasDoMes();

        if(vendas.size() == 0){
            InfoProdutoDashboard dto = InfoProdutoDashboard.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
    }

    @Override
    public InfoProdutoDashboard produtoComMaiorValorAgregadoVendidoNoAno() {
        List<InfoProdutoDashboard> vendas = produtosVendidosService.listaVendasDoAno();

        if(vendas.size() == 0){
            InfoProdutoDashboard dto = InfoProdutoDashboard.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
    }
}
