'use strict';

angular.module('GameApp').controller('GameRestController',
		[ 'GameService', function(GameService) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};
			
			self.games = [];

			self.fetchAllGames = function(){
				GameService.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return GameService.createGame(self.game).then( function() {
				self.game = {};
				self.fetchAllGames();
				});
			}
			
			self.selectGame = function(selectedGame){
				self.game = angular.copy(selectedGame);
			}
			
			self.deleteGame = function(gameToDelete){
				return GameService.deleteGame(gameToDelete.id).then( function() {
					self.fetchAllGames();
				});
			}
			
			self.clearForm = function(){
				self.game = {};
			}
			

			self.fetchAllGames();
			
		} ]);
