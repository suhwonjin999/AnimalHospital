package com.vet.main.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vet.main.emp.EmpVO;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("list")
	public void getList(Model model)throws Exception{
//		List<AdminVO> ar = adminService.getEmpList();
//		model.addAttribute("list",ar);
//		return "list";
	}
}
