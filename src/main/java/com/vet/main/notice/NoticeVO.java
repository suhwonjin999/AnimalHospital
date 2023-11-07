package com.vet.main.notice;

import java.sql.Date;
import java.util.List;

import com.vet.main.board.BoardVO;
import com.vet.main.emp.EmpVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class NoticeVO extends BoardVO {
	
	// 공지사항번호
	private Long noticeNo;
	
	// 조회수
	private Long hit;
	
	// 수정일자
	private Date modifyDate;
	
	// 중요 공지글 상단 고정(0: 일반, 1: 중요)
	private Long important;
	
	// 공지사항파일
	private List<NoticeFileVO> fileVOs;
	
	// 작성자
	private String empName ;
	
	// 직급
	private String positionName;

	
	@Override
	public String getContents() {
		// TODO Auto-generated method stub
		return super.getContents();
	}

	@Override
	public Date getCreateDate() {
		// TODO Auto-generated method stub
		return super.getCreateDate();
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return super.getTitle();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	@Override
	public void setContents(String contents) {
		// TODO Auto-generated method stub
		super.setContents(contents);
	}

	@Override
	public void setCreateDate(Date createDate) {
		// TODO Auto-generated method stub
		super.setCreateDate(createDate);
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		super.setTitle(title);
	}

	@Override
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		super.setUsername(username);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	
	
}
