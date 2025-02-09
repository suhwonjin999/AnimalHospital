package com.vet.main.dept;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vet.main.commons.Pager;

@Mapper
public interface DeptDAO {

	public Long getTotal(Pager pager) throws Exception;
	
	public List<DeptVO> getEmpList(Pager pager)throws Exception;
	
	public List<DeptVO> deptList()throws Exception;
	
	public List<DeptVO> selectDept()throws Exception;
	
	public int deptAdd(DeptVO deptVO)throws Exception;
	
	public int deptUpdate(DeptVO deptVO)throws Exception;
	
	public int deptDelete(DeptVO deptVO)throws Exception;
}
