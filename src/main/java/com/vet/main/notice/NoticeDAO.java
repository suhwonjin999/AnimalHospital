package com.vet.main.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vet.main.commons.Pager;

@Mapper
public interface NoticeDAO {
	
	// 공지사항 총합
	public Long getNoticeTotal(Pager pager) throws Exception;
	
	// 공지사항 리스트
	public List<NoticeVO> getNoticeList(Pager pager) throws Exception;
	
	
	// 공지사항글 추가
	
	// 공지사항 상세
		
	// 공지사항 수정
		
	// 공지사항 삭제

}
