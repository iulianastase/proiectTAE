app
    .controller('weatherController', function($scope, $location, $http,$rootScope) {
        $scope.city = {cityId: null, cityName: null, jsonWeather: null, date: null};
        $scope.response = {};
        $scope.userCities = {};


        $scope.setWeather = function(){
            var url = 'http://localhost:8080/user/' + $rootScope.username;
            console.log(url);
            console.log($scope.city);
            $http({
                method : 'Put',
                url: url,
                data: $scope.city

            }).then(function successCallback(response){
                console.log(response.data);
                $scope.getCities();

            },function (err) {
                console.log(err);
            })
        }
        $scope.username = $rootScope.username;

        $scope.getCities = function () {
            var url = 'http://localhost:8080/city/name/' + $scope.username;
            console.log(url);
            $http({
                method: 'GET',
                url: url
            }).then(function successCallback(response) {
                $scope.userCities = response.data;
                console.log($scope.userCities);
            })
        }

        $scope.deleteCity = function (cityId) {
            var url = 'http://localhost:8080/city/' + cityId;
            console.log(url);
            $http({
                method: 'Delete',
                url: url
            }).then(function successCallback(response) {
                console.log(response.data);
                $scope.response = response.data;
                console.log(response);
                $scope.getCities();

            })

        }
        $scope.getWeather = function(){
            var url = 'http://localhost:8080/city/' + $scope.city.cityName;
            console.log(url);
            $http({
                method : 'Get',
                url: url

            }).then(function successCallback(response){
                $scope.setWeather();
                console.log(response.data);
                $scope.response = response.data;
                console.log(response);

            })
        }

        $scope.getForecast = function(cityName){
            console.log(cityName);
            var url = 'http://localhost:8080/city/' +cityName;
            console.log(url);
            $http({
                method : 'Get',
                url: url

            }).then(function successCallback(response){
                console.log(response.data);
                $scope.response = response.data;
                console.log(response);

            })
        }


           $scope.getCities();
    }
);
