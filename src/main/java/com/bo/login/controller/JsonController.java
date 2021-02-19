package com.bo.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bo.login.dao.ResiDao;

@RestController
public class JsonController {
	@Resource(name="resiDao")
	private ResiDao dao;
	
	@RequestMapping(value="idcheck.do")
	public String idCheck(String id,HttpSession session) {
		if(dao.idCheck(id)) {
			return "success";
		}else {
			return "fail";	
		}
	}
	
	@RequestMapping(value="login.do")
	public String loginCheck(String id,String pw,HttpSession session) {
		if(dao.loginCheck(id, pw)) {
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			return "success";
		}else {
			return "fail";
		}
	}
}
