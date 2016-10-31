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
}])


controllers.chartCtrl = function ($scope, $interval) {
    $scope.labels = ["Candidate 1", "Candidate 2", "Candidate 3"];
    $scope.data = [300, 500, 100];
    $scope.statistics = [];

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

app.controller(controllers);