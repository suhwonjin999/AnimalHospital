package com.vet.main.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.vet.main.commons.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/customer/*")
@Slf4j
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//고객목록
	@GetMapping("list")
	public String getList(Pager pager, Model model) throws Exception {
		List<CustomerVO> ar = customerService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "customer/list";
	}
	
	//고객추가
	@GetMapping("add")
	public String setAdd() throws Exception {
		
		return "customer/add";
	}
	
	@PostMapping("add")
	public String setAdd(CustomerVO customerVO, MultipartFile[] files) throws Exception {
		int result = customerService.setAdd(customerVO, files);
		
		return "redirect:./list";
	}
	
	//고객상세
	@GetMapping("detail")
	public String getDetail(CustomerVO customerVO, Model model) throws Exception {
		customerVO = customerService.getDetail(customerVO);
		model.addAttribute("vo", customerVO);
		
		return "customer/detail";
	}
	
	//고객수정
	@GetMapping("update")
	public String setUpdate(CustomerVO customerVO, Model model) throws Exception {
		customerVO = customerService.getDetail(customerVO);
		model.addAttribute("vo", customerVO);
		
		return "customer/update";
	}
	
	@PostMapping("update")
	public String setUpdate(CustomerVO customerVO, MultipartFile[] files) throws Exception {
		int result = customerService.setUpdate(customerVO, files);
		
		return "redirect:./list";
	}
	
	//고객삭제
	@GetMapping("delete")
	public String setDelete(CustomerVO customerVO) throws Exception {
		int result = customerService.setDelete(customerVO);
		
		return "redirect:./list";
	}

}
