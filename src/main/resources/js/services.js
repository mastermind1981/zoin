'use strict';

/* Services */



// Demonstrate how to register services
angular.module('myApp.services', []).factory('zoinAPIService', function ($resource) {

    var zoinAPI = {};

    zoinAPI.Hero = $resource('/zoin/rest-prefix/heroes/:heroId/', {heroId:'@id'});
    zoinAPI.Mission = $resource('/zoin/rest-prefix/missions/:id/', {heroId:'@id'});
    zoinAPI.Match = $resource('/zoin/rest-prefix/matches/:id:missionId', {heroId:'@heroId', missionId:'missionId'});

    return zoinAPI;
});