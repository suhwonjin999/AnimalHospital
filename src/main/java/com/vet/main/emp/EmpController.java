package com.vet.main.emp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/emp/*")
@Slf4j
public class EmpController {

	@Autowired
	EmpService empService = new EmpService();
	
	public void getEmp(@AuthenticationPrincipal EmpVO empVO) {
		
		String empNo = empVO.getEmpNo();
		String password = empVO.getPassword();
	}
	
	// 로그인 페이지
	
	@GetMapping("login")
	public String getLogin(@ModelAttribute EmpVO empVO)throws Exception{
		SecurityContext context = SecurityContextHolder.getContext();
		String check = context.getAuthentication().getPrincipal().toString();
		
		if(!check.equals("anonymousUser")) {
			return "redirect:../";
		}
		
		return "emp/login";
	}
	
	@PostMapping("login")
	public String getLogin2(EmpVO empVO, HttpSession session)throws Exception{
		empVO = empService.getLogin(empVO);
		
		if(empVO != null) {
			session.setAttribute("emp", empVO);
			return "redirect:../";
		}
		
		return "./login";
	}
	
	@GetMapping("logout")
	public String getLogout(HttpSession session) throws Exception {

		session.invalidate();
		
		return "redirect:../";
	}
	
	// 마이페이지 수정
	@GetMapping("mypageUpdate")
	public String mypageUpdate(EmpVO empVO, Model model)throws Exception{
		empVO = empService.empDetail(empVO);
		model.addAttribute("vo", empVO);
		return "emp/mypageUpdate";
	}
	
	@PostMapping("mypageUpdate")
	public String mypageUpdate(EmpVO empVO)throws Exception{
		int result = empService.mypageUpdate(empVO);
		
//		return"redirect:emp/mypage?empNo="+empVO.getEmpNo();
		return "redirect:../";
	}
	
	// 비밀번호 수정페이지
	@GetMapping("pwUpdate")
	public String pwUpdate(EmpVO empVO, Model model) throws Exception{
		empVO = empService.empDetail(empVO);
		model.addAttribute("vo", empVO);
		return "emp/pwUpdate";
	}
	
	@PostMapping("pwUpdate")
	public String pwUpdate(EmpVO empVO) throws Exception{
		int result = empService.pwUpdate(empVO);
		return "redirect:../";
	}
	
	// 마이페이지
	
	@GetMapping("mypage")
	public String mypage (EmpVO empVO, Model model) throws Exception{
		empVO = empService.mypage(empVO);
		model.addAttribute("vo",empVO);
		
		return "emp/mypage";
	}

	// 직원 목록
	
	@GetMapping("empList")
	public String empList(Model model)throws Exception{
		List<EmpVO> ar = empService.empList();
		model.addAttribute("list", ar);
		
		return "emp/empList";
	}
	
	// 신규직원 추가 페이지
	
	@GetMapping("empAdd")
	public String empAdd()throws Exception{
		return "emp/empAdd";
	}
	
	@PostMapping("empAdd")
	public String empAdd(EmpVO empVO) throws Exception{
		int result = empService.empAdd(empVO);
		return "redirect:./empList";
	}
	
	// 직원 상세
	@GetMapping("empDetail")
	public String empDetail (EmpVO empVO, Model model) throws Exception{
		empVO = empService.empDetail(empVO);
		model.addAttribute("vo",empVO);
		
		return "emp/empDetail";
	}
	
	// 직원 수정(부서, 직급 수정)
	@GetMapping("empUpdate")
	public String empUpdate(EmpVO empVO, Model model) throws Exception{
		empVO = empService.empDetail(empVO);
		model.addAttribute("vo", empVO);
		return "emp/empUpdate";
	}
	
	@PostMapping("empUpdate")
	public String empUpdate(EmpVO empVO) throws Exception{
		int result = empService.empUpdate(empVO);
		return "redirect:./empList";
	}
	
}
