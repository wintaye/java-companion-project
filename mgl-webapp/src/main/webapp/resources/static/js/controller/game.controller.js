'use strict';

angular.module('GameApp').controller('GameController',
		[ 'GameService', function(GameService) {
			var self = this;
			self.game = {
				gameId : '',
				gameName : '',
				gameGenre : ''
			};
			self.games = [];

			self.fetchAllGames = function(){
				GameService.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return GameService.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}

			self.fetchAllGames(); 
		} ]);
