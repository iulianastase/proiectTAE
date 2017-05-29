app
    .controller('loginController',function($scope, $location, $http,$rootScope){
        console.log("login controller");
        $scope.registerUser = {userId: null, username: null, name: null, password: null, cities: null};
    $scope.ok = function(){
        $http({
            method : 'POST',
            url: '/loginPage',
            data:{
                username: $scope.username,
                password: $scope.password,
            }
        }).then(function successCallback(response){
            console.log(response.data);
            if(response.data){
                $location.path('/weather');
                console.log("weather");
                $rootScope.username = $scope.username;
            }
            console.log(response);
        })
    }

    $scope.register = function(){
        var url = 'http://localhost:8080/user/newUser'
        $http({
            method: 'PUT',
            url: url,
            data: $scope.registerUser
        }).then(function successCallback(response) {
            $scope.registerUser = {userId: null, username: null, name: null, password: null, cities: null};
            console.log(response.data);
        })

    }
}
);