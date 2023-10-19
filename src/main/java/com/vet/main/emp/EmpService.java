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
	
	// 신규직원 등록
	public int empAdd(EmpVO empVO) throws Exception{
		int result = empDAO.empAdd(empVO);
		
		return result;
	}
	
	// 직원 상세
	public EmpVO empDetail(EmpVO empVO) throws Exception{
		
		return empDAO.empDetail(empVO);
	}
	
	// 직원 수정
	public int empUpdate(EmpVO empVO) throws Exception{
		int result = empDAO.empUpdate(empVO);
		
		return result;
		
		
	}
	
	
}
