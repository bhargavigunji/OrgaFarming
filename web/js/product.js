var productModule = angular.module('products', []);
            
productModule.controller('addProduct', ['$scope', '$http', function ($scope, $http ) {  
	
	  $scope.pro=function(formData){            
	
	
		  
			 if(formData != undefined)
				{
					if(formData.name == null || formData.name == undefined || formData.name == "")
					{
						alert(" Enter your name");
					}
					
					else if(formData.email == null || formData.email == undefined || formData.email == "")
					{
						alert(" Enter email ID");
					}
		
					else if(formData.product== null || formData.product == undefined || formData.product == "")
                    {
					  alert(" Please enter your products ");
					}
					else if(formData.price== null || formData.price == undefined || formData.price == "")
                    {
					  alert(" Please enter price for your products ");
					}
					 
					else
					{
			 alert("Please wait a while for completing the process ");
			console.log(formData);
			$http.post('/orga/product/add2',formData).then(function(response)
					{

			  $scope.formData = response.data;
				if($scope.formData.successful)
				{
					
					alert("Thanks  for adding products.. Please check your mail. ");
					Andromeda.showFarmerLogin();
			}
				else
				{
					alert({
						title	:	" ",
						text	:	"Your subscription is already completed.For further registration you can use mail link"
					});
					$scope.formData = {object : formData};
				}
			  
					});
			}
		}
		else
		{
			alert(" Fill all details");
		}
		  
	  };
	// View Data from Database
	  $http.post('/orga/product/getAll').then(function(response) {
			$scope.data = response.data;
			if ($scope.data.successful) {
				$scope.userdetails = $scope.data.responseObject;
			} else {
				alert("Can't view the Data");            
			}
		}, function(errResponse) {
			console.error('Error while viewing notes');
		});
	  
	  
		//Get Data from Database based on Name
		$scope.getById = function(username) {
			alert(username);
			 //$("#pa").hide();
			$http.post('/myspring/register/getById', username).then(
					function(response) {
						console.log(response.data);
						$scope.data = response.data;
						console.log($scope.data);
						if ($scope.data.successful) {
							$scope.data = {
								object : $scope.data.responseObject
							};
							
						} else {
							alert("Error while getting data");
						}
					}, function(errResponse) {
						console.error('Error while fetching notes');
					});
		};

	  
}]);                             