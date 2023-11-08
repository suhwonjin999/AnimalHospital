package com.vet.main.notice;

import java.sql.Date;
import java.util.List;

import com.vet.main.board.BoardVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class NoticeVO extends BoardVO{
	
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
	private String empName;
	
	// 직급
	private String positionName;
	
}
