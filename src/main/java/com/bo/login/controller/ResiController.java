package com.bo.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bo.login.dao.ResiDao;
import com.bo.login.dto.MemberBean;

@Controller
public class ResiController {
	@Resource(name="resiDao")
	private ResiDao dao;
	
	@RequestMapping(value="membership.do")
	public String membership(MemberBean bean) {
		System.out.println(bean);
		dao.insertMember(bean);
		return "Project/other/joinEnd";
	}
	
	@RequestMapping(value="logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "Project/index";
	}
	
}
