package com.vet.main.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmpService implements UserDetailsService{

	@Autowired
	private EmpDAO empDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void registerUser(EmpVO empVO) {
	    String hashedPassword = passwordEncoder.encode(empVO.getPassword());
	    String empNo = empVO.getEmpNo();
	    empVO.setPassword(hashedPassword);
	    empVO.setEmpNo(empNo);
	    empDAO.save(empVO);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String empNo) throws UsernameNotFoundException {
		log.info("=========로그인 시도 중==========");
		EmpVO empVO = new EmpVO();
		empVO.setEmpNo(empNo);
		try {
			empVO = empDAO.getEmp(empVO);
		} catch (Exception e) {
			e.printStackTrace();
			empVO=null;
		}
		
		return empVO;
	}

	//마이페이지 수정
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
	@Transactional(rollbackFor = Exception.class)
	public int empAdd(EmpVO empVO) throws Exception{
		empVO.setPassword(passwordEncoder.encode(empVO.getPassword()));
		empVO.setEnabled(true);
		int result = 0;
		
		result = empDAO.empAdd(empVO);
		
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
