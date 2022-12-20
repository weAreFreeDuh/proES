package com.icia.myPro.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {

	private int pNum;				// �۳ѹ�
	private String pId;				// �ۼ��� ���̵�
	private String pTitle;			// �ۼ��� ������
	private String pContent;		// �� ����
	private Date pDate;				// �۾� ��¥
	
	private MultipartFile pFile;	// ���ε� ����
	private String pFileName;		// ���� �̸�
	
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