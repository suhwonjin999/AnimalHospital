package com.vet.main.notice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/board/*")
public class NoticeController {
	
//	@Autowired
//	private NoticeService noticeService;
	 
	// 공지사항 목록
	@GetMapping("noticelist")
	public String board(Model model) throws Exception {
		
		return "board/noticeList";
	}
	
	
	

}
