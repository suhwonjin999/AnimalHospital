package com.vet.main.approval;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vet.main.commons.FileManager;
import com.vet.main.commons.Pager;
import com.vet.main.emp.EmpVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApprovalService {
	
	@Autowired
	private ApprovalDAO approvalDAO;
	
	@Autowired
	private FileManager fileManager;
	
	// spEl
	// properties 값을 java 사용
	// @Value("${properties의 키}")
	@Value("${app.upload}")	// !!!롬복 어노테이션 아님!!!
	private String uploadPath;
	
	@Value("${app.approval}")
	private String apKind;
	
	
	// 기안작성폼에 기안자 정보 가져오기
	public EmpVO getApUser(EmpVO empVO) throws Exception {
		return approvalDAO.getApUser(empVO);
	}
		
	// 품의서 작성폼
	public int setApPoomAdd(ApprovalVO approvalVO, MultipartFile[] files) throws Exception {
		int result = approvalDAO.setApPoomAdd(approvalVO);
		
		for(MultipartFile multipartFile : files) {
			
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			ApprovalFileVO fileVO = new ApprovalFileVO();
			String fileName = fileManager.save(this.uploadPath + this.apKind, multipartFile);
			fileVO.setApNo(approvalVO.getApNo());
			fileVO.setFileName(fileName);
			fileVO.setOriginalFileName(multipartFile.getOriginalFilename());
			
			result = approvalDAO.setApFileAdd(fileVO);
		}
		
		return result;
	}
	
	// 기안함 리스트
	public List<ApprovalVO> getDraftList(Pager pager) throws Exception {
		Long totalCount = approvalDAO.getTotal(pager);
		pager.makeNum(totalCount);
		pager.makeStartRow();
		return approvalDAO.getDraftList(pager);
	}
	
	public ApprovalVO getApDetail(ApprovalVO approvalVO) throws Exception {
		return approvalDAO.getApDetail(approvalVO);
	}
	
}
