package com.vet.main.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.vet.main.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/customer/*")
@Slf4j
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("list")
	public String getList(Pager pager, Model model) throws Exception {
		List<CustomerVO> ar = customerService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "customer/list";
	}
	
	@GetMapping("add")
	public String setAdd() throws Exception {
		
		return "customer/add";
	}
	
	@PostMapping("add")
	public String setAdd(CustomerVO customerVO, MultipartFile[] files) throws Exception {
		int result = customerService.setAdd(customerVO, files);
		
		return "redirect:./list";
	}

}
