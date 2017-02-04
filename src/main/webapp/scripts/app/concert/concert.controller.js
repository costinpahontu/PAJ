'use strict';

angular.module('proiectApp')
    .controller('ConcertController', function ($scope, Principal, $http, $stateParams, $cookies) {
        Principal.identity().then(function(account) {
            $scope.account = account;
            $scope.isAuthenticated = Principal.isAuthenticated;
            $scope.loadConcers();
            $scope.loadParticipants();

        });


        $scope.updateRecomadations = function(){
            var baseRecomandation = {}
            if($scope.account.recomandation != null && $scope.account.recomandation != "") {
                 baseRecomandation = JSON.parse($scope.account.recomandation)
                if (baseRecomandation[$scope.concert.concert_type]) {
                    baseRecomandation[$scope.concert.concert_type] += 1
                } else {
                    baseRecomandation[$scope.concert.concert_type] = 1
                }
            }else{
                baseRecomandation[$scope.concert.concert_type] = 1

            }

            $scope.account.recomandation = JSON.stringify(baseRecomandation)
            $http.post('/api/account',$scope.account)
                .success(function(user){

                })
        }

        $scope.rating = 1;
        $scope.rateFunction = function(rating) {
            $scope.concert.rating = rating;
            $http.post('/api/concert',$scope.concert)
                .success(function(concert){
                    $scope.rating = rating;

                })

        };

        $scope.loadConcers = function(){

            $http.get('/api/concert/' + $stateParams.id)
                .success(function(concert){
                    $scope.concert = concert[0];
                    $scope.rating = concert[0].rating;
                    $scope.updateRecomadations()
                })
        }

        $scope.loadParticipants = function(){
            $http.get('/api/participantiLaConcert/' + $stateParams.id)
                .success(function(participanti){
                   $scope.participanti = participanti[0].participantiDTOs
                })
        }



    })
    .directive('starRating',
    function() {
        return {
            restrict : 'A',
            template : '<ul class="rating" >'
            + '	<li ng-repeat="star in stars" ng-class="star" ng-click="toggle($index)">'
            + '\u2605'
            + '</li>'
            + '</ul>',
            scope : {
                ratingValue : '=',
                max : '=',
                disabled : '=',
                onRatingSelected : '&'
            },
            link : function(scope, elem, attrs) {
                var updateStars = function() {

                    scope.stars = [];
                    for ( var i = 0; i < scope.max; i++) {
                        scope.stars.push({
                            filled : i < scope.ratingValue
                        });
                    }
                };

                scope.toggle = function(index) {
                    if(!scope.disabled) {
                        scope.ratingValue = index + 1;
                        scope.onRatingSelected({
                            rating: index + 1
                        });
                    }
                };

                scope.$watch('ratingValue',
                    function(oldVal, newVal) {
                        if (newVal) {
                            updateStars();
                        }
                    }
                );
            }
        };
    }
);
