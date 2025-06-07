var Registration1 = angular.module('RegistrationModule1', []);
Registration1.controller('RegistrationController1', ['$http','$scope', function($http, $scope) {
	
$http.post('/orga/user/getAll').then(function(response) {
			$scope.data = response.data;
			if ($scope.data.successful) {
				$scope.userdetails = $scope.data.responseObject;
			} else {
				alert("Can't view the Data");            
			}
		}, function(errResponse) {
			console.error('Error while viewing notes');
		});

} ]);                             