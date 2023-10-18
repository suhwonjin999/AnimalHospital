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
	public void setEmpAdd()throws Exception{
		
	}
	
}
