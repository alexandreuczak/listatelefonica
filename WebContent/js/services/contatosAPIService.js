angular.module("listaTelefonica").factory("contatosAPI", function($http, config){
	var _getContatos = function (){
		return $http.get(config.baseUrl + "/listatelefonica/contatos");
	}
	
	return {
		getContatos: _getContatos
	}
});