angular.module("listaTelefonica").factory("contatosAPI", function($http, config){
	var _getContatos = function (){
		return $http.get(config.baseUrl + "/listatelefonica/contatos");
	}
	
	var _salvarContato = function (contato){
		return $http.post(config.baseUrl + "/listatelefonica/contatos/salvar", contato);
	}
	
	return {
		getContatos: _getContatos,
		salvarContato: _salvarContato
	}
});