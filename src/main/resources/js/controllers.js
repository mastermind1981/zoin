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
<<<<<<< HEAD
        $scope.matches = zoinAPIService.Match.query({"heroId": $rootScope.heroId});
=======
        $scope.match = zoinAPIService.Match.query({"heroId": $rootScope.heroId});
        $scope.left = 0;
>>>>>>> e9094a68e381e534e0b4632a6c604981cbb00a99
    }
    
    $scope.init();    
     $scope.$watch('heroId', function() {
       $scope.init();
    });
    $scope.join = function(mission){
            zoinAPIService.Want.save({"missionId":mission.id, "heroId": $rootScope.heroId});
        }
    
    $scope.showMission = function(mission) {
        mission.isActive = true;
    }
    
    $scope.moveLeft = function() {
        $scope.left = $scope.left - 100;
    }
    
    $scope.moveRight = function() {
        $scope.left = $scope.left + 100;
    }
})

.controller('ApiCtrl', function ($scope) {
    
});