package com.bo.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.bo.board.dto.BoardBean;

public class BoardDao extends SqlSessionDaoSupport {
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public void insertBoard(BoardBean bean) {
		this.getSqlSession().insert("insertBoard",bean);
	}
	
	public List<BoardBean>selectBoard(){
		return this.getSqlSession().selectList("selectBoard");
	}
	
	public List<BoardBean> searchBoard(String search){
		return this.getSqlSession().selectList("searchBoard", search);
	}
	
	public BoardBean selectInfo(int no) {
		return this.getSqlSession().selectOne("selectInfo",no);
	}
	
	public void deleteBoard(int no) {
		this.getSqlSession().delete("deleteBoard",no);
	}
	
	public void updateHitBoard(int no) {
		this.getSqlSession().update("updateHitBoard",no);
	}
	
	public void ModifyBoard(BoardBean bean) {
		this.getSqlSession().update("ModifyBoard", bean);
	}
	
	public void ModifyBoard2(BoardBean bean) {
		this.getSqlSession().update("ModifyBoard2",bean);
	}
	
	public List<BoardBean> orderNew() {
		return this.getSqlSession().selectList("orderNew");
	}
	
	public List<BoardBean> orderOld(){
		return this.getSqlSession().selectList("orderOld");
	}

}
