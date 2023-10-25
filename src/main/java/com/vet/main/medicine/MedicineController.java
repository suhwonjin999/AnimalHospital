package com.vet.main.medicine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vet.main.commons.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/medicine/*")
@Slf4j
public class MedicineController {

	@Autowired
	private MedicineService medicineService;
	
	//약품목록
	@GetMapping("list")
	public String getList(Pager pager, Model model) throws Exception {
		List<MedicineVO> ar = medicineService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "medicine/list";
	}
	
	//약품추가
	@GetMapping("add")
	public String setAdd() throws Exception {
		
		return "medicine/add";
	}
	
	@PostMapping("add")
	public String setAdd(MedicineVO medicineVO) throws Exception {
		int result = medicineService.setAdd(medicineVO);
		
		return "redirect:./list";
	}
}
