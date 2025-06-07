package com.spring.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.spring.Model.RegisterForm;

@Repository
public class RegisterDAO extends BaseDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public void add1(RegisterForm msgModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", msgModel);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("message.Insert", params);
		sqlSession.close();
	}

	
	
	public List<RegisterForm> getAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<RegisterForm> RegisterDetails=sqlSession.selectList("message.getAll");
		sqlSession.close();
		return RegisterDetails;
	}

	/*public void remove(String username)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("RegistrationForm.deleteData",username);
		sqlSession.close();
	}

	public RegisterForm getById(String username)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RegisterForm singleuserdetails=sqlSession.selectOne("RegistrationForm.getById",username);
		sqlSession.close();
		return singleuserdetails;
		
	}

	public void updateData(RegisterForm registerform)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", registerform);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("RegistrationForm.updateData",params);
		sqlSession.close();
	}
*/
}