package com.bigdata2019.mysite.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bigdata2019.mysite.vo.UserVo;

@Repository
public class UserRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public UserVo find(Long no){
		return sqlSession.selectOne("user.findByNo", no);
	}
	
	public UserVo find(UserVo vo){
		return sqlSession.selectOne("user.findByEmailAndPassword", vo);
	}
	
	public Boolean insert(UserVo vo) {
		int count = sqlSession.insert("user.insert", vo);
		return count == 1;
	}
}