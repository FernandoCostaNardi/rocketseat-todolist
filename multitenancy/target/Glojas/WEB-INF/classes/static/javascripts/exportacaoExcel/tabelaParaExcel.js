$(document).ready(function(){
	
//	*** Vendas Totais do dia ***
	
	$('#btnExportExcelCompras').on('click', function() {
		$('#pesquisaTableCompras').table2excel({
			exclude: ".noExl",
			name: "AnaliseDeCompras",
			filename: "AnaliseDeCompras"	
		});
	});
	
	$('#btnExportExcel').on('click', function() {
		$('#tableValorTotalDiarioPorLoja').table2excel({
			exclude: ".noExl",
			name: "VendasTotaisDeHojePorLoja",
			filename: "VendasTotaisDeHojePorLoja"	
		});
	});
	
	$('#btnExportExcelPDV').on('click', function() {
		$('#tableValorTotalDiarioPorLojaPDV').table2excel({
			exclude: ".noExl",
			name: "VendasTotaisDeHojePorLojaPDV",
			filename: "VendasTotaisDeHojePorLojaPDV"	
		});
	});
	
	$('#btnExportExcelDanfe').on('click', function() {
		$('#tableValorTotalDiarioPorLojaDanfe').table2excel({
			exclude: ".noExl",
			name: "VendasTotaisDeHojePorLojaDanfe",
			filename: "VendasTotaisDeHojePorLojaDanfe"	
		});
	});

//	*** Vendas Totais do mês ***	
	
	$('#btnExportExcel').on('click', function() {
		$('#tableValorTotalDoMesPorLoja').table2excel({
			exclude: ".noExl",
			name: "VendasTotaisDoMesPorLoja",
			filename: "VendasTotaisDoMesPorLoja"	
		});
	});
	
	$('#btnExportExcelPDV').on('click', function() {
		$('#tableValorTotalDoMesPorLojaPDV').table2excel({
			exclude: ".noExl",
			name: "VendasTotaisDoMesPorLojaPDV",
			filename: "VendasTotaisDoMesPorLojaPDV"	
		});
	});
	
	$('#btnExportExcelDanfe').on('click', function() {
		$('#tableValorTotalDoMesPorLojaDanfe').table2excel({
			exclude: ".noExl",
			name: "VendasTotaisDoMesPorLojaDanfe",
			filename: "VendasTotaisDoMesPorLojaDanfe"	
		});
	});

//	*** Vendas Totais do ano ***	
	
	$('#btnExportExcel').on('click', function() {
		$('#tableValorTotalDoAnoPorLoja').table2excel({
			exclude: ".noExl",
			name: "VendasTotaisDoAnoPorLoja",
			filename: "VendasTotaisDoAnoPorLoja"	
		});
	});
	
	$('#btnExportExcelPDV').on('click', function() {
		$('#tableValorTotalDoAnoPorLojaPDV').table2excel({
			exclude: ".noExl",
			name: "VendasTotaisDoAnoPorLojaPDV",
			filename: "VendasTotaisDoAnoPorLojaPDV"	
		});
	});
	
	$('#btnExportExcelDanfe').on('click', function() {
		$('#tableValorTotalDoAnoPorLojaDanfe').table2excel({
			exclude: ".noExl",
			name: "VendasTotaisDoAnoPorLojaDanfe",
			filename: "VendasTotaisDoAnoPorLojaDanfe"	
		});
	});
	
//	*** Vendas Detalhadas por Loja ***	
	
	$('#btnExportExcel').on('click', function() {
		$('#tableVendasDetalhadasPorLoja').table2excel({
			exclude: ".noExl",
			name: "VendasDetalhadasPorLoja",
			filename: "VendasDetalhadasPorLoja"	
		});
	});	

//	*** Vendas Totais Por Periodo Por Loja ***	
	
	$('#btnExportExcel').on('click', function() {
		$('#tableVendasTotaisPorPeriodoPorLoja').table2excel({
			exclude: ".noExl",
			name: "VendasTotaisPorPeriodoPorLoja",
			filename: "VendasTotaisPorPeriodoPorLoja"	
		});
	});

//	*** Comissao Total Por Periodo ***	
	
	$('#btnExportExcel').on('click', function() {
		$('#tableComissaoTotalPorPeriodo').table2excel({
			exclude: ".noExl",
			name: "ComissaoTotalPorPeriodo",
			filename: "ComissaoTotalPorPeriodo"	
		});
	});	
	
//	*** Marcas Cadastradas ***	
	
	$('#btnExportExcel').on('click', function() {
		$('#tableMarcas').table2excel({
			exclude: ".noExl",
			name: "Marcas",
			filename: "Marcas"	
		});
	});	
	
//	*** Produtos Cadastrados ***	
	
	$('#btnExportExcel').on('click', function() {
		$('#tableProdutos').table2excel({
			exclude: ".noExl",
			name: "Produtos",
			filename: "Produtos"	
		});
	});	

	//	*** Lojas  Cadastradas ***	
	
	$('#btnExportExcel').on('click', function() {
		$('#tableLojas').table2excel({
			exclude: ".noExl",
			name: "Lojas",
			filename: "Lojas"	
		});
	});	
	
//	*** Cargos  Cadastrados ***	
	
	$('#btnExportExcel').on('click', function() {
		$('#tableCargos').table2excel({
			exclude: ".noExl",
			name: "Cargos",
			filename: "Cargos"	
		});
	});	
	
//	*** Cargos  Cadastrados ***	
	
	$('#btnExportExcel').on('click', function() {
		$('#tableFuncionarios').table2excel({
			exclude: ".noExl",
			name: "Funcionarios",
			filename: "Funcionarios"	
		});
	});	
	
//**** Margem de Contribuicao Marcas Diaria
	$('#btnExportExcel').on('click', function() {
		$('#tableMargemContribuicaoMarcasDiario').table2excel({
			exclude: ".noExl",
			name: "MargemContribuicaoMarcaDiario",
			filename: "MargemContribuicaoMarcaDiario"	
		});
	});	
	
	//**** Margem de Contribuicao Marcas Mes Atual
	$('#btnExportExcel').on('click', function() {
		$('#tableMargemContribuicaoMarcasMesAtual').table2excel({
			exclude: ".noExl",
			name: "MargemContribuicaoMarcaMesAtual",
			filename: "MargemContribuicaoMarcaMesAtual"	
		});
	});	
	
	//**** Margem de Contribuicao Marcas por Periodo
	$('#btnExportExcel').on('click', function() {
		$('#tableMargemContribuicaoMarcasPorPeriodo').table2excel({
			exclude: ".noExl",
			name: "MargemContribuicaoMarcaPorPeriodo",
			filename: "MargemContribuicaoMarcaPorPeriodo"	
		});
	});	
	
	//**** Margem de Contribuicao Grupo por Periodo
	$('#btnExportExcel').on('click', function() {
		$('#tableMargemContribuicaoGrupoPorPeriodo').table2excel({
			exclude: ".noExl",
			name: "MargemContribuicaoGrupoPorPeriodo",
			filename: "MargemContribuicaoGrupoPorPeriodo"	
		});
	});	
	
	//**** Margem de Contribuicao Subgrupo por periodo
	$('#btnExportExcel').on('click', function() {
		$('#tableMargemContribuicaoSubGrupoPorPeriodo').table2excel({
			exclude: ".noExl",
			name: "MargemContribuicaoSubGrupoPorPeriodo",
			filename: "MargemContribuicaoSubGrupoPorPeriodo"	
		});
	});	
	
	
//	*** Estoque Atual ***	
	var table = $('#tableEstoqueAtual').DataTable();
	$('#btnExportExcel').on('click', function() {
		$('<table>').append(table.$('tr').clone()).table2excel({
			exclude: ".noExl",
			name: "EstoqueAtual",
			filename: "EstoqueAtual"	
		});
	});	
	
	
})