package com.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;
import com.spring.DAO.ProductDAO;
import com.spring.Model.Email;
import com.spring.Model.Product;
import com.spring.Model.User;


@Service
public class ProductService {
	
	Response response = new Response();
	@Autowired
	EmailService emailService;

	@Autowired
	private ProductDAO productDAO;

	public Response add2(Product proModel) {
		response.setSuccessful(false);
		productDAO.add2(proModel);
		response.setSuccessful(true);
		response.setResponseObject(proModel);
		Email email = new Email();
		email.setFrom(" <luciferrocky216@gmail.com>");
		email.setTo(proModel.getEmail().trim());
		email.setSubject("Orga-Farms Registration ");
		String msg = "Hi, " +proModel.getName()+ "<br><br>"
				+ " Welcome to OrgaFarms Community"+"<br><br>"+"Thanks For adding your products  "+proModel.getProduct()+ " with price "+proModel.getPrice()+" to our ORGA FARMS"+ "<br><br>"
				+ "We have Recevied your Request... Very Soon we Will add your Product to our Store.....";
				
		 
				
		email.setText(msg);
		emailService.sendHtmlMsg(email);
		return response;
	}
	public Response getAll() {
		response.setSuccessful(false);
		List<User> userdetails = productDAO.getAll();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response; 
	}                       
}                                           