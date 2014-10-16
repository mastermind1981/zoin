'use strict';

/* Controllers */

angular.module('myApp.controllers', [])

.controller('HeroCardCtrl', function ($scope, zoinAPIService) {
    $scope.hero = zoinAPIService.Hero.get({"heroId": "931"}); // Example to filter hero according ID    
})

.controller('MissionCardCtrl', function ($scope, zoinAPIService) {
    $scope.mission = zoinAPIService.Mission.get({"missionId": "1"});
    console.log($scope.mission);
})

.controller('DashboardCtrl', function ($scope, zoinAPIService) {
  
})

.controller('ApiCtrl', function ($scope) {
  
});