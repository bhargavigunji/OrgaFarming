package com.spring.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.spring.Model.Product;
import com.spring.Model.User;

@Repository
public class ProductDAO extends BaseDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public void add2(Product proModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", proModel);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("product.Insert", params);
		sqlSession.close();
	}
	public List<User> getAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> userdetails=sqlSession.selectList("product.getAll");
		sqlSession.close();
		return userdetails;                      
	}

}

	