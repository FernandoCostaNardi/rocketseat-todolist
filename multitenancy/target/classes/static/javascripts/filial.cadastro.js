$(function() {
	
	var clienteDataPicker = $( "select:first" );
	var botaoSelecionar = $('.js-btn-filial-cliente-selecionar');
	var botaoCancelar = $('.js-btn-filial-cliente-cancelar');
	var clienteSelecionado = $('.js-input-filial-cliente-selecionado');

	var clienteInput = $('#clienteSelecionado');
	var tipoPessoa = $('#blopessoa');
	var cpfCnpj =$('#cpfOuCnpj');
	var tamanhoCPFCNPJ = 	$('#tamanhocpfOuCnpj')
	var apelido = $('#apelido');
	var telefone = $('#telefone');
	var email = $('#email');
	var endereco = $('#logradouro');
	var numero = $('#numero');
	var complemento = $('#complemento');
	var CEP = $('#cep');
	var estado = $('#estado');
	var cidade = $('#cidade');
	
	botaoSelecionar.on('click', selecionarCliente);
	botaoCancelar.on('click', cancelarCliente);
	
	
	function selecionarCliente(event) {
		if (clienteDataPicker.val() == 0) {
				
			swal(
					  'Atenção',
					  'Voce deve selecionar pelo menos um cliente!',
					  'error'
					)
            return false;
		}
				
		var textoOptionSelecionado = $('#cliente option:selected').text()
		clienteInput.prop("value", textoOptionSelecionado);
		clienteDataPicker.removeClass("form-control").addClass("cn-display-none");
		clienteSelecionado.removeClass("cn-display-none").addClass("form-control");
		botaoSelecionar.addClass('cn-display-none');
		botaoCancelar.removeClass('cn-display-none');
		tamanhoCPFCNPJ.removeClass("col-sm-12").addClass("col-sm-10");
		tipoPessoa.removeClass('cn-display-none');
		apelido.prop("disabled", false);
		telefone.prop("disabled", false);
		email.prop("disabled", false);
		endereco.prop("disabled", false);
		numero.prop("disabled", false);
		complemento.prop("disabled", false);
		CEP.prop("disabled", false);
		cidade.prop("disabled", false);
		 $('input[type="radio"]').prop('checked', false);
	}
	
	function cancelarCliente() {
	clienteDataPicker.removeClass( "cn-display-none" ).addClass( "form-control" );
	clienteSelecionado.removeClass( "form-control" ).addClass( "cn-display-none" );
	botaoCancelar.addClass('cn-display-none');
	botaoSelecionar.removeClass('cn-display-none')
	
	 tipoPessoa.addClass('cn-display-none');
	 tamanhoCPFCNPJ.removeClass("col-sm-10").addClass("col-sm-12");
	 $('input[type="radio"]').prop('checked', false);
	 cpfCnpj.prop("value", "").prop("disabled", true);
	 apelido.prop("value", "").prop("disabled", true);
	 telefone.prop("value", "").prop("disabled", true);
	 email.prop("value", "").prop("disabled", true);
	 endereco.prop("value", "").prop("disabled", true);
	 numero.prop("value", "").prop("disabled", true);
	 complemento.prop("value", "").prop("disabled", true);
	 CEP.prop("value", "").prop("disabled", true);
	 cidade.prop("value", "").prop("disabled", true);
	
	
	}
	
});
