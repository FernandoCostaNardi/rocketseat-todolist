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
		this.comboContaCorrente = $('#contaCorrente');		
		this.comboOperadora =$('#operadora');
		this.combo = $('#filial');
		this.imgLoading = $('.js-img-loading');
		this.inputHiddenClienteSelecionado = $('#inputHiddenFilialSelecionada')
		
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	}
	
	ComboFiliais.prototype.iniciar = function() {
		reset.call(this);
		this.comboCliente.on('alterado', onClienteAlterado.bind(this));
		this.combo.on('change', onFilialAlterado.bind(this));
		var codigoCliente = this.comboCliente.combo.val();
		inicializarFilial.call(this, codigoCliente);
	}
	
	function onFilialAlterado() {
		this.emitter.trigger('alterado', this.combo.val());
	}
	
	function onClienteAlterado(evento, codigoCliente) {
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
		   options.push('<option value="">Selecione a filial</option>');
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
		this.comboContaCorrente.html('<option value="">Selecione a conta corrente</option>');
		this.comboContaCorrente.val('');
		this.comboContaCorrente.attr('disabled', 'disabled');
		this.comboOperadora.val('');
		this.comboOperadora.attr('disabled', 'disabled');
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

SysCoNard.ComboContaCorrente = (function() {
	
	function ComboContaCorrente(comboFiliais) {
		this.comboFiliais = comboFiliais;
		this.combo = $('#contaCorrente');		
		this.comboOperadora =$('#operadora');
		this.imgLoading = $('.js-img-loading');
		this.inputHiddenContaCorrenteSelecionado = $('#inputHiddenContaCorrenteSelecionada')
	}
	
	ComboContaCorrente.prototype.iniciar = function() {
		reset.call(this);
		this.comboFiliais.on('alterado', onFilialAlterado.bind(this));
		var codigoFilial = this.comboFiliais.combo.val();
		//inicializarContaCorrente.call(this, codigoFilial);
	}
	
	function onFilialAlterado(evento, codigoFilial) {
		this.inputHiddenContaCorrenteSelecionado.val('');
		inicializarContaCorrente.call(this, codigoFilial);
	}
	
	function inicializarContaCorrente(codigoFilial) {
		if(codigoFilial){
			var resposta = $.ajax({
				url: this.combo.data('url'),
				method: 'GET',
				contentType: 'application/json',
				data: { 'filial': codigoFilial },
				beforeSend: iniciarRequisicao.bind(this),
				complete: finalizarRequisicao.bind(this)
			});
			resposta.done(onBuscarContaCorrenteFinalizado.bind(this));
		} else {
			reset.call(this);
		}
		
	}
	
	function onBuscarContaCorrenteFinalizado(filiais) {
		var options = [];
		filiais.forEach(function(contaCorrente) {
			options.push('<option value="' + contaCorrente.codigo + '">' + contaCorrente.agencia + ' - ' + contaCorrente.numero + '</option>');
		})
		this.combo.html(options.join(''));
		this.combo.removeAttr('disabled');
		this.comboOperadora.removeAttr('disabled');
		
		var codigoContaCorrenteSelecionada = this.inputHiddenContaCorrenteSelecionado.val();
		if(codigoContaCorrenteSelecionada){
			this.combo.val(codigoContaCorrenteSelecionada);
		}
	}
	
	function reset() {
		this.combo.html('<option value="">Selecione a conta corrente</option>');
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
	
	return ComboContaCorrente;
	
}());

$(function() {
	
	var comboCliente = new SysCoNard.ComboCliente();
	comboCliente.iniciar();
	
	var comboFiliais = new SysCoNard.ComboFiliais(comboCliente);
	comboFiliais.iniciar();

	var comboContaCorrente = new SysCoNard.ComboContaCorrente(comboFiliais);
	comboContaCorrente.iniciar();
});