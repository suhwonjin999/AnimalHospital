package com.vet.main.approval;

import java.net.http.HttpRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.vet.main.commons.Pager;
import com.vet.main.emp.EmpVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/approval/*")
@Slf4j
public class ApprovalController {

	@Autowired
	private ApprovalService approvalService;
	
		
	@GetMapping("apAdd/{apKind}")
	public String setApPoomAdd(@PathVariable String apKind, ApprovalVO approvalVO, Model model, EmpVO empVO) throws Exception {
		empVO = approvalService.getApUser(empVO);
		
		log.info("====== empVO : {} ======", empVO);
				
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		String date = now.format(formatter);

		model.addAttribute("user", empVO);
		model.addAttribute("date", date);
		
		if(apKind.equals("poomAdd")) {
			
			log.info("================= apKind : {} ====================", apKind);
			log.info("================= empVO : {} ====================", empVO);
			
			return "approval/poomAdd";
		}
		
		return null;
	}
	
	@PostMapping("poomAdd")
	public String setApPoomAdd(ApprovalVO approvalVO) throws Exception {
		
		log.info("==================== Poom Insert ======================");
		log.info("====== Poom : {} ======", approvalVO);
//		log.info("files : {}", files[0].getOriginalFilename());
		
		int result = approvalService.setApPoomAdd(approvalVO);
		
		return "redirect:./draftList/" + approvalVO.getUserName();
	}
	
	
	// 작성버튼 클릭 시 나오는 양식 선택 리스트
	@GetMapping("formatList")
	public String getFormatList() throws Exception {
		return "approval/formatList";
	}
	
	// 기안함 리스트
	@GetMapping("draftList/{userName}")
	public String getDraftList(@PathVariable String userName, Pager pager, Model model) throws Exception {
		List<ApprovalVO> ar = approvalService.getDraftList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		log.info("=========== getDraftList : {} ===========", ar);
		
		return "approval/draftList";
	}
	
	@GetMapping("detail")
	public String getApDetail(ApprovalVO approvalVO, Model model) throws Exception {

		approvalVO = approvalService.getApDetail(approvalVO);
		
		log.info("=============== detail 정보 : {} ================", approvalVO);
		
		if(approvalVO.getApKind().equals("품의서")) {
			
			model.addAttribute("approvalVO", approvalVO);
			
			return "approval/poomDetail";			
		}
		
		return null;	
	}
	
}
