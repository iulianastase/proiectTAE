var app = angular.module('myApp', ['ngRoute'])
app.config(['$routeProvider',
    function($routeProvider){
        $routeProvider
            .when('/weather',{
                templateUrl:'templates/findCity.html',
                controller:'weatherController'
            })
            .when('/',{
                templateUrl: 'templates/loginPage.html',
                controller: 'loginController'
            })
    }]);



