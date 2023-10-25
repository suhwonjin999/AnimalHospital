package com.vet.main.emp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpDAO {

	public EmpVO getEmp (EmpVO empVO)throws Exception; 
	
	public EmpVO getLogin(String empNo)throws Exception;
	
	public EmpVO mypage(EmpVO empVO)throws Exception;
	
	public int mypageUpdate(EmpVO empVO)throws Exception;
	
	public List<EmpVO> empList()throws Exception;
	
	public int empAdd(EmpVO empVO) throws Exception;
	
	public EmpVO empDetail(EmpVO empVO)throws Exception;
	
	public int empUpdate(EmpVO empVO)throws Exception;
	
	public int pwUpdate(EmpVO empVO)throws Exception;

	public void save(EmpVO empVO);
	
	//public int empRole(Map<String, Object> map)throws Exception; //회원가입시 권한 부여하는 것
}
