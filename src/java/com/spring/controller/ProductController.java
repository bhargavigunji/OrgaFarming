package com.spring.Controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;
import com.andromeda.commons.util.HttpUtils;
import com.spring.Model.User;
import com.spring.Model.Product;
import com.spring.Service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService pro;
	
	@ResponseBody
	@RequestMapping(value = "add2", method = { RequestMethod.POST })
	public Response add1(@RequestBody Product proModel)
	{
		return pro.add2(proModel);
	}

@ResponseBody
@RequestMapping(value = "getAll", method = { RequestMethod.POST, RequestMethod.GET })
public Response getAll()
{
	return pro.getAll();
}
}
