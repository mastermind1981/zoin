'use strict';


// Declare app level module which depends on filters, and services
angular.module('myApp', [
    'ngRoute',
    'ngResource',
    'myApp.filters',
    'myApp.services',
    'myApp.directives',
    'myApp.controllers'
]).
config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.when('/dashboard/:heroId', {
            templateUrl: 'partials/dashboard.html',
            controller: 'DashboardCtrl'
        });
        $routeProvider.when('/hero', {
            templateUrl: 'partials/hero.html',
            controller: 'HeroCardCtrl'
        });
        $routeProvider.when('/mission', {
            templateUrl: 'partials/mission.html',
            controller: 'MissionCardCtrl'
        });
        $routeProvider.when('/api', {
            templateUrl: 'partials/api.html',
            controller: 'ApiCtrl'
        });

        $routeProvider.otherwise({
            redirectTo: '/dashboard'
        });
}]);