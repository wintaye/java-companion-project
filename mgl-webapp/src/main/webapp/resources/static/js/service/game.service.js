'use strict';

angular.module('GameApp').factory('GameService', ['$http', '$log', function($http, $log) {

		var REST_SERVICE_URI = 'game/';

		var factory = {
			fetchAllGames : fetchAllGames,
			updateGame: updateGame,
			createGame: createGame,
			deleteGame: deleteGame,
			
		};

		return factory;


		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI + 'getAll').then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post(REST_SERVICE_URI, game).then(function(response) {
					return response.data;
				}
			);
		}
		
		function updateGame(game) {
			return $http.put(REST_SERVICE_URI, game).then(function(response) {
					return response.data;
				}
			);
		}
		
		function deleteGame(id) {
			return $http.delete(REST_SERVICE_URI + id).then(function(response) {
				if(response.data){
					$log.info('Successfully deleted game with id: ' + id)
				} else{
					$log.debug('There\'s been a murder! Or there\'s no game with id:' + id)
				}
					return response.data;
				}
			);
		}
		
		
}]);
