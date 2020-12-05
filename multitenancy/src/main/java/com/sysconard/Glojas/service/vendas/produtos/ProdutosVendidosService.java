package com.sysconard.Glojas.service.vendas.produtos;

import com.sysconard.Glojas.DTO.dashboard.InfoProdutoDashboardDTO;
import com.sysconard.Glojas.DTO.dashboard.InfoVendedoresDashboardDTO;

import java.util.List;

public interface ProdutosVendidosService {

    List<InfoProdutoDashboardDTO> totalQuantidadeProdutoVendaDia();
    List<InfoProdutoDashboardDTO> totalQuantidadeProdutoVendaMes();
    List<InfoProdutoDashboardDTO> totalQuantidadeProdutoVendaAno();

    List<InfoProdutoDashboardDTO> listaVendasDoDia();
    List<InfoProdutoDashboardDTO> listaVendasDoMes();
    List<InfoProdutoDashboardDTO> listaVendasDoAno();
}
