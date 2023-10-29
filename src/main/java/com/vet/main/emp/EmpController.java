package com.vet.main.emp;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/emp/*")
@Slf4j
public class EmpController {

	@Autowired
	private EmpService empService;
	
	// 로그인 페이지
	
	@GetMapping("login")
	public String getLogin(@ModelAttribute EmpVO empVO)throws Exception{
		//SecurityContext context = SecurityContextHolder.getContext();

		return "emp/login";
	}
	
	@GetMapping("logout")
	public String getLogout(HttpSession session) throws Exception {

		session.invalidate();
		
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
		return "emp/login";
	}
	
	// 마이페이지
	
	@GetMapping("mypage")
	public String mypage (EmpVO empVO, Model model) throws Exception{
		empVO = empService.mypage(empVO);
		model.addAttribute("vo",empVO);
		
		return "emp/mypage";
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
		return "redirect:../";
		
//		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		EmpVO empVO = (EmpVO)obj;
//		log.info("empVO: {}",empVO);
//		return "redirect:../";
	}
	
//	@GetMapping("mypageUpdate")
//	public ModelAndView mypageUpdate(EmpVO empVO)throws Exception{
//		ModelAndView mv = new ModelAndView();
//		empVO = empService.mypage(empVO);
//		
//		mv.addObject("empVO", empVO);
//		mv.setViewName("emp/mypageUpdate");
//		
//		return mv;
//		
//	}
//
//	@PostMapping("mypageUpdate")
//	public int mypageUpdate(ModelAndView mv, EmpVO empVO)throws Exception{
//		int result = empService.mypageUpdate(empVO);
//		
//		return result;
//	}
	
	// 직원 목록
	
	@GetMapping("empList")
	public String empList(Model model)throws Exception{
		List<EmpVO> ar = empService.empList();
		model.addAttribute("list", ar);
		
		return "emp/empList";
	}
	
	// 신규직원 추가 페이지
	
	@GetMapping("empAdd")
	public void empAdd(@ModelAttribute EmpVO empVO)throws Exception{

	}
	
	@PostMapping("empAdd")
	public String empAdd(@Valid EmpVO empVO, BindingResult bindingResult) throws Exception{
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
