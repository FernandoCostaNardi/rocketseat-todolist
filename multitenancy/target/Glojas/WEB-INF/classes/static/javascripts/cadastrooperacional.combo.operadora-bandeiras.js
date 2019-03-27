var SysCoNard = SysCoNard || {};

SysCoNard.ComboOperadora = (function() {
	
	function ComboOperadora() {
		this.combo = $('#operadora');
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	}
	
	ComboOperadora.prototype.iniciar = function() {
		this.combo.on('change', onOperadoraAlterada.bind(this));
	}
	
	function onOperadoraAlterada() {
		this.emitter.trigger('alterado', this.combo.val());
	}
	
	return ComboOperadora;
	
}());


SysCoNard.RadioBandeiras = (function() {
	
	function RadioBandeiras(comboOperadora) {
		this.comboOperadora = comboOperadora;
		this.radioBandeiras = $('#teste');		
		this.imgLoading = $('.js-img-loading');
		this.inputHiddenOperadoraSelecionado = $('#inputHiddenComboSelecionada')
	}
	
	RadioBandeiras.prototype.iniciar = function() {
		reset.call(this);
		this.comboOperadora.on('alterado', onOperadoraAlterado.bind(this));
	}
	
	function onOperadoraAlterado(evento, codigoCliente) {
		this.inputHiddenOperadoraSelecionado.val('');
		var codigoOperadora = this.comboOperadora.combo.val();
		inicializarBandeiras.call(this, codigoOperadora);
	}
	
	function inicializarBandeiras(codigoOperadora) {
		if(codigoOperadora){
			var resposta = $.ajax({
				url: this.radioBandeiras.data('url'),
				method: 'GET',
				contentType: 'application/json',
				data: { 'codigo': codigoOperadora },
				beforeSend: iniciarRequisicao.bind(this),
				complete: finalizarRequisicao.bind(this)
			});
			resposta.done(onBuscarOperadoraFinalizado.bind(this));
		} else {
			reset.call(this);
		}
		
	}
	
	function onBuscarOperadoraFinalizado(operadoras) {
		
        
		console.log(operadoras);
		operadoras.forEach(function(operadora) {
	
			for (var int = 0; int <operadora.bandeiras.length; int++) {
				
			
    		console.log(operadora.bandeiras[int].codigo + ' ' + operadora.bandeiras[int].nome);
			}
		});
// this.combo.html(options.join(''));
//		this.combo.removeAttr('disabled');
		
	}
	
	function reset() {
	}
	
	function iniciarRequisicao() {
		reset.call(this);
		this.imgLoading.show();
	}
	
	function finalizarRequisicao() {
		this.imgLoading.hide();
	}
	
	return RadioBandeiras;
	
}());

$(function() {
	
	var comboOperadora = new SysCoNard.ComboOperadora();
	comboOperadora.iniciar();
	
	var radioBandeiras = new SysCoNard.RadioBandeiras(comboOperadora);
	radioBandeiras.iniciar();


});