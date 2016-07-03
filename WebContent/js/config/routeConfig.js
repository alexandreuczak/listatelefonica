angular.module("listaTelefonica").config(function($routeProvider){
	$routeProvider.when("/", {
		templateUrl: "view/contatos.html",
		controller: "listaTelefonicaCtrl",
		resolve: {
			contatosResolve: function(contatosAPI){
				return contatosAPI.getContatos()
			}
		}
	}).when("/novo", {
		templateUrl: "view/novo.html",
		controller: "novoContatoCtrl",
		resolve: {
			operadorasResolve: function(operadorasAPI){
				return operadorasAPI.getOperadoras();
			}
		}
	}).when("/detalhes/:id", {
		templateUrl: "view/detalhes.html",
		controller: "detalhesContatoCtrl",
		resolve: {
			contatoResolve: function(contatosAPI, $route){
				return contatosAPI.getContato($route.current.params.id)
			}
		}
		
	}).otherwise({
		redirectTo: "/"
	});
});