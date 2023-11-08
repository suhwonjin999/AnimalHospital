package com.vet.main.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String noticeList(Pager pager, Model model) throws Exception{
		List<NoticeVO> ar = noticeService.getNoticeList(pager);
		model.addAttribute("list",ar);
		model.addAttribute("pager", pager);
		
		return "board/noticeList";
	}
	
	

}
