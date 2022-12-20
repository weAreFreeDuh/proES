package com.icia.myPro.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {

	private int pNum;				// 글넘버
	private String pId;				// 작성자 아이디
	private String pTitle;			// 작성한 글제목
	private String pContent;		// 글 내용
	private Date pDate;				// 글쓴 날짜
	
	private MultipartFile pFile;	// 업로드 파일
	private String pFileName;		// 파일 이름
	
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getpTitle() {
		return pTitle;
	}
	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}
	public String getpContent() {
		return pContent;
	}
	public void setpContent(String pContent) {
		this.pContent = pContent;
	}
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	public MultipartFile getpFile() {
		return pFile;
	}
	public void setpFile(MultipartFile pFile) {
		this.pFile = pFile;
	}
	public String getpFileName() {
		return pFileName;
	}
	public void setpFileName(String pFileName) {
		this.pFileName = pFileName;
	}
	@Override
	public String toString() {
		return "BoardDTO [pNum=" + pNum + ", pId=" + pId + ", pTitle=" + pTitle + ", pContent=" + pContent + ", pDate="
				+ pDate + ", pFile=" + pFile + ", pFileName=" + pFileName + "]";
	}
	
	
}