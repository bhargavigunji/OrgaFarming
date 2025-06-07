
var Registration = angular.module('RegistrationModule', []);
Registration.controller('RegistrationController', ['$http','$scope', function($http, $scope) {
	
	
			// User Registration Module
			/*$scope.registration = function(UserData) {
				alert(UserData.fname + ' Registration Successful');
				$http.post('/orga/user/add', UserData).then(
						function(response) {
							$scope.data = response.data;
							if ($scope.data.successful) {
								location.reload();
								alert("User Data Inserted Successfully");
							} else {
								alert("Data not inserted");
							}
						}, function(errResponse) {
							console.error('Error while fetching notes');
						});
			};*/
			  $scope.validateAadhaar1 = function(aadhaar,id) {
				   Andromeda.setSessionValue("aadhaar",aadhaar);
			        if(aadhaar == 0 || aadhaar.length != 12 || aadhaar==undefined){
			              alert("Invalid aadhaar number!");
			              $("#"+id).val('');
			              $("#"+id).attr("disabled", false);
			         }
			         else if(aadhaar != null && aadhaar.length == 12){
			             $http.post('/orga/user/add',aadhaar).then(function(response){
			                 $scope.data1  = response.data;
			                 if($scope.data1.successful){
			                    //$("#"+id).attr("disabled", true);
			                 }else{
			                     $("#"+id).attr("disabled", false);
			                     alert("Invalid aadhaar number!");
			                     $("#"+id).val('');
			                 }
			             },
			             function(errResponse){   
			                 console.log("Error checking aadhaar validity");
			             });
			         }
			         else{
			              alert("Enter aadhaar number");
			         }
			        };
			     
			   
			        
			   
			//Get Data from Database based on Name
			        username=Andromeda.getSessionValue("userName");
				$http.post('/orga/user/getById', username).then(
						function(response) {
							$scope.data = response.data;
							if ($scope.data.successful) {
								$scope.data={object:$scope.data.responseObject};
							} else {
								alert("Error while getting data");
							}
						}, function(errResponse) {
							console.error('Error while fetching notes');
						});
				
				/* $scope.forgot = function(username) {
				$http.post('/orga/user/forgot', username).then(
						function(response) {
							$scope.data = response.data;
							if ($scope.data.successful) {
								$scope.data={object:$scope.data.responseObject};
							} else {
								alert("Error while getting data");
							}
						}, function(errResponse) {
							console.error('Error while fetching notes');
						});
				 }*/
				
			
			//Update User Details                
		$scope.updateData = function(UserData){
				alert(UserData.username);
				$http.post('/orga/user/updateData', UserData).then(
						function(response) {
							$scope.data = response.data;
							if ($scope.data.successful) {
								alert("User Details Successfully updated");
							} else {
								alert("Data not updated");
							}
						}, function(errResponse) {
							console.error('Error while fetching notes');
						});
			};

		/*	// View Data from Database
			$scope.getAll = function(UserData){
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
			};*/

			// Delete UserData based on Name
		$scope.removeData = function(name) {
				$http.post('/orga/user/removeData', name).then(
						function(response) {
							$scope.data = response.data;
							if ($scope.data.successful) {
								location.reload();
								alert("User Data removed Successfully");
							} else {
								alert("Data not Deleted");
							}
						}, function(errResponse) {
							console.error('Error while fetching notes');
						});
			};
			
			
			
			
			
			
			
			
			
			
			
			$scope.registration = function(data){
				 
				 if(data != undefined)
					{
						if(data.fname == null || data.fname == undefined || data.fname == "")
						{
							alert(" Enter first name");
						}
						else if(data.lname == null || data.lname == undefined || data.lname == "")
						{
							alert(" Enter last name");
						}
						else if(data.mail == null || data.mail == undefined || data.mail == "")
						{
							alert(" Enter email ID");
						}
						else if(data.aadhaar == null || data.aadhaar == undefined || data.aadhaar == "")
						{
							alert(" Enter aadhaar number");
						}
						else if(data.username == null || data.username == undefined || data.username == "")
						{
							alert(" Enter user name");
						}
				
						else if(data.password == null || data.password == undefined || data.password == "")
						{
							  alert(" Enter password");
						}
						
						else if(data.confirmpassword == null || data.confirmpassword == undefined || data.confirmpassword == "")
						{
						  alert(" Please confirm your password");
						}
						else if(data.type == null || data.type == undefined || data.type == "") {
						  alert(" Select your type");
						}
						 
						else
						{
				 
							 alert("Please wait a while for completing the process ");
					  console.log(data);
					  
					  $http.post('/orga/user/add',data).then(function(response)
								{
			
						  $scope.data = response.data;
							if($scope.data.successful)
							{
								
								alert("Thank you for registering.. Please check your mail. ");
								
						}
							else
							{
								alert({
									title	:	" ",
									text	:	"Your subscription is already completed.For further registration you can use mail link"
								});
								$scope.data = {object : data};
							}
						  
								});
						}
					}
					else
					{
						alert(" Fill all details");
					}
					  
				  };
				  
				  
				  
				  $scope.updateData = function(data){
						 
						 if(data != undefined)
							{
								if(data.fname == null || data.fname == undefined || data.fname == "")
								{
									alert(" Enter first name");
								}
								else if(data.lname == null || data.lname == undefined || data.lname == "")
								{
									alert(" Enter last name");
								}
								else if(data.mail == null || data.mail == undefined || data.mail == "")
								{
									alert(" Enter email ID");
								}
								
								else if(data.username == null || data.username == undefined || data.username == "")
								{
									alert(" Enter user name");
								}
						
								else if(data.password == null || data.password == undefined || data.password == "")
								{
									  alert(" Enter password");
								}
								
								
								else if(data.type == null || data.type == undefined || data.type == "") {
								  alert(" Select your type");
								}
								 
								else
								{
						 
									
									alert("Please wait a while for completing the process ");
							  
									console.log(data);
							  
							  $http.post('/orga/user/updateData',data).then(function(response)
										{
					
								  $scope.data = response.data;
									if($scope.data.successful)
									{
										
										alert("Profile Updated.. Please check your mail. ");
										
								}
									else
									{
										alert({
											title	:	" ",
											text	:	"Your subscription is already completed.For further registration you can use mail link"
										});
										$scope.data = {object : data};
									}
								  
										});
								}
							}
							else
							{
								alert(" Fill all details");
							}
							  
						  };
			
		
		} ]);

		
