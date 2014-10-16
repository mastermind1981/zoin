'use strict';

/* Controllers */

angular.module('myApp.controllers', []).controller('MyCtrl1', function ($scope, zoinAPIService) {
    $scope.hero = zoinAPIService.Hero.get({"heroId": "931"}); // Example to filter hero according ID
}).controller('MissionCardCtrl', function ($scope, zoinAPIService) {
    $scope.mission = zoinAPIService.Mission.get({"id": "567"});
    console.log($scope.mission);
});