package com.vet.main.dept;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptDAO {

	public List<DeptVO> getEmpList()throws Exception;
	
	public List<DeptVO> deptList()throws Exception;
	
}
