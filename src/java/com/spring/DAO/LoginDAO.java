package com.spring.DAO;

import com.spring.Model.Login;
import com.spring.Model.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.andromeda.commons.dao.BaseDAO;

@Repository
public class LoginDAO extends BaseDAO
{

	public Integer checkUser(Login login)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", login);

		Integer userStatus = sqlSessionTemplate.selectOne("Login.checkUser", map);
		return userStatus;
	}

	public Integer checkUser1(Login login)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", login);

		Integer userStatus = sqlSessionTemplate.selectOne("Login.checkUser1", map);
		return userStatus;
	}
	public Login forgot(Login login)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", login);

		Login details = sqlSessionTemplate.selectOne("Login.forgot", map);
		return details;
	}

	public void saveToLogins(Login login)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", login);

		sqlSessionTemplate.insert("Login.saveLogins", map);
	}

	public Login getUserDetails(Login login)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", login);

		Login details = sqlSessionTemplate.selectOne("Login.getUserDetails", map);
		return details;
	}
	public List<User> getAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> userdetails=sqlSession.selectList("Login.getAll");
		sqlSession.close();
		return userdetails;                      
	}

	public Integer isUserLoggedIn(Login login)
	{
		Integer loginStatus = 0;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", login);

	/*	loginStatus = sqlSessionTemplate.selectOne("Login.checkUser", map);*/
		//return userStatus;
		
		Boolean status = Boolean.valueOf(StringUtils.isEmpty(login.getIpAddress()));
		
		if (status.booleanValue())
		{
			loginStatus  = sqlSessionTemplate.selectOne("Login.adminLoggedIn", map);
			/*System.out.println("-------------------------");
			System.out.println(loginStatus);
			System.out.println("-------------------------");*/
			         
		}  
		else
		{
			loginStatus = sqlSessionTemplate.selectOne("Login.collegeLoggedIn", map);
			/*System.out.println("#################################");
			System.out.println(loginStatus);
			System.out.println("########################################");*/
		}
		return loginStatus;
	}

	public void deleteLoginLog(String username)
	{
		sqlSessionTemplate.delete("Login.deleteLoginLog", username);
	}

}