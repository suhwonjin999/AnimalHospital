package com.vet.main.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.vet.main.commons.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board/*")
@Slf4j
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	 
	// 공지사항 목록
	@GetMapping("noticelist")
	public String noticeList(Model model) throws Exception {
		List<NoticeVO> ar = noticeService.getNoticeList();
		model.addAttribute("list", ar);
		
		return "board/noticeList";
	}
	
	// 공지사항글 추가 페이지
	@GetMapping("noticeAdd")
	public void noticeAdd(Model model) throws Exception{
		
	}
	
	// DB INSERT
	@PostMapping("noticeAdd")
	public String noticeAdd(NoticeVO noticeVO) throws Exception{
		log.info("noticeVO : {}", noticeVO);
		int result = noticeService.setNoticeAdd(noticeVO);
		
		return "redirect:./noticelist";
		
	}
	
	
	

}
