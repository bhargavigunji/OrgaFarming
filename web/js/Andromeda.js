var Andromeda = {

	showPage : function(path, targetDiv) {
		var jqxhr = jQuery.post(path, function(data) {
			jQuery("#" + targetDiv).html(data);
		});
	},

	showHome : function() {  
		var path = "/orga/html/home.html";
		Andromeda.showPage(path, "amdContainerDiv");
	},

	showAbout : function() {
		var path = "/orga/html/about.html";
		Andromeda.showPage(path, "replaceDiv");
	},
	
	showProduct : function() {
		var path = "/orga/html/our-product.html";
		Andromeda.showPage(path, "replaceDiv");
	},
	showFarmingPractice : function() {
		var path = "/orga/html/farming-practice.html";
		Andromeda.showPage(path, "replaceDiv");
	},
	
	showNews : function() {
		var path = "/orga/html/news.html";
		Andromeda.showPage(path, "replaceDiv");
	},
	showContact : function() {
		var path = "/orga/html/contact.html";
		Andromeda.showPage(path, "replaceDiv");
	},
	
	showLogin : function() {
		var path = "/orga/html/login.html";
		Andromeda.showPage(path, "replaceDiv");
	},
	
	showRegister : function() {
		var path = "/orga/html/register.html";
		Andromeda.showPage(path, "loginDiv");
	},
	showShop : function() {
		var path = "/orga/html/shop.html";
		Andromeda.showPage(path, "replaceDiv");
	},
	showShop1 : function() {
		var path = "/orga/html/shop1.html";
		Andromeda.showPage(path, "replaceDiv");
	},
	showShop2 : function() {
		var path = "/orga/html/shop2.html";
		Andromeda.showPage(path, "replaceDiv");
	},
	showShop3 : function() {
		var path = "/orga/html/shop3.html";
		Andromeda.showPage(path, "replaceDiv");
	},
	showShop4 : function() {
		var path = "/orga/html/shop4.html";  
		Andromeda.showPage(path, "replaceDiv");
	},
	
	showAdminDashboard : function() {
		var path = "/orga/html/admin-dashboard.html";
		Andromeda.showPage(path, "replace");
	},
	showRegistrations : function() {
		var path = "/orga/html/regtable.html";
		Andromeda.showPage(path, "replaceDiv");
	},
	showLogins : function() {
		var path = "/orga/html/logtable.html";
		Andromeda.showPage(path, "replaceDiv");
	},
	showReports : function() {              
		var path = "/orga/html/reports.html";
		Andromeda.showPage(path, "replaceDiv");
	},
	showProducts : function() {
		var path = "/orga/html/reqproducts.html";
		Andromeda.showPage(path, "replaceDiv");
	},
	showFarmerLogin : function() {
		var path = "/orga/html/login-home.html";
		Andromeda.showPage(path, "replace");
	},
	showLoginShop : function() {
		var path = "/orga/html/LoginShop.html";
		Andromeda.showPage(path, "replace");
	},
	showAddProducts : function() {
		var path = "/orga/html/addProducts.html";
		Andromeda.showPage(path, "replaceDiv");
	},
	updateProfile : function() {
		var path = "/orga/html/profile.html";
		Andromeda.showPage(path, "replaceDiv");
	},
	updatePassword : function() {
		var path = "/orga/html/changePassword.html";
		Andromeda.showPage(path, "replaceDiv");
	},
	
	forgotPassword : function() {
		var path = "/orga/html/ForgotPassword.html";
		Andromeda.showPage(path, "login");
	},
	home : function() {
		window.location.reload();             
	},

	setSessionValue : function(key, value) {
		sessionStorage.setItem(key, value);
	},

	getSessionValue : function(key) {
		return sessionStorage.getItem(key);
	},

	removeSessionValue : function(key) {
		sessionStorage.removeItem(key);
	},

	showError : function(errorMessage) {
		var message = "<div class=\"alert alert-danger\"><strong>Error: </strong>"
				+ errorMessage + "</div>";
		jQuery("#errorDiv").html(message);
	},                       

	logout : function() {
		
		var username = Andromeda.getSessionValue("username") || "";
		Andromeda.setSessionValue("userName", null);
		Andromeda.setSessionValue("password", null);
		Andromeda.setSessionValue("type", null);
		var data = {
			username : username
		};  
		Andromeda.post('/orga/login/logout', data);
		Andromeda.showHome();
	},

	post : function(url, data) {
		var responseData = null;

		jQuery.ajax({
			url : url,
			type : 'post',
			data : JSON.stringify(data), // Stringified Json Object
			dataType : 'json',
			async : false, // Cross-domain requests and dataType: "jsonp"
			// requests do not support synchronous operation
			cache : false, // This will force requested pages not to be cached
			// by the browser
			processData : false, // To avoid making query String instead of
			// JSON
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				responseData = data;
			}
		});

		return responseData;
	},

	isUserLoggedIn : function() {
		
		var username = Andromeda.getSessionValue("userName") || "";
		var password = Andromeda.getSessionValue("password") || "";
		var type = Andromeda.getSessionValue("type") || "";

		var login = {
			userName : username,
			password : password,
			type : type,
		};

		return Andromeda.post('/orga/login/loggedin', login) || false;
	}  	
};
