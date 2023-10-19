package com.vet.main.approval.format;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApFormatService {

	@Autowired
	private ApFormatDAO apFormatDAO;
	
	public int setFormatAdd(ApFormatVO apFormatVO) throws Exception{
		log.info("apFormatNo : {}", apFormatVO.getApFormatNo());
		int result = apFormatDAO.setFormatAdd(apFormatVO);
		
		return result;
	}

	public List<ApFormatVO> getFormatList(ApFormatVO apFormatVO) {
		return apFormatDAO.getFormatList(apFormatVO);
	}
	
	public ApFormatVO getFormatDetail(ApFormatVO apFormatVO) throws Exception {
		return apFormatDAO.getFormatDetail(apFormatVO);
	}

	public int setFormatUpdate(ApFormatVO apFormatVO, HttpSession session) {
		return apFormatDAO.setFormatUpdate(apFormatVO);
	}
}
