package com.icia.myPro.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.myPro.dao.BoardDAO;
import com.icia.myPro.dto.BoardDTO;

@Service
public class BoardService {

	private ModelAndView mav = new ModelAndView();
	
	@Autowired
	private BoardDAO dao;
	
	// 게시글 작성
	public ModelAndView PWrite(BoardDTO board) throws IllegalStateException, IOException {
		
		System.out.println("[2] controller -> service 변수 : "+board);
		
		// (1) 파일정보 가져오기
		MultipartFile pFile = board.getpFile();

		// (2) 파일이름 설정하기
		UUID uuid = UUID.randomUUID();

		System.out.println("uuid 확인 : " + uuid.toString().substring(0, 8));

		// 만약에 업로드 파일이 없다면
		if (pFile != null) {

			// 랜던한 식별문자 uuid.toString().subString(0,8)과 실제 파일이름을 합친 것
			String fileName = uuid.toString().substring(0, 8) + "_" + pFile.getOriginalFilename();

			// board 객체에 생성한 파일이름을 업로드한 파일 이름을 저장한다
			board.setpFileName(fileName);

			// 저장 경로에 파일을 업로드한다.
			String savePath = "C:/Users/user/Desktop/3.9Sping/MyPro/src/main/webapp/resources/fileUpload" + fileName;
			pFile.transferTo(new File(savePath));
		}

		int result = dao.PWrite(board);
		
		System.out.println("[4] dao -> service 변수 : "+result);

		if (result > 0) {
			mav.setViewName("index");
		} else {
			mav.setViewName("pWrite");
		}

		return mav;

	}
	
	//게시글 보기
	public ModelAndView PList() {
		System.out.println("[2] controller -> service 변수 : ");
		
		List<BoardDTO> boardList = dao.PList();
		System.out.println("[4] dao -> service 변수 : "+boardList);
		
		// 변수 설정한 값 보내기
		mav.addObject("boardList",boardList);
		// 사이트 보내기
		mav.setViewName("index");
		
		
		return mav;
	}
	// 게시글 상세보기
	public ModelAndView PView(int bNum) {
		System.out.println("[2] controller -> service 변수 : "+bNum);
		BoardDTO board = dao.PView(bNum);
		
		System.out.println("[4] dao -> service 변수 : "+board);
		
		// 변수값 보내기
		mav.addObject("board",board);
		// 사이트 보내기
		mav.setViewName("pView");
		
		
		return mav;
	}
	
	// 게시글 수정하기
	public ModelAndView PModifyForm(int bNum) {
		System.out.println("[2] controller -> service 변수 : "+bNum);
		BoardDTO board = dao.PView(bNum);
		
		System.out.println("[4] dao -> service 변수 : "+board);
		
		// 변수값 보내기
		mav.addObject("board",board);
		// 사이트 보내기
		mav.setViewName("pModifyForm");
		
		
		return mav;
	}
	
	// 게시글 수정하기
	public ModelAndView PModify(BoardDTO board) throws IllegalStateException, IOException {
		
		System.out.println("[2] controller -> service 변수 : "+board);
		
		// (1) 파일정보 가져오기
		MultipartFile pFile = board.getpFile();

		// (2) 파일이름 설정하기
		UUID uuid = UUID.randomUUID();

		System.out.println("uuid 확인 : " + uuid.toString().substring(0, 8));

		// 만약에 업로드 파일이 없다면
		if (pFile != null) {

			// 랜던한 식별문자 uuid.toString().subString(0,8)과 실제 파일이름을 합친 것
			String fileName = uuid.toString().substring(0, 8) + "_" + pFile.getOriginalFilename();

			// board 객체에 생성한 파일이름을 업로드한 파일 이름을 저장한다
			board.setpFileName(fileName);

			// 저장 경로에 파일을 업로드한다.
			String savePath = "C:/Users/user/Desktop/3.9Sping/MyPro/src/main/webapp/resources/fileUpload" + fileName;
			pFile.transferTo(new File(savePath));
		}

		int result = dao.PModify(board);
		
		System.out.println("[4] dao -> service 변수 : "+result);

		if (result > 0) {
			mav.setViewName("redirect:/PList");
		} else {
			mav.setViewName("index");
		}

		return mav;

	}



}
