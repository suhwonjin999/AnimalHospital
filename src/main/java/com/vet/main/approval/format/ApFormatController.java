package com.vet.main.approval.format;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/apFormat/*")
@Slf4j
public class ApFormatController {

	@Autowired
	private ApFormatService apFormatService;
	
	
	@GetMapping("add")
	public String setFormatAdd() throws Exception {
		return "apFormat/add";
	}
	
	@PostMapping("add")
	public String setFormatAdd(ApFormatVO apFormatVO) throws Exception {
		
		log.info("apFormatVO : {}", apFormatVO);
		int result = apFormatService.setFormatAdd(apFormatVO);
		
		return "redirect:./list";
	}
	
	
	@GetMapping("list")
	public String getList(ApFormatVO apFormatVO, Model model) throws Exception {
		List<ApFormatVO> ar = apFormatService.getFormatList(apFormatVO);
		model.addAttribute("list", ar);
		
		log.info("getFormatList 실행");
		
		return "apFormat/list";
	}
	
	
	@GetMapping("detail")
	public String getFormatDetail(ApFormatVO apFormatVO, Model model) throws Exception {
		apFormatVO = apFormatService.getFormatDetail(apFormatVO);
		model.addAttribute("apFormatVO", apFormatVO);
		
		return "apFormat/detail";
	}
	
	
	@GetMapping("update")
	public String setFormatUpdate(ApFormatVO apFormatVO, Model model) throws Exception {
		apFormatVO = apFormatService.getFormatDetail(apFormatVO);
		model.addAttribute("vo", apFormatVO);

		return "apFormat/update";
	}

	
	@PostMapping("update")
	public String setFormatUpdate(ApFormatVO apFormatVO) throws Exception {
		int result = apFormatService.setFormatUpdate(apFormatVO);

		return ("redirect:./detail?apFormatNo=" + apFormatVO.getApFormatNo());
	}
	
}
