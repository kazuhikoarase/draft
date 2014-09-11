angular.module('hello', [])
.controller('HelloController', function($scope, $http, $rootScope) {

  $scope.helloModel = {};

  $scope.opts = [
    {value: '01', label: 'apple'},
    {value: '02', label: 'orange'},
    {value: '03', label: 'pine'}
  ];

  $scope.callServer = function(method) {
  
    $http({
      url: 'remoting/HelloJSON/' + method,
      method: 'POST',
      data: JSON.stringify(angular.copy($scope.helloModel) ),
      headers: {'Content-Type': 'application/json'}
    }).success(function (data, status, headers, config) {
      console.log(data);
      $scope.helloModel = data;
    }).error(function (data, status, headers, config) {
    });
  };

  $scope.callServer('init');
});
