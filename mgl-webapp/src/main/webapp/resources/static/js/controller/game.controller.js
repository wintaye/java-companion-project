'use strict';

angular.module('GameApp').controller('GameController',
		[ 'GameService', function(GameService) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};
			
			self.games = [];
			/*self.genres = [{name: 'All'}]; 
			self.selectedGenre = 'All';*/

	/*		self.fetchAllGames = function(){
				if(self.selectedGenre == 'All'){
					GameService.fetchAllGames().then(function(data) {
						self.games = data;
						if(self.games.length > 0){
							self.genres = parseGenres();	
						}else{
							self.genres = [{name: 'All'}];//reset genre selection
						}
					})
				} else {
					GameService.filterByGenre(self.selectedGenre).then( function(data) {
						self.games = data;
					});
				}
			}*/
			
			self.fetchAllGames = function(){
				GameService.fetchAllGames().then(function(data) {
					self.games = data;
					self.clearForm(); 
				});
			}
			
			/*function parseGenres(){
				var strArray = [];
				var genreArray = [{name: 'All'}];
				self.games.forEach((game) =>{
					strArray.push( game.genre );
				})
				//turn strArray into a set (no dupes) and add genres to genreArray
				strArray = Array.from( new Set(strArray));
				strArray.forEach((genre) =>{
					genreArray.push({ name : genre });
				})
				return genreArray;
			}
*/

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
			
			self.updateGame = function(){
			  return GameService.updateGame(self.game).then( function() {
				 self.fetchAllGames(); 
				});	
			}
			
			
		} ]);
