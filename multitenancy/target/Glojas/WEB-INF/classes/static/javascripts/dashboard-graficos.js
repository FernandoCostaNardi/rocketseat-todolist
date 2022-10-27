var Sysconard = Sysconard || {};

Sysconard.GraficoVendasPorMes = (function(){
	
	function GraficoVendasPorMes() {
		this.ctx = $('#graficoVendasPorMes')[0].getContext('2d');
	}
	
	GraficoVendasPorMes.prototype.iniciar = function() {
		var graficoVendasPorMes = new Chart(this.ctx, {
			type: 'line',
			data: {
				labels: ['jan', 'fev', 'mar', 'abr', 'jun'],
				datasets: [{
					label: 'Vendas por mês',
					backgroundColor: "rgba(26,179,148,0.5)",
					pointBorderColor: "rbga(26,179,148,1)",
					pointBackgroundColor: "#fff",
					data: [10, 5, 7, 2, 9]	
				}]
			},
		});
		
	}
	
	return GraficoVendasPorMes;
	
}());

$(function() {
	var graficoVendasPorMes = new Sysconard.GraficoVendasPorMes();
	graficoVendasPorMes.iniciar();
});