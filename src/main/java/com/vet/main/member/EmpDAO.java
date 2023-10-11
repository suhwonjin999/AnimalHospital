package com.vet.main.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpDAO {

	public EmpVO getEmp (EmpVO empVO)throws Exception; 
	
}
