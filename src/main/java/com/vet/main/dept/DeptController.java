package com.vet.main.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vet.main.commons.Pager;

@Controller
@RequestMapping("/dept/*")
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	@GetMapping("deptList")
	public String deptList(Model model, Pager pager)throws Exception{
		List<DeptVO> ar = deptService.deptList();
		List<DeptVO> emp = deptService.getEmpList(pager);
		
		model.addAttribute("emp", emp);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "dept/deptList";
	} 
	
//	@GetMapping("deptList/deptAdd")
//	public String deptAdd1(DeptVO deptVO)throws Exception{
//		return "dept/deptAdd";
//	}
	
	@ResponseBody
	@RequestMapping(value = "/deptList/deptAdd", method = RequestMethod.POST)
	public String deptAdd(DeptVO deptVO)throws Exception{
		int result = deptService.deptAdd(deptVO);
		return "redirect: ./deptList";
	}
	
	
}
