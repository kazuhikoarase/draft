angular.module('hello', [])
.controller('HelloController', function($scope, $http) {

	$scope.data = {
		firstName: '',
		lastName: '',
		history: []
	};

	$scope.saveChanges = function() {

		$http({
			url: 's/HelloJSON',
			method: 'POST',
			data: JSON.stringify(angular.copy($scope.data) ),
			headers: {'Content-Type': 'application/json'}
		}).success(function (data, status, headers, config) {
			console.log(data);
			$scope.data = data;
		}).error(function (data, status, headers, config) {
		});
	};

} );