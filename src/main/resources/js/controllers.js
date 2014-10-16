'use strict';

/* Controllers */

angular.module('myApp.controllers', [])
.run(function($rootScope) {
    $rootScope.heroId = "931";
})

.controller('HeroCardCtrl', function ($scope, $rootScope, zoinAPIService) { 
    $scope.init = function() {
        $scope.hero = zoinAPIService.Hero.get({"heroId": $rootScope.heroId}); // Example to filter hero according ID  
    }
    
    $scope.init();    
     $scope.$watch('heroId', function() {
       $scope.init();
   });
})

.controller('MissionCardCtrl', function ($scope, $rootScope, zoinAPIService) {
    $scope.mission = zoinAPIService.Mission.get({"missionId": "1"});
})

.controller('DashboardCtrl', function ($scope, $rootScope, zoinAPIService) {
    $scope.init = function() {
        $scope.missions = zoinAPIService.Mission.query();
        $scope.match = zoinAPIService.Match.query({"heroId": $rootScope.heroId});
    }
    
    $scope.init();    
     $scope.$watch('heroId', function() {
       $scope.init();
   });
    
    
    
    $scope.showMission = function(mission) {
        mission.isActive = true;
    }
})

.controller('ApiCtrl', function ($scope) {
    
});