'use strict';

angular.module('proiectApp')
    .controller('RaportController', function ($scope, Principal, $http, $location) {
        Principal.identity().then(function(account) {
            $scope.account = account;
            $scope.isAuthenticated = Principal.isAuthenticated;
            $scope.loadRaport()

        });


        $scope.loadRaport = function(){
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
            $scope.gotSspecificPage = function(concert){
                $location.path('/concert/' + concert.id)
            }
            $http.get('/api/generateRaport/' + storedKey + "/" + $scope.account.concertType)
                .success(function (data) {
                    $scope.raport = [];
                    $scope.concertsByMonths = {
                        1:[],
                        2:[],
                        3:[],
                        4:[],
                        5:[],
                        6:[],
                        7:[],
                        8:[],
                        9:[],
                        10:[],
                        11:[],
                        12:[]
                    }
                    $scope.propuneri = data
                    var today = new Date();
                    var thismonth = today.getMonth() + 1
                    var thisyear = today.getFullYear() - 1
                    var calculatedMonth = ''
                    for(var i = 0; i < $scope.propuneri.length; i++){
                        var concertDate = new Date($scope.propuneri[i].data)
                        console.log(concertDate)
                        if(concertDate.getFullYear()  == thisyear){
                            if(concertDate.getMonth() + 1 > thismonth){
                                calculatedMonth = concertDate.getMonth() + 1;
                                $scope.concertsByMonths[calculatedMonth].push($scope.propuneri[i])
                            }
                        }

                    }

                    for (var key in $scope.concertsByMonths) {
                        obj = $scope.concertsByMonths[key];

                        var topconcertThatMonth = {
                            rating:0
                        }
                        for(var i = 0; i < obj.length; i++){
                            if(topconcertThatMonth.rating < obj[i].rating){
                                topconcertThatMonth = obj[i]
                            }
                        }

                        $scope.raport.push(topconcertThatMonth);

                    }

                    console.log($scope.raport)
                })
        }







    });
