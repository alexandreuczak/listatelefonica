angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function ($scope, contatosAPI, operadorasAPI, serialGenerator){
		$scope.app = "Lista Telefonica";
		$scope.contatos = [];
		var carregarContatos = function (){
			contatosAPI.getContatos().success(function(data){
				
				$scope.contatos = data;
			}).error(function(data, status){
				$scope.error = "Não foi possivel carregar os dados";
			});;
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
			//contato.data = new Date();
			contato.serial = serialGenerator.generate();
			contatosAPI.salvarContato(contato).success(function(){
				carregarContatos();
			});
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