'use strict';

/* Controllers */

angular.module('myApp.controllers', [])
.run(function($rootScope) {
    $rootScope.heroId = 931;
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
    $scope.mission = zoinAPIService.Mission.get({"missionId": 1});
})

.controller('DashboardCtrl', function ($scope, $rootScope, zoinAPIService) {
    $scope.init = function() {
        $scope.missions = zoinAPIService.Mission.query();
        $scope.matches = zoinAPIService.Match.query({"heroId": $rootScope.heroId}, function() {
            $scope.matches[0].mission.isActive = true;
        });
        $scope.left = 180;
        
    }
    
    $scope.init();    
     $scope.$watch('heroId', function() {
       $scope.init();
    });
    $scope.join = function(mission, zoinValue){
            zoinAPIService.Want.save({"missionId":mission.id, "heroId": $rootScope.heroId, "zoins":zoinValue});
            $scope.init();
        }
    
    $scope.showMission = function(mission) {
        $scope.matches.forEach(function(element) {
               element.mission.isActive = false;
        });
        mission.isActive = true;
    }
    
    $scope.moveLeft = function() {
        $scope.left = $scope.left + 200;
    }
    
    $scope.moveRight = function() {
        $scope.left = $scope.left - 200;
    }
})

.controller('ApiCtrl', function ($scope) {
    
});