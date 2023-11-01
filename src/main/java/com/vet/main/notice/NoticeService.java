package com.vet.main.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vet.main.commons.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	// 공지사항 목록
	public List<NoticeVO> getNoticeList() throws Exception{
		return noticeDAO.getNoticeList();
	}
	
	// 공지사항글 추가 페이지
	public int setNoticeAdd(NoticeVO noticeVO) throws Exception{
		int result = noticeDAO.setNoticeAdd(noticeVO);
		return result;
	}

}
