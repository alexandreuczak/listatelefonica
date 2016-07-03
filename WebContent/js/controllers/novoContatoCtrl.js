angular.module("listaTelefonica").controller("novoContatoCtrl", function($scope, contatosAPI, operadorasResolve, serialGenerator, $location){
	
	$scope.titulo = "Novo Contato";
	
	$scope.operadoras = operadorasResolve.data;
	
	$scope.adicionarContato = function (contato){
		contato.serial = serialGenerator.generate();
		contatosAPI.salvarContato(contato).success(function(){
			$location.path("/")
		});
		delete $scope.contato;
		$scope.contatoForm.$setPristine();
	};
	
});