angular.module("listaTelefonica").directive("uiAccordions", function(){
	return {
		controller: function($scope, $element, $attrs){
			var accordions = [];
			this.resgisterAccordion = function(accordion){
				accordions.push(accordion);
			};
			this.closeAll = function(){
				accordions.forEach(function(accordion){
					accordion.isOpened = false;
				});
			}
		}
	};
});

angular.module("listaTelefonica").directive("uiAccordion", function(){
	return {
		transclude: true,
		templateUrl: "view/accordion.html",
		scope:{
			title: "@"
		},
		require: "^uiAccordions",
		link: function(scope, element, attrs, ctrl){
			ctrl.resgisterAccordion(scope);
			scope.open = function (){
				ctrl.closeAll();
				scope.isOpened = !scope.isOpened;
			}
		}
	};
});