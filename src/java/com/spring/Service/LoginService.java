package com.spring.Service;

import com.spring.Model.Email;
import com.spring.Model.Login;
import com.spring.Model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.andromeda.commons.model.Response;
import com.spring.DAO.LoginDAO;
import com.andromeda.commons.util.AadhaarUtils;
import com.andromeda.commons.util.CryptoUtils;
import com.andromeda.commons.util.IDGenerator;

@Service
public class LoginService
{
	@Autowired
	EmailService emailService;
	
	@Autowired
	private LoginDAO loginDAO;

	

	Response response = new Response();

	public Response login(Login login)
	{
		response.setSuccessful(false);
		
		login.setPassword(login.getPassword());
		Integer userStatus = loginDAO.checkUser(login);

		if (userStatus == 0)
		{
			response.setSuccessful(false);
		}
		else if (userStatus > 0)
		{
			Login details = loginDAO.getUserDetails(login);
			details.setPassword(IDGenerator.getUniqueID());
			details.setIpAddress(login.getIpAddress());
			details.setIpAddress("");

			loginDAO.saveToLogins(details);

			response.setSuccessful(true);
			response.setResponseObject(details);
		}
		
		return response;
	}
	public Response forgot(Login login)
	{
		response.setSuccessful(false);
		
		login.setPassword(login.getPassword());
		Integer userStatus = loginDAO.checkUser1(login);

		if (userStatus == 0)
		{
			response.setSuccessful(false);
		}
		else if (userStatus > 0)
		{
			Login details = loginDAO.forgot(login);             

			
			response.setSuccessful(true);
			response.setResponseObject(details);              
		
		Email email = new Email();
		email.setFrom(" <luciferrocky216@gmail.com>");
		email.setTo(login.getEmail().trim());
		email.setSubject("Orga-Farms Registration ");
		String msg =  "Hi, " +details.getUserName() + "<br><br>"
				+ " Welcome to OrgaFarms Community"+"<br><br>"+"We are always here to assist you..." + "<br><br>"
				+"Your UserName is::"+details.getUserName() + "<br><br>"
				+"Your Password is::"+details.getPassword()+ "<br><br>"
				+"You are registered as  "+details.getType();
				
		       
				
		email.setText(msg);
		emailService.sendHtmlMsg(email);
		}
		return response;
		
	}
	public Response getAll() {
		response.setSuccessful(false);
		List<User> userdetails = loginDAO.getAll();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
  
	public Boolean isUserLoggedIn(Login login)
	{
		Boolean status = false;
		if ((!StringUtils.isEmpty(login.getUserName()))
				&& (!StringUtils.isEmpty(login.getPassword())))
		{
			Integer loginStatus = loginDAO.isUserLoggedIn(login);
			/*System.out.println("-------------------------");
			System.out.println(loginStatus);
			System.out.println("-------------------------");*/
			if (loginStatus == 0)
			{
				status = false;
			}
			else if (loginStatus > 0)
			{
				status = true;
			}
		}

		return status;
	}


	public void logout(String username)
	{
		loginDAO.deleteLoginLog(username);
	}

	

	public Response validateAadhaar(String aadhaar)
	{
		response.setSuccessful(false);

		if (AadhaarUtils.isValidAadhaar(aadhaar))
		{
			response.setSuccessful(true);
		}
		else
		{
			response.setSuccessful(false);
		}
		return response;
	}
}