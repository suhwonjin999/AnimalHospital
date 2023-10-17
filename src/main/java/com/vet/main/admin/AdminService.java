package com.vet.main.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vet.main.emp.EmpVO;

@Service
public class AdminService {

	@Autowired
	private AdminDAO adminDAO;
	
	// 전체 직원 목록
	
	public List<AdminVO> getEmpList()throws Exception{
		return adminDAO.getEmpList();
	}
	
}
