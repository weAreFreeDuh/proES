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
	
	// �Խñ� �ۼ�
	public ModelAndView PWrite(BoardDTO board) throws IllegalStateException, IOException {
		
		System.out.println("[2] controller -> service ���� : "+board);
		
		// (1) �������� ��������
		MultipartFile pFile = board.getpFile();

		// (2) �����̸� �����ϱ�
		UUID uuid = UUID.randomUUID();

		System.out.println("uuid Ȯ�� : " + uuid.toString().substring(0, 8));

		// ���࿡ ���ε� ������ ���ٸ�
		if (pFile != null) {

			// ������ �ĺ����� uuid.toString().subString(0,8)�� ���� �����̸��� ��ģ ��
			String fileName = uuid.toString().substring(0, 8) + "_" + pFile.getOriginalFilename();

			// board ��ü�� ������ �����̸��� ���ε��� ���� �̸��� �����Ѵ�
			board.setpFileName(fileName);

			// ���� ��ο� ������ ���ε��Ѵ�.
			String savePath = "C:/Users/user/Desktop/3.9Sping/MyPro/src/main/webapp/resources/fileUpload" + fileName;
			pFile.transferTo(new File(savePath));
		}

		int result = dao.PWrite(board);
		
		System.out.println("[4] dao -> service ���� : "+result);

		if (result > 0) {
			mav.setViewName("index");
		} else {
			mav.setViewName("pWrite");
		}

		return mav;

	}
	
	//�Խñ� ����
	public ModelAndView PList() {
		System.out.println("[2] controller -> service ���� : ");
		
		List<BoardDTO> boardList = dao.PList();
		System.out.println("[4] dao -> service ���� : "+boardList);
		
		// ���� ������ �� ������
		mav.addObject("boardList",boardList);
		// ����Ʈ ������
		mav.setViewName("index");
		
		
		return mav;
	}
	// �Խñ� �󼼺���
	public ModelAndView PView(int bNum) {
		System.out.println("[2] controller -> service ���� : "+bNum);
		BoardDTO board = dao.PView(bNum);
		
		System.out.println("[4] dao -> service ���� : "+board);
		
		// ������ ������
		mav.addObject("board",board);
		// ����Ʈ ������
		mav.setViewName("pView");
		
		
		return mav;
	}
	
	// �Խñ� �����ϱ�
	public ModelAndView PModifyForm(int bNum) {
		System.out.println("[2] controller -> service ���� : "+bNum);
		BoardDTO board = dao.PView(bNum);
		
		System.out.println("[4] dao -> service ���� : "+board);
		
		// ������ ������
		mav.addObject("board",board);
		// ����Ʈ ������
		mav.setViewName("pModifyForm");
		
		
		return mav;
	}
	
	// �Խñ� �����ϱ�
	public ModelAndView PModify(BoardDTO board) throws IllegalStateException, IOException {
		
		System.out.println("[2] controller -> service ���� : "+board);
		
		// (1) �������� ��������
		MultipartFile pFile = board.getpFile();

		// (2) �����̸� �����ϱ�
		UUID uuid = UUID.randomUUID();

		System.out.println("uuid Ȯ�� : " + uuid.toString().substring(0, 8));

		// ���࿡ ���ε� ������ ���ٸ�
		if (pFile != null) {

			// ������ �ĺ����� uuid.toString().subString(0,8)�� ���� �����̸��� ��ģ ��
			String fileName = uuid.toString().substring(0, 8) + "_" + pFile.getOriginalFilename();

			// board ��ü�� ������ �����̸��� ���ε��� ���� �̸��� �����Ѵ�
			board.setpFileName(fileName);

			// ���� ��ο� ������ ���ε��Ѵ�.
			String savePath = "C:/Users/user/Desktop/3.9Sping/MyPro/src/main/webapp/resources/fileUpload" + fileName;
			pFile.transferTo(new File(savePath));
		}

		int result = dao.PModify(board);
		
		System.out.println("[4] dao -> service ���� : "+result);

		if (result > 0) {
			mav.setViewName("redirect:/PList");
		} else {
			mav.setViewName("index");
		}

		return mav;

	}



}
