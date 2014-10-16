'use strict';

/* Services */



// Demonstrate how to register services
angular.module('myApp.services', []).factory('zoinAPIService', function ($resource) {

    var zoinAPI = {};

    zoinAPI.Hero = $resource('/zoin/rest-prefix/helloWorld', {});

    return zoinAPI;
});