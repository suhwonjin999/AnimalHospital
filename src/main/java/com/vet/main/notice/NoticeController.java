package com.vet.main.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
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
		System.out.println("====컨트롤러 공지사항 등록=====");
		int result = noticeService.setNoticeAdd(noticeVO);
		log.info("noticeVO : {}", noticeVO);
		
		return "redirect:./noticelist";
		
	}
	
	// 공지사항 상세
	@GetMapping("noticeDetail")
	public String noticeDetail( NoticeVO noticeVO,  Model model) throws Exception{
		noticeVO = noticeService.getNoticeDetail(noticeVO);
		model.addAttribute("vo", noticeVO);
		System.out.println(noticeVO.getNoticeNo());
		
		return "board/noticeDetail";
		
	}
	
	// 공지사항 수정
	@GetMapping("noticeUpdate")
	public String setUpdate(NoticeVO noticeVO, Model model) throws Exception{
		noticeVO = noticeService.getNoticeDetail(noticeVO);
		model.addAttribute("vo", noticeVO);
		
		return "board/noticeUpdate";
	}
	
	// DB UPDATE
	@PostMapping("noticeUpdate")
	public String setUpdate(NoticeVO noticeVO) throws Exception{
		int result = noticeService.setUpdate(noticeVO);
		
		return "redirect:./noticeDetail";
	}
	
	
	// 공지사항글 삭제
	@GetMapping("noticeDelete")
	public String setDelete(NoticeVO noticeVO) throws Exception{
		int result = noticeService.setDelete(noticeVO);
		System.out.println("=========="+result);
		
		return "redirect:./noticelist";
	}
	
	
	//익명게시판 목록
	@GetMapping("boardlist")
	public String boardList(Model model) throws Exception{
		return "board/boardList";
	}
	
	
	// 익명게시판글 추가 페이지
	@GetMapping("boardAdd")
	public void boardAdd(Model model) throws Exception{
		
	}
	
	
	

	
	
	

}
