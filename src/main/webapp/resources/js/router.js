'use strict';

/**
 * Performs the navigation of the application
 */

PF.config(['$routeProvider', '$locationProvider',
    function($routeProvider, $locationProvider) {
      $routeProvider.when('/sample', {
        templateUrl: 'views/sample.html',
        controller: 'SampleController'
      });
    }]);
