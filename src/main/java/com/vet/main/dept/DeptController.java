package com.vet.main.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dept/*")
public class DeptController {

	@Autowired
	private DeptService deptService;
	
//	@GetMapping("deptEmpList")
//	public String getEmpList(Model model) throws Exception{
//		List<DeptVO> emp = deptService.getEmpList();
//		model.addAttribute("emp", emp);
//		
//		return "dept/deptList";
//	}
	
	@GetMapping("deptList")
	public String deptList(Model model)throws Exception{
		List<DeptVO> ar = deptService.deptList();
		List<DeptVO> emp = deptService.getEmpList();
		
		model.addAttribute("list", ar);
		model.addAttribute("emp", emp);
		
		return "dept/deptList";
	} 
	
}
