'use strict';

angular.module('proiectApp')
    .controller('RecomadariController', function ($scope, Principal, $http, $location) {
        Principal.identity().then(function(account) {
            $scope.account = account;
            $scope.isAuthenticated = Principal.isAuthenticated;
            $scope.loadConcerts()
            $scope.loadConcertsRec()
        });


        $scope.gotSspecificPage = function(concert){
            $location.path('/concert/' + concert.id)
        }

        $scope.loadConcerts = function(){
            $http.get('/api/concertebyConcertType/' + $scope.account.concertType)
                .success(function(data){

                    $scope.concerte = data;
                })
        }

        $scope.loadConcertsRec = function(){
            var recJson = JSON.parse($scope.account.recomandation)
            var obj;
            var stored = -1;
            var storedKey = -1;
            for (var key in recJson) {
                 obj = recJson[key];
                 if(stored < obj){
                     stored = obj;
                     storedKey = key
                 }

            }
            if( $scope.account.concertType != storedKey) {
                $http.get('/api/concertebyConcertType/' + storedKey)
                    .success(function (data) {

                        $scope.concerteRec = data;
                    })
            }
        }



    });
