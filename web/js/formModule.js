

var formModule = angular.module('formModule', [])
.controller('FormController', [ '$http', '$scope', function($http, $scope) {
		var self = this;
		$scope.login = function(user) {
			 $("#glyphiconid").show();
			
	        $http.post('/orga/login/login',user).then(function(response) {
				$scope.data = response.data;
				if($scope.data.successful) {
					Andromeda.setSessionValue("email", $scope.data.responseObject.email);
					Andromeda.setSessionValue("password", $scope.data.responseObject.password);
					Andromeda.setSessionValue("type", $scope.data.responseObject.type);
					
			
					
					console.log(Andromeda.getSessionValue("type"));               
					 if(Andromeda.getSessionValue("type") =="Admin")            
						{    
		   			Andromeda.showAdminDashboard();
						}
					else if(Andromeda.getSessionValue("type") == "Farmer"){
						Andromeda.showFarmerLogin();
				
					}
					else{
						Andromeda.showLoginShop();
					}
				} else {
					$("#glyphiconid").hide();
					
					alert("Invalid Login Cradentials");
					console.log("Error while validating user");
				}
			}, function(errResponse) {              
				console.error('Error while fetching notes');
			});
	    };
	    
	    $scope.forgot = function(mail)
		{
	    	alert("Please wait while connecting to the server!");
			if(mail != null)                       
			{
				
				$http.post('/orga/login/forgot', mail).then(function(response) 
				{
					
					$scope.data = response.data;
					if($scope.data.successful) 
					{
						
						alert("A mail has been sent!");
						
					}
					else 
					{
			
						alert($scope.data.errorMessage);
					}
				},
				function(errResponse) 
				{
					console.error('Error while fetching notes');
				});
			}
			else
			{
				alert("Please enter email-Id");
			}
	    };
	 // View Data from Database
	$http.post('/orga/login/getAll').then(function(response) {
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