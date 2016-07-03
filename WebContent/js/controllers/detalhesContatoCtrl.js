angular.module("listaTelefonica").controller('detalhesContatoCtrl', function($scope, $routeParams, contatoResolve){
	$scope.titulo = "Detalhes"
	$scope.contato = contatoResolve.data;
	
});