package com.vet.main.emp;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpDAO {

	public EmpVO getEmp (EmpVO empVO)throws Exception; 
	
	public EmpVO mypage(EmpVO empVO)throws Exception;
	
	public List<EmpVO> empList()throws Exception;
	
	public int empAdd(EmpVO empVO) throws Exception;
	
	public EmpVO empDetail(EmpVO empVO)throws Exception;
	
	public int empUpdate(EmpVO empVO)throws Exception;
	
	public int pwUpdate(EmpVO empVO)throws Exception;
}
