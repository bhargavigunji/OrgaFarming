package com.spring.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.Model.User;

@Repository
public class UserDAO extends BaseDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public void add(User userModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", userModel);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("User.Insert", params);
		sqlSession.close();
	}

	public List<User> getAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> userdetails=sqlSession.selectList("User.getAll");
		sqlSession.close();
		return userdetails;                      
	}

	public void remove(String name)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("User.deleteData",name);
		sqlSession.close();
	}

	public User getById(String username)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User singleuserdetails=sqlSession.selectOne("User.getById",username);
		sqlSession.close();
		return singleuserdetails;
		
	}
	 
	/*public User forgot(String username)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User singleuserdetails=sqlSession.selectOne("User.forgot",username);
		sqlSession.close();
		return singleuserdetails;
		
	}*/
	


	public void updateData(User user)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", user);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("User.updateData",params);
		sqlSession.close();
	}

}
