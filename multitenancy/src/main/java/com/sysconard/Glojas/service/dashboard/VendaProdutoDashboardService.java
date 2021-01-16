package com.sysconard.Glojas.service.dashboard;

import com.sysconard.Glojas.DTO.dashboard.InfoProdutoDashboard;

public interface VendaProdutoDashboardService {

    InfoProdutoDashboard produtoMaisVendidoDoDia();
    InfoProdutoDashboard produtoMaisVendidoDoMes();
    InfoProdutoDashboard produtoMaisVendidoDoAno();

    InfoProdutoDashboard produtoComMaiorValorAgregadoVendidoNodia();
    InfoProdutoDashboard produtoComMaiorValorAgregadoVendidoNoMes();
    InfoProdutoDashboard produtoComMaiorValorAgregadoVendidoNoAno();
}
