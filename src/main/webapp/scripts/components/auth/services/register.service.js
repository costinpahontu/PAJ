'use strict';

angular.module('proiectApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


