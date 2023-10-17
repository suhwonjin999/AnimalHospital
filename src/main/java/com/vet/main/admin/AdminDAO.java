package com.vet.main.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vet.main.emp.EmpVO;

@Mapper
public interface AdminDAO {

	public List<AdminVO> getEmpList()throws Exception;
	
}
