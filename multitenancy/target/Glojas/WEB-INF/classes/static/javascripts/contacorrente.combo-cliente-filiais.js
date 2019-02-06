var SysCoNard = SysCoNard || {};

SysCoNard.ComboCliente = (function() {
	
	function ComboCliente() {
		this.combo = $('#cliente');
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	}
	
	ComboCliente.prototype.iniciar = function() {
		this.combo.on('change', onClienteAlterado.bind(this));
	}
	
	function onClienteAlterado() {
		this.emitter.trigger('alterado', this.combo.val());
	}
	
	return ComboCliente;
	
}());


SysCoNard.ComboFiliais = (function() {
	
	function ComboFiliais(comboCliente) {
		this.comboCliente = comboCliente;
		this.combo = $('#filial');
		this.imgLoading = $('.js-img-loading');
		this.inputHiddenClienteSelecionado = $('#inputHiddenFilialSelecionada')
	}
	
	ComboFiliais.prototype.iniciar = function() {
		reset.call(this);
		this.comboCliente.on('alterado', onClienteAlterado.bind(this));
	}
	
	function onClienteAlterado(evento, codigoCliente) {
		var codigoCliente = this.comboCliente.combo.val();
		this.inputHiddenClienteSelecionado.val('');
		inicializarFilial.call(this, codigoCliente);
	}
	
	function inicializarFilial(codigoCliente) {
		if(codigoCliente){
			var resposta = $.ajax({
				url: this.combo.data('url'),
				method: 'GET',
				contentType: 'application/json',
				data: { 'cliente': codigoCliente },
				beforeSend: iniciarRequisicao.bind(this),
				complete: finalizarRequisicao.bind(this)
			});
			resposta.done(onBuscarFiliaisFinalizado.bind(this));
		} else {
			reset.call(this);
		}
		
	}
	
	function onBuscarFiliaisFinalizado(filiais) {
		var options = [];
		filiais.forEach(function(filial) {
			options.push('<option value="' + filial.codigo + '">' + filial.cpfOuCnpj + ' - ' + filial.apelido + '</option>');
		})
		this.combo.html(options.join(''));
		this.combo.removeAttr('disabled');
		
		var codigoFilialSelecionada = this.inputHiddenClienteSelecionado.val();
		if(codigoFilialSelecionada){
			this.combo.val(codigoFilialSelecionada);
		}
	}
	
	function reset() {
		this.combo.html('<option value="">Selecione a filial</option>');
		this.combo.val('');
		this.combo.attr('disabled', 'disabled');
	}
	
	function iniciarRequisicao() {
		reset.call(this);
		this.imgLoading.show();
	}
	
	function finalizarRequisicao() {
		this.imgLoading.hide();
	}
	
	return ComboFiliais;
	
}());

$(function() {
	
	var comboCliente = new SysCoNard.ComboCliente();
	comboCliente.iniciar();
	
	var comboCidade = new SysCoNard.ComboFiliais(comboCliente);
	comboCidade.iniciar();
});