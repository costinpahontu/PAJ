'use strict';

angular.module('proiectApp')
    .controller('MainController', function ($scope, Principal, $http, $location) {
        Principal.identity().then(function(account) {
            $scope.account = account;
            $scope.isAuthenticated = Principal.isAuthenticated;
        });


        $scope.gotSspecificPage = function(concert){
            $location.path('/concert/' + concert.id)
        }

        $http.get('/api/concerte')
            .success(function(data){

                $scope.concerte = data;
            })


    });
