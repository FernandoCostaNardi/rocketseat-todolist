$(function() {
	
	var modal = $('#modalCadastroRapidoEstado');
	var botaoSalvar = modal.find('.js-modal-cadastro-estado-salvar-btn');
	var form = modal.find('form');
	form.on('submit', function(event) { event.preventDefault() });
	var url = form.attr('action');
	var containerMensagemErro = $('.js-mensagem-cadastro-rapido-estado');
	
	var inputNomeEstado = $('#nomeEstado');
	var inputSiglaEstado = $('#siglaEstado');
	
	modal.on('shown.bs.modal', onModalShow);
	modal.on('hide.bs.modal', onModalClose);
	botaoSalvar.on('click', valida_form);
	
	function valida_form (){
		
		if(inputSiglaEstado.val().length < 2){
		alert('Por favor, preencha o campo sigla');
		return false
		}
		onBotaoSalvarClick();
	}
	
	function onModalShow() {
		inputNomeEstado.focus();
	}
	
	function onModalClose() {
		inputNomeEstado.val('');
		inputSiglaEstado.val('');
		var inputCidade = $('#nomeCidade');
		inputCidade.focus();
	}

	function onBotaoSalvarClick() {
		var nomeEstado = inputNomeEstado.val().trim();
		var siglaEstado = inputSiglaEstado.val().trim();
		$.ajax({
			url: url,
			method: 'POST',
			contentType: 'application/json',
		    data: JSON.stringify({"nome": nomeEstado, "sigla": siglaEstado }),
			error: onErroSalvandoEstado,
			success: onEstadoSalvo
			
		});
	}
	
	function onErroSalvandoEstado(obj){
		var mensagemErro = obj.responseText;
		containerMensagemErro.removeClass('hidden');
		containerMensagemErro.html('<span>' + mensagemErro + '</span>');
		form.find('.form-group').addClass('has-error');
	}
	
	function onEstadoSalvo(estadoString) {
		var comboEstilo = $('#estado');
		var arrayEstado = estadoString.split(/\s+/);
		comboEstilo.append('<option value=' + arrayEstado[0] + '>' + arrayEstado[1] + '</option>');
		comboEstilo.val(arrayEstado[0]);
		modal.modal('hide');
		
	}
		
});