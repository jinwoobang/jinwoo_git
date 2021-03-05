package com.bo.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bo.board.dao.BoardDao;
import com.bo.board.dto.BoardBean;

@Controller
public class BoardController {
	@Resource(name="boardDao")
	private BoardDao dao;
	
	@RequestMapping(value="noticeWriter.do")
	public String insertBoard(BoardBean bean,@RequestParam(value="file")MultipartFile file) {
		System.out.println(bean);
		String loc="C:\\Webproject\\project2\\web\\src\\main\\webapp\\upload\\";		
		FileOutputStream fos=null;
		String filename=file.getOriginalFilename();
		//System.out.println(filename);
		if(filename.length()>0) {
			try {
				fos=new FileOutputStream(new File(loc+filename));
				fos.write(file.getBytes());
				//bean.setFileName(fileName);
				//bean.setFilename(file.getOriginalFilename());
				bean.setFilename(filename);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					fos.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
		dao.insertBoard(bean);
		return "redirect:boardList.do";
	}
	
	@RequestMapping(value="boardList.do")
	public String listBoard(Model model) {
		model.addAttribute("list", dao.selectBoard());
		return "Project/other/notice";
	}
	
	@RequestMapping(value="selectInfo.do")
	public String selectInfo(int no,String job,Model model,String filenamez) {
		if(job!=null && job.equals("ninfo")) {
			dao.updateHitBoard(no);
			//System.out.println(no);
			model.addAttribute("selectInfo",dao.selectInfo(no));
			model.addAttribute("list",dao.selectBoard());
			return "Project/other/noticeInfo";
		}
		return "Project/other/notice";
	}
	
	@RequestMapping(value="boardDelete.do")
	public String deleteBoard(int no) {
		dao.deleteBoard(no);
		return "redirect:boardList.do";
	}
	
	@RequestMapping(value="boardModify.do")
	public String boardModify(Model model,int no) {
		model.addAttribute("list",dao.selectBoard());
		model.addAttribute("selectInfo",dao.selectInfo(no));
		return "Project/other/noticeModify";
	}
	
	@RequestMapping(value="Modifyboard.do")
	public String modifyBoard(BoardBean bean,Model model,int no,@RequestParam(value="file")MultipartFile file,String filemod) {
		System.out.println(bean);
		System.out.println(no);
		System.out.println(filemod);
		String loc="C:\\Webproject\\project2\\web\\src\\main\\webapp\\upload\\";		
		FileOutputStream fos=null;
		
		if(filemod!=null) {
			//String filename=filemod;
			bean.setFilename(filemod);
		}
		
		String filename=file.getOriginalFilename();
		//System.out.println(filename);
		if(filename.length()>0) {
			try {
				fos=new FileOutputStream(new File(loc+filename));
				fos.write(file.getBytes());
				//bean.setFileName(fileName);
				//bean.setFilename(file.getOriginalFilename());
				bean.setFilename(filename);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					fos.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
	
		dao.ModifyBoard(bean);
		return "redirect:boardList.do"; 
		//System.out.println(bean);
	}
	
	@RequestMapping(value="new.do")
	public String newOrder(Model model) {
		//dao.orderNew();
		model.addAttribute("list",dao.orderNew());
		return "Project/other/notice";
	}
	
	@RequestMapping(value="old.do")
	public String oldOrder(Model model) {
		model.addAttribute("list",dao.orderOld());
		return "Project/other/notice";
	}
	
	@RequestMapping(value="noticeSearch.do")
	public String noticeSearch(String search, Model model) {
		System.out.println(search);
		model.addAttribute("list", dao.searchBoard(search));
		return "Project/other/notice";
	}
		
}
	


