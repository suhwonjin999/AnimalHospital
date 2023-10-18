package com.vet.main.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class EmpService {

	@Autowired
	private EmpDAO empDAO;
	
	
	// 로그인 
	public EmpVO getLogin(EmpVO empVO)throws Exception{
		EmpVO loginVO = empDAO.getEmp(empVO);
		
		if(loginVO == null) {
			return loginVO;
		}
		
		if(loginVO.getPassword().equals(empVO.getPassword())) {
			return loginVO;
		}
		
		return null;
	}
	
		
	
	
	// 마이페이지
	
	
	// 사원 관리(직원 목록)
	public List<EmpVO> getEmpList()throws Exception{
		return empDAO.getEmpList();
	}
	
}
