package com.sysconard.Glojas.service.dashboard.impl;

import com.sysconard.Glojas.DTO.dashboard.InfoProdutoDashboardDTO;
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
    public InfoProdutoDashboardDTO produtoMaisVendidoDoDia() {
        List<InfoProdutoDashboardDTO> vendas = produtosVendidosService.totalQuantidadeProdutoVendaDia();

        if(vendas.size() == 0){
            InfoProdutoDashboardDTO dto = InfoProdutoDashboardDTO.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
}

    @Override
    public InfoProdutoDashboardDTO produtoMaisVendidoDoMes() {
        List<InfoProdutoDashboardDTO> vendas = produtosVendidosService.totalQuantidadeProdutoVendaMes();

        if(vendas.size() == 0){
            InfoProdutoDashboardDTO dto = InfoProdutoDashboardDTO.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
    }

    @Override
    public InfoProdutoDashboardDTO produtoMaisVendidoDoAno() {
        List<InfoProdutoDashboardDTO> vendas = produtosVendidosService.totalQuantidadeProdutoVendaAno();

        if(vendas.size() == 0){
            InfoProdutoDashboardDTO dto = InfoProdutoDashboardDTO.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
    }

    @Override
    public InfoProdutoDashboardDTO produtoComMaiorValorAgregadoVendidoNodia() {
        List<InfoProdutoDashboardDTO> vendas = produtosVendidosService.listaVendasDoDia();

        if(vendas.size() == 0){
            InfoProdutoDashboardDTO dto = InfoProdutoDashboardDTO.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
    }

    @Override
    public InfoProdutoDashboardDTO produtoComMaiorValorAgregadoVendidoNoMes() {
        List<InfoProdutoDashboardDTO> vendas = produtosVendidosService.listaVendasDoMes();

        if(vendas.size() == 0){
            InfoProdutoDashboardDTO dto = InfoProdutoDashboardDTO.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
    }

    @Override
    public InfoProdutoDashboardDTO produtoComMaiorValorAgregadoVendidoNoAno() {
        List<InfoProdutoDashboardDTO> vendas = produtosVendidosService.listaVendasDoAno();

        if(vendas.size() == 0){
            InfoProdutoDashboardDTO dto = InfoProdutoDashboardDTO.builder().build().criaInstanciaVazia();
            return dto;
        }
        return vendas.get(0);
    }
}
