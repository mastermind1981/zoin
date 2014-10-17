'use strict';

/* Directives */


angular.module('myApp.directives', [])

.directive('appVersion', ['version',
    function (version) {
        return function (scope, elm, attrs) {
            elm.text(version);
        };
    }]
).directive('header', function (zoinAPIService) {
    return {
        templateUrl: 'partials/header.html',
        replace: true,
        link: function ($scope, element, attrs) {
            $scope.init = function() {
                $scope.hero = zoinAPIService.Hero.get({"heroId": $scope.heroId});
            }

            $scope.toggleSubHeader = function(element, $event) {
                $($event.target).parents('.subHeader').toggleClass('open');
            }

            $scope.init();
            $scope.$watch('heroId', function() {
                $scope.init();
            });
        }
    }
 });