package com.icia.myPro.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.myPro.dto.BoardDTO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	// �Խñ� �ۼ�
	public int PWrite(BoardDTO board) {
		System.out.println("[3] sevice -> dao ���� : "+board);
		return sql.insert("Board.PWrite",board);
	}
	
	// �Խñ� ���
	public List<BoardDTO> PList() {
		System.out.println("[3] sevice -> dao ���� : ");
		return sql.selectList("Board.PList");
	}
	
	// �Խñ� �󼼺���
	public BoardDTO PView(int bNum) {
		System.out.println("[3] sevice -> dao ���� : "+bNum);
		return sql.selectOne("Board.pView",bNum);
	}

	// �Խñ� ����
	public int PModify(BoardDTO board) {
		System.out.println("[3] sevice -> dao ���� : "+board);
		return sql.update("Board.PModify",board);
	}


	

}
