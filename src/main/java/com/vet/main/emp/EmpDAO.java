package com.vet.main.emp;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpDAO {

	public EmpVO getEmp (EmpVO empVO)throws Exception; 
	
}
