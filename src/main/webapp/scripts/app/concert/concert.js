'use strict';

angular.module('proiectApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('concert', {
                parent: 'site',
                url: '/concert/:id',
                data: {
                    authorities: []
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/concert/concert.html',
                        controller: 'ConcertController'
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
