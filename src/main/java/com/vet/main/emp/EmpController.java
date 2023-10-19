package com.vet.main.emp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("login")
	public void getLogin(@ModelAttribute EmpVO empVO)throws Exception{

	}
	
	@PostMapping("login")
	public String getLogin(EmpVO empVO, HttpSession session)throws Exception{
		empVO = empService.getLogin(empVO);
		
		if(empVO != null) {
			session.setAttribute("emp", empVO);
			return "redirect:../";
		}
		
		return "./login";
	}
	
	// 마이페이지
	
	@GetMapping("mypage")
	public void getMypage() throws Exception{
		
	}
	
	// 직원 목록
	
	@GetMapping("empList")
	public String getEmpList(Model model)throws Exception{
		List<EmpVO> ar = empService.getEmpList();
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
