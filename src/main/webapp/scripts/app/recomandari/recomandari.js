'use strict';

angular.module('proiectApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('recomandari', {
                parent: 'site',
                url: '/recomandari',
                data: {
                    authorities: []
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/recomandari/recomandari.html',
                        controller: 'RecomadariController'
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
