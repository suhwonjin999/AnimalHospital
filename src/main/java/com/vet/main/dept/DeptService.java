package com.vet.main.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptService {

	@Autowired
	private DeptDAO deptDAO;
	
	
	public List<DeptVO> getEmpList()throws Exception{
		return deptDAO.getEmpList();
	}
	
	public List<DeptVO> deptList()throws Exception{
		return deptDAO.deptList();
	}
	
}
