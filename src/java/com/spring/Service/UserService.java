package com.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;
import com.spring.DAO.UserDAO;
import com.spring.Model.Email;
import com.spring.Model.User;

@Service
public class UserService {
	@Autowired
	EmailService emailService;

	@Autowired  
	private UserDAO userDAO;
	

	Response response = new Response();
	
	public Response add(User userModel) {
		response.setSuccessful(false);
		userDAO.add(userModel);
		response.setSuccessful(true);
		response.setResponseObject(userModel);
		
		Email email = new Email();
		email.setFrom(" <luciferrocky216@gmail.com>");
		email.setTo(userModel.getMail().trim());
		email.setSubject("Orga-Farms Registration ");
		String msg =  "Hi, " +userModel.getFname() + "<br><br>"
				+ " Welcome to OrgaFarms Community"+"<br><br>"+"Thanks for Registering to OrgaFarms" + "<br><br>";
				
				
		       
				
		email.setText(msg);
		emailService.sendHtmlMsg(email);
		return response;
		
	}

	public Response getAll() {
		response.setSuccessful(false);
		List<User> userdetails = userDAO.getAll();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}

	public Response remove(String name)
	{
		response.setSuccessful(false);
		userDAO.remove(name);
		response.setSuccessful(true);
		response.setResponseObject(name);
		return response;
	}

	public Response getById(String username)
	{
		response.setSuccessful(false);
		User singleuserdetails = userDAO.getById(username);
		response.setSuccessful(true);
		response.setResponseObject(singleuserdetails);
		return response;
	}
	
	
	/*public Response forgot(String username)
	{
		 
		response.setSuccessful(false);
		User singleuserdetails = userDAO.forgot(username);
		response.setSuccessful(true);
		response.setResponseObject(singleuserdetails);
		Email email = new Email();
		email.setFrom(" <luciferrocky216@gmail.com>");
		email.setTo(userModel.getMail().trim());
		email.setSubject("Orga-Farms Registration ");
		String msg = "Dear Sir/Madam," + "<br><br>"
				+ " Welcome to OrgaFarms Community"+"<br><br>"+"Thanks Registering to OrgaFarms....";
		      
				
		email.setText(msg);
		emailService.sendHtmlMsg(email);
		return response;
	}*/
	

	public Response updateData(User user)
	{
		response.setSuccessful(false);
		userDAO.updateData(user);
		response.setSuccessful(true);
		response.setResponseObject(user);

		Email email = new Email();
		email.setFrom(" <luciferrocky216@gmail.com>");
		email.setTo(user.getMail().trim());
		email.setSubject("Orga-Farms Registration ");
		String msg = "Hi, "+user.getUsername() + "<br><br>"
				+ " Welcome to OrgaFarms Community"+"<br><br>"+"Updation Completed...."+ "<br><br>";
				
		email.setText(msg);
		emailService.sendHtmlMsg(email);
		
		return response;
	}
	

}
