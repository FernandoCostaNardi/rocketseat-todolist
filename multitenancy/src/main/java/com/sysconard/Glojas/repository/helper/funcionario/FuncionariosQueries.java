package com.sysconard.Glojas.repository.helper.funcionario;

import com.sysconard.Glojas.DTO.dashboard.InfoVendedoresDashboardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sysconard.Glojas.model.Funcionario;
import com.sysconard.Glojas.repository.filter.FuncionarioFilter;

import java.sql.Timestamp;
import java.util.List;

public interface FuncionariosQueries {

	public Page<Funcionario> filtrar(FuncionarioFilter filtro, Pageable pageable);

	List<InfoVendedoresDashboardDTO> recuperarValorTotalVendas(List<String> tipo, List<String> operacao, Timestamp dataInicial, Timestamp dataFinal);

	List<InfoVendedoresDashboardDTO> recuperarQuantidadeProdutoVendido(List<String> tipo, List<String> operacao, Timestamp dataInicial, Timestamp dataFinal);

	List<InfoVendedoresDashboardDTO> recuperarTotalTrocas(List<String> tipo, List<String> operacao, Timestamp dataInicial, Timestamp dataFinal);
}
