package com.vet.main.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vet.main.commons.FileManager;
import com.vet.main.commons.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	//spEl
	//properties 값을 java 사용
	//@Value("${properties의 키}")
	@Value("${app.upload}")
	private String uploadPath;
	
	@Value("${app.board.notice}")
	private String NoticeNo;
	
	
	// 공지사항 목록
	public List<NoticeVO> getNoticeList(Pager pager) throws Exception{
		Long totalCount = noticeDAO.getNoticeTotal(pager);
		pager.makeNum(totalCount);
		pager.makeStartRow();
		
		return noticeDAO.getNoticeList(pager);
	}
	
	
	

}
