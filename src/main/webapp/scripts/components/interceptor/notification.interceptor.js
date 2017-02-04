 'use strict';

angular.module('proiectApp')
    .factory('notificationInterceptor', function ($q, AlertService) {
        return {
            response: function(response) {
                var alertKey = response.headers('X-proiectApp-alert');
                if (angular.isString(alertKey)) {
                    AlertService.success(alertKey, { param : response.headers('X-proiectApp-params')});
                }
                return response;
            }
        };
    });
