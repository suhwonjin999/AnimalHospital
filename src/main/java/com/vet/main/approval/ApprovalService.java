package com.vet.main.approval;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vet.main.emp.EmpVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApprovalService {
	
	@Autowired
	private ApprovalDAO approvalDAO;
	
	
	// 기안작성폼에 기안자 정보 가져오기
	public EmpVO getApUser(EmpVO empVO) throws Exception {
		return approvalDAO.getApUser(empVO);
	}
		
	// 품의서 작성폼
	public int setApPoomAdd(ApprovalVO approvalVO) throws Exception {
		int result = approvalDAO.setApPoomAdd(approvalVO);
		return result;
	}
	
	// 기안함 리스트
	public List<ApprovalVO> getDraftList(EmpVO empVO) throws Exception {
		return approvalDAO.getDraftList(empVO);
	}

}
