package com.vet.main.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmpService  {

	@Autowired
	private EmpDAO empDAO;
	
	public int mypageUpdate(EmpVO empVO)throws Exception{
		int result = empDAO.mypageUpdate(empVO);
		
		return result;
	}
	
	// 비밀번호 변경
	public int pwUpdate(EmpVO empVO)throws Exception{
		int result = empDAO.pwUpdate(empVO);
		
		return result;
	}

	
	// 마이페이지
	public EmpVO mypage(EmpVO empVO) throws Exception{
		return empDAO.mypage(empVO);
	}

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
	

	
	// 사원 관리(직원 목록)
	public List<EmpVO> empList()throws Exception{
		return empDAO.empList();
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
