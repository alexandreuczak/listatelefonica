angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function ($scope, contatosAPI, operadorasAPI, serialGenerator){
		$scope.app = "Lista Telefonica";
		$scope.contatos = [];

		var carregarContatos = function (){
			contatosAPI.getContatos().success(function(data){
				$scope.contatos = data;
			});
		};
		
		carregarContatos(); 
		$scope.operadoras = [];
					
		var carregarOperadoras = function () {
			operadorasAPI.getOperadoras().success(function(data){
				$scope.operadoras = data;
			});
		};
		
		carregarOperadoras();
		
		$scope.adicionarContato = function (contato){
		
			contato.serial = serialGenerator.generate();
			$scope.contatos.push(angular.copy(contato));
			delete $scope.contato;
			$scope.contatoForm.$setPristine();
		};
		
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