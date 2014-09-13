'use strict';

/**
 * Controllers
 */

PF.controller('SearchController', [
		'$scope',
		'Search',
		'Symptom',
		function($scope, Search, Symptom) {
			$scope.search = function() {
				console.log($scope.keywords);
				var query = "";
				$.each($scope.keywords, function() {
					query = query + this.text + " ";
				});
				
				$scope.results = Search.search({
					keywords : query
				});
				
				/*$scope.specialties = Search.getPhysicianSpecialties({
					
				});*/
			};
			var symptoms = Symptom.query();

			$scope.options = {
				query : function(query) {
					var data = {
						results : []
					};

					$.each(symptoms, function() {
						if (query.term.length == 0
								|| this.name.toUpperCase().indexOf(
										query.term.toUpperCase()) >= 0) {
							data.results.push({
								id : this.id,
								text : this.name
							});
						}
					});
					query.callback(data);
				},
				multiple : true
			};

		} ]);
