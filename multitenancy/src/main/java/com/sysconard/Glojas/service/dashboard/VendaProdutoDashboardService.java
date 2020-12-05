package com.sysconard.Glojas.service.dashboard;

import com.sysconard.Glojas.DTO.dashboard.InfoProdutoDashboardDTO;

public interface VendaProdutoDashboardService {

    InfoProdutoDashboardDTO produtoMaisVendidoDoDia();
    InfoProdutoDashboardDTO produtoMaisVendidoDoMes();
    InfoProdutoDashboardDTO produtoMaisVendidoDoAno();

    InfoProdutoDashboardDTO produtoComMaiorValorAgregadoVendidoNodia();
    InfoProdutoDashboardDTO produtoComMaiorValorAgregadoVendidoNoMes();
    InfoProdutoDashboardDTO produtoComMaiorValorAgregadoVendidoNoAno();
}
