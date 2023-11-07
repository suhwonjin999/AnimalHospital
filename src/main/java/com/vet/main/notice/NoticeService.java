package com.vet.main.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.vet.main.commons.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	// 공지사항 목록
	public List<NoticeVO> getNoticeList() throws Exception{
		return noticeDAO.getNoticeList();
	}
	
	// 공지사항글 추가 페이지
	public int setNoticeAdd(NoticeVO noticeVO) throws Exception{
		System.out.println("====공지사항 등록=====");
		int result = noticeDAO.setNoticeAdd(noticeVO);
		log.info("noticeVO : {}", noticeVO);
		System.out.println("result="+result);
		
		return result;
	}
	
	// 공지사항 상세 페이지
	public NoticeVO getNoticeDetail(NoticeVO noticeVO) throws Exception{
		return noticeDAO.getNoticeDetail(noticeVO);
	}
	
	// 공지사항글 수정 페이지
	public int setUpdate(NoticeVO noticeVO) throws Exception{
		int result = noticeDAO.setUpdate(noticeVO);
		
		return result;
	}
	
	// 공지사항글 삭제
	public int setDelete(NoticeVO noticeVO) throws Exception{
		return noticeDAO.setDelete(noticeVO);
	}
	

}
