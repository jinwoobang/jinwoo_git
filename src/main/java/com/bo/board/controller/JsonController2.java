package com.bo.board.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bo.board.dao.BoardDao;

@RestController
public class JsonController2 {
	@Resource(name="boardDao")
	private BoardDao dao;
	
	/*@RequestMapping(value="noticeSearch.do")
	public String boardSearch(String data) {
		System.out.println(data);
		//System.out.println(list);
		//return "Project/example";
		return "okay";
	}*/
}
