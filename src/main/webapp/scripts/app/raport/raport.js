'use strict';

angular.module('proiectApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('raport', {
                parent: 'site',
                url: '/raport',
                data: {
                    authorities: []
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/raport/raport.html',
                        controller: 'RaportController'
                    }
                },
                resolve: {
                    mainTranslatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                        $translatePartialLoader.addPart('main');
                        return $translate.refresh();
                    }]
                }
            });
    });
