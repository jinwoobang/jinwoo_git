package com.bo.login.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.bo.login.dto.MemberBean;

public class ResiDao extends SqlSessionDaoSupport {
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public void insertMember(MemberBean bean) {
		this.getSqlSession().insert("insertMember",bean);
	}
	
	public boolean idCheck(String id) {
		String check=this.getSqlSession().selectOne("idCheck",id);
		return check!=null&&check.equals(id)?true:false;
	}
	
	public boolean loginCheck(String id,String pw) {
		String check=this.getSqlSession().selectOne("loginCheck",id);
		return check!=null&&check.equals(pw)?true:false;
	}
	
	

}
