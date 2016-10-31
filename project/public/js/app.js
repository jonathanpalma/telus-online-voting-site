/**
 * Created by palma on 10/30/16.
 */
var app = angular.module("votingApp", ["chart.js"]);
var controllers = {};

app.config(['ChartJsProvider', function (ChartJsProvider) {
    // Configure all charts
    ChartJsProvider.setOptions({
        responsive: true,
        maintainAspectRatio: false
    });
}]);

controllers.navCtrl = function($scope, $http){
    $scope.user = {};

    $http.get("/api/session")
        .success(function(data) {
            $scope.user = data;
        });
};

controllers.chartCtrl = function ($scope, $interval, $http) {
    $scope.labels = ["Candidate 1", "Candidate 2", "Candidate 3"];
    $scope.data = [
        Math.floor((Math.random() * 150) + 1),
        Math.floor((Math.random() * 150) + 1),
        Math.floor((Math.random() * 150) + 1)
    ];
    $scope.statistics = [];
    $scope.countries = [];

    $http.get("/api/country")
        .success(function(data) {
            $scope.countries = data;
        });

    $scope.changeTab = function(type){
        console.log("Tab changed to " + type);

        if (type != 'country'){

        } else {

        }
    };

    for(var i = 0; i < $scope.data.length; i++){
        $scope.statistics.push({ label: $scope.labels[i], data: $scope.data[i]}) ;
    }

    $interval(function () {
        for(var i = 0; i < $scope.data.length; i++){
            $scope.data[i] += Math.floor((Math.random() * 150) + 1);
            $scope.statistics[i].data = $scope.data[i];
        }
        console.log("data: " + JSON.stringify($scope.data));
        $scope.$emit('$resize');
    }, 5000);
};

controllers.signupCtrl = function($scope, $http){
    $scope.countries = [];

    $http.get("/api/countries")
        .success(function(data) {
            $scope.countries = data;
        });
};

app.controller(controllers);