Brewer = Brewer || {};

Brewer.PesquisaRapidaProduto = (function() {
	
	function PesquisaRapidaProduto() {
		this.pesquisaRapidaProdutoModal = $('#pesquisaRapidaProdutos');
		this.descricaoProduto = $('#descricaoProduto');
		this.pesquisaRapidaBtn = $('.js-pesquisa-rapida-produto-btn'); 
		this.containerTabelaPesquisa = $('#containerTabelaPesquisaRapidaProdutos');
		this.htmlTabelaPesquisa = $('#tabela-pesquisa-rapida-produto');
		this.template = Handlebars.compile(this.htmlTabelaPesquisa);
		this.mensagemErro = $('.js-mensagem-erro');
	}
	
	PesquisaRapidaProduto.prototype.iniciar = function() {
		this.pesquisaRapidaBtn.on('click', onPesquisaRapidaClicado.bind(this));
		
	}

	function onPesquisaRapidaClicado(event) {
		event.preventDefault();
		console.log(this.descricaoProduto.val());
//		$.ajax({
//			url: this.pesquisaRapidaProdutoModal.find('form').attr('action'),
//			method: 'GET',
//			contentType: 'application/json',
//			data: {
//				 descricao: this.descricaoProduto.val()
//			},
//			success: onPesquisaConcluida.bind(this),
//			error: onErroPesquisa.bind(this)
//		});
		
	}
	
	function onPesquisaConcluida(resultado) {
		var html = this.template(resultado);
		this.containerTabelaPesquisa.html(html);
		this.mensagemErro.addClass('hidden');
		
	}
	
	function onErroPesquisa() {
		this.mensagemErro.removeClass('hidden');
	}
	
	return PesquisaRapidaProduto;
	
}());

$(function() {
	var pesquisaRapidaProduto = new Brewer.PesquisaRapidaProduto();
	pesquisaRapidaProduto.iniciar();
});