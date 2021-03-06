angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function ($scope, contatosResolve){
		$scope.app = "Lista Telefonica";
		
		$scope.contatos = contatosResolve.data;
		
		$scope.apagarContatos = function (contatos) {
			$scope.contatos = contatos.filter(function(contato){
				if(!contato.selecionado){
					return contato; 
				}
			});
		};
		
		$scope.isContatoSelecionado = function (contatos){
			return contatos.some(function (contato) {
				return contato.selecionado;
			});
		};
		
		$scope.ordenarPor = function(campo){
			$scope.criterioDeOrdenacao = campo;
			$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
		};

	});