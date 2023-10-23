package com.vet.main.approval;

import org.apache.ibatis.annotations.Mapper;

import com.vet.main.emp.EmpVO;

@Mapper
public interface ApprovalDAO {

	// 기안작성폼에 기안자 정보 가져오기
	public EmpVO getApUser(EmpVO empVO) throws Exception;

	// 품의서 작성폼
	public int setApPoomAdd(ApprovalVO approvalVO) throws Exception;
	
	
}
