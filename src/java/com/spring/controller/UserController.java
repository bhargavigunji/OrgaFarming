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
import com.spring.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "add", method = { RequestMethod.POST })
	public Response add(@RequestBody User userModel,HttpServletRequest httpServletRequest) throws JSONException
	{
	

		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		userModel.setIpAddress(ipAddress);
		return userService.add(userModel);
	}
	
	

	/*@ResponseBody
	@RequestMapping(value = { "registration" }, method = { RequestMethod.POST })
	public Response registration(@RequestBody User userModel,
			HttpServletRequest httpServletRequest) throws JSONException
	{
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		userModel.setIpAddress(ipAddress);
		return userService.add(userModel);
	}*/
	
	@ResponseBody
	@RequestMapping(value = "getAll", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getAll()
	{
		return userService.getAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "removeData", method = { RequestMethod.POST })
	public Response remove(@RequestBody String name)
	{
		return userService.remove(name);
	}
	
	@ResponseBody
	@RequestMapping(value = "getById", method = { RequestMethod.POST })
	public Response getById(@RequestBody String username)
	{
		return userService.getById(username);
	}
	
	/*@ResponseBody
	@RequestMapping(value = "forgot", method = { RequestMethod.POST })
	public Response forgot(@RequestBody String username)
	{
		return userService.forgot(username);
	}*/
	
	@ResponseBody
	@RequestMapping(value = "updateData", method = { RequestMethod.POST })
	public Response updateData(@RequestBody User user)
	{
		return userService.updateData(user);
	}
}
