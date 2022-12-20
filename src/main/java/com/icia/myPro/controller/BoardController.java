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
	
	
	// �ʱ�ȭ��
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start() {

		
		return "index";
	}
	
	// �ε��� ȭ��
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {

		
		return "index";
	}
	//�Խñ� ���� â �Ѿ�� pWriteForm
	@RequestMapping(value = "/pWriteForm", method = RequestMethod.GET)
	public String pWriteForm() {

		return "pWrite";
	}
	//�Խñ� ���� PWrite
	@RequestMapping(value = "/PWrite", method = RequestMethod.POST)
	public ModelAndView PWrite(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
		System.out.println("[1] jsp -> controller ���� : "+board);
		mav = bser.PWrite(board);
		System.out.println("[5] controller -> service ���� : "+board);
		return mav;
	}
	
	//�Խñ� ��� PList
	@RequestMapping(value = "/PList", method = RequestMethod.GET)
	public ModelAndView PList() {
		System.out.println("[1] jsp -> controller ���� : ");
		mav = bser.PList();
		System.out.println("[5] controller -> service ���� : ");
		return mav;
	}
	//�Խñ� �󼼺��� PView?pNum=${list.pNum}
	@RequestMapping(value = "/PView", method = RequestMethod.GET)
	public ModelAndView pView(@RequestParam("pNum") int bNum) {
		System.out.println("[1] jsp -> controller ���� : " +bNum);
		mav = bser.PView(bNum);
		System.out.println("[5] controller -> service ���� : "+bNum);
		return mav;
	}
	
	//�Խñ� �����ϱ� ����Ʈ PModifyForm
	@RequestMapping(value = "/PModifyForm", method = RequestMethod.GET)
	public ModelAndView PModifyForm(@RequestParam("pNum") int bNum) {
		System.out.println("[1] jsp -> controller ���� : " +bNum);
		mav = bser.PModifyForm(bNum);
		System.out.println("[5] controller -> service ���� : "+bNum);
		return mav;
	}
	//�Խñ� �����ϱ� PModify
	@RequestMapping(value = "/PModify", method = RequestMethod.POST)
	public ModelAndView PModify(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
		System.out.println("[1] jsp -> controller ���� : "+board);
		mav = bser.PModify(board);
		System.out.println("[5] controller -> service ���� : "+board);
		return mav;
	}
	
	
}
