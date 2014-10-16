'use strict';

/* Controllers */

angular.module('myApp.controllers', []).controller('MyCtrl1', function ($scope, zoinAPIService) {
    $scope.hero = zoinAPIService.Hero.get({"heroId": "1234"}); // Example to filter hero according ID
});