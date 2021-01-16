package com.sysconard.Glojas.service.vendas.produtos;

import com.sysconard.Glojas.DTO.dashboard.InfoProdutoDashboard;

import java.util.List;

public interface ProdutosVendidosService {

    List<InfoProdutoDashboard> totalQuantidadeProdutoVendaDia();
    List<InfoProdutoDashboard> totalQuantidadeProdutoVendaMes();
    List<InfoProdutoDashboard> totalQuantidadeProdutoVendaAno();

    List<InfoProdutoDashboard> listaVendasDoDia();
    List<InfoProdutoDashboard> listaVendasDoMes();
    List<InfoProdutoDashboard> listaVendasDoAno();
}
