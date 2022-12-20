package com.icia.myPro.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.myPro.dto.BoardDTO;
import com.icia.myPro.service.BoardService;


@Controller
public class BoardController {
	
	private ModelAndView mav = new ModelAndView(); 
	
	@Autowired
	private BoardService bser = new BoardService();
	
	
	// 초기화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start() {

		
		return "index";
	}
	
	// 인덱스 화면
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {

		
		return "index";
	}
	//게시글 쓰는 창 넘어가기 pWriteForm
	@RequestMapping(value = "/pWriteForm", method = RequestMethod.GET)
	public String pWriteForm() {

		return "pWrite";
	}
	//게시글 쓰기 PWrite
	@RequestMapping(value = "/PWrite", method = RequestMethod.POST)
	public ModelAndView PWrite(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
		System.out.println("[1] jsp -> controller 변수 : "+board);
		mav = bser.PWrite(board);
		System.out.println("[5] controller -> service 변수 : "+board);
		return mav;
	}
	
	//게시글 목록 PList
	@RequestMapping(value = "/PList", method = RequestMethod.GET)
	public ModelAndView PList() {
		System.out.println("[1] jsp -> controller 변수 : ");
		mav = bser.PList();
		System.out.println("[5] controller -> service 변수 : ");
		return mav;
	}
	//게시글 상세보기 PView?pNum=${list.pNum}
	@RequestMapping(value = "/PView", method = RequestMethod.GET)
	public ModelAndView pView(@RequestParam("pNum") int bNum) {
		System.out.println("[1] jsp -> controller 변수 : " +bNum);
		mav = bser.PView(bNum);
		System.out.println("[5] controller -> service 변수 : "+bNum);
		return mav;
	}
	
	//게시글 수정하기 사이트 PModifyForm
	@RequestMapping(value = "/PModifyForm", method = RequestMethod.GET)
	public ModelAndView PModifyForm(@RequestParam("pNum") int bNum) {
		System.out.println("[1] jsp -> controller 변수 : " +bNum);
		mav = bser.PModifyForm(bNum);
		System.out.println("[5] controller -> service 변수 : "+bNum);
		return mav;
	}
	//게시글 수정하기 PModify
	@RequestMapping(value = "/PModify", method = RequestMethod.POST)
	public ModelAndView PModify(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
		System.out.println("[1] jsp -> controller 변수 : "+board);
		mav = bser.PModify(board);
		System.out.println("[5] controller -> service 변수 : "+board);
		return mav;
	}
	
	
}
