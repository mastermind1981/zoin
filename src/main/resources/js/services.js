'use strict';

/* Services */



// Demonstrate how to register services
angular.module('myApp.services', []).factory('zoinAPIService', function ($resource) {

    var zoinAPI = {};

    zoinAPI.Hero = $resource('/zoin/rest-prefix/heroes/:heroId/', {heroId:'@id'});
    zoinAPI.Mission = $resource('/zoin/rest-prefix/missions/:missionId/', {missionId:'@id'});
    zoinAPI.MissionByLcu = $resource('/zoin/rest-prefix/missions/lcu/:lcuId/', {lcuId:'@id'});
    zoinAPI.Match = $resource('/zoin/rest-prefix/matches/', {});
    zoinAPI.Want =  $resource('/zoin/rest-prefix/wants/', {});
    zoinAPI.CreateWant = function(missionId, heroId)
    {
        return {"missionId": missionId, "heroId": heroId};
    };
    
    return zoinAPI;
});