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
	
	// 게시글 작성
	public int PWrite(BoardDTO board) {
		System.out.println("[3] sevice -> dao 변수 : "+board);
		return sql.insert("Board.PWrite",board);
	}
	
	// 게시글 목록
	public List<BoardDTO> PList() {
		System.out.println("[3] sevice -> dao 변수 : ");
		return sql.selectList("Board.PList");
	}
	
	// 게시글 상세보기
	public BoardDTO PView(int bNum) {
		System.out.println("[3] sevice -> dao 변수 : "+bNum);
		return sql.selectOne("Board.pView",bNum);
	}

	// 게시글 수정
	public int PModify(BoardDTO board) {
		System.out.println("[3] sevice -> dao 변수 : "+board);
		return sql.update("Board.PModify",board);
	}


	

}
